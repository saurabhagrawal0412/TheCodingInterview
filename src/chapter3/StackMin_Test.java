package chapter3 ;

import java.util.Random ;

public class StackMin_Test {

	public static void main(String[] args) {
		StackMin stack = new StackMin(5) ;
		Random rand = new Random() ;
		
		try {
			for(int i=0 ; i<6 ; i++)
				stack.push(rand.nextInt(4) + 1) ;
			
			for(int i=0 ; i<5 ; i++) {
				System.out.println(stack.peek()) ;
				System.out.println(stack.min()) ;
				stack.pop() ;
			}
			
			System.out.println(stack.isEmpty()) ;
			stack.pop() ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

}

class StackMin {
	
	private int[][] elements ;
	private int head ;
	
	public StackMin(int length) {
		elements = new int[length][2] ;
		head = -1 ;
	}
	
	public void push(int element) throws StackFullException {
		if(! isFull() ) {
			head++ ;
			elements[head][0] = element ;
			
			if(head == 0)
				elements[head][1] = element ;
			else
				elements[head][1] = (element<elements[head-1][1]) ?
											element : elements[head-1][1] ;
			
		}
		else
			throw new StackFullException() ;
	}
	
	public boolean isFull() {
		if(head == elements.length-1)
			return true ;
		else
			return false ;
	}
	
	public void pop() throws StackEmptyException {
		if(! isEmpty() )
			head-- ;
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isEmpty() {
		if(head == -1)
			return true ;
		else
			return false ;
	}
	
	public int min() throws StackEmptyException {
		if(! isEmpty() )
			return elements[head][1] ;
		else
			throw new StackEmptyException() ;
	}
	
	public int peek() throws StackEmptyException {
		if(! isEmpty() )
			return elements[head][0] ;
		else
			throw new StackEmptyException() ;
	}
}
