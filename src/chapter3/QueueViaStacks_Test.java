package chapter3;

public class QueueViaStacks_Test {

	public static void main(String[] args) {
		QueueViaStacks queue = new QueueViaStacks(5) ;
		
		try {
			for(int i=3 ; i>=1 ; i--)
				queue.enqueue(i) ;
			
			for(int i=1 ; i<=2 ; i++)
				System.out.println(queue.dequeue() ) ;
			
			for(int i=200 ; i<=800 ; i*=2)
				queue.enqueue(i) ;
			
			for(int i=1 ; i<=6 ; i++)
				System.out.println(queue.dequeue() ) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

}

class QueueViaStacks {
	
	private Stack6 pushStack, popStack ;
	
	public QueueViaStacks(int length) {
		int[] stack = new int[length] ;
		pushStack = new Stack6(stack, -1, true) ;
		popStack = new Stack6(stack, -1, false) ;
	}
	
	public void enqueue(int element) throws StackFullException {
		if(pushStack.isEmpty() )
			popStack.push(element) ;
		
		pushStack.push(element) ;
	}
	
	public int dequeue() throws StackEmptyException {
		return popStack.pop() ;
	}
}

class Stack6 {

	private int[] stack ;
	private int head ;
	private boolean isIncrement ;
	
	public Stack6(int[] stack, int head, boolean isIncrement) {
		this.stack = stack ;
		this.head = head ;
		this.isIncrement = isIncrement ;
	}
	
	public void push(int element) throws StackFullException {
		
		if(head == -1) {
			head = 0 ;
			stack[head] = element ;
			return ;
		}
		
		if(! isFull() ) {
			int increment = (isIncrement) ? 1 : -1 ;
			head = head + increment ;
			stack[head] = element ;
		}
		else
			throw new StackFullException() ;
	}
	
	public int pop() throws StackEmptyException {
		if(! isEmpty() ) {
			int element = stack[head] ;
			int decrement = (isIncrement) ? 1 : -1 ;
			head = head - decrement ;
			
			if( isEmpty() )
				head = -1 ;
			return element ;
		}
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isFull() {
		if((isIncrement && head == stack.length - 1) || (! isIncrement && head == 0))
			return true ;
		else
			return false ;
	}
	
	public boolean isEmpty() {
		if(head < 0 || head >= stack.length)
			return true ;
		else
			return false ;
	}
}
