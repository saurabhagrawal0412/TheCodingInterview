package chapter3;

import java.util.Random;

public class StackSorter_Test {

	public static void main(String[] args) {
		
		StackSorter sorter = new StackSorter() ;
		Stack5 input = new Stack5(5) ;
		Random rand = new Random() ;
		try {
			for(int i=1 ; i<= 5 ; i++)
				input.push(rand.nextInt(200)) ;
		}
		catch(StackFullException e) {
			e.printStackTrace() ;
		}
		
		Stack5 output = sorter.sortStack(input) ;
		
		try {
			while(! output.isEmpty() )
				System.out.println(output.pop() ) ;
		}
		catch(StackEmptyException e) {
			e.printStackTrace() ;
			
		}
	}

}

class Stack5 {
	
	private int[] stack ;
	private int head ;
	
	public Stack5(int length) {
		stack = new int[length] ;
		head = -1 ;
	}
	
	public void push(int element) throws StackFullException {
		if(! isFull() ) {
			head++ ;
			stack[head] = element ;
		}
		else
			throw new StackFullException() ;
	}
	
	public boolean isFull() {
		if(head >= stack.length-1)
			return true ;
		else
			return false ;
	}
	
	public int pop() throws StackEmptyException {
		if(! isEmpty() ) {
			head-- ;
			return stack[head+1] ;
		}
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isEmpty() {
		if(head == -1)
			return true ;
		else
			return false ;
	}
	
	public int peek() throws StackEmptyException {
		if(! isEmpty() )
			return stack[head] ;
		else
			throw new StackEmptyException() ;
	}
	
	public int head() {
		return this.head ;
	}
	
	public int[] stack() {
		return this.stack ;
	}
}

class StackSorter {
	
	public Stack5 sortStack(Stack5 input) {
		
		Stack5 output = new Stack5(input.stack().length) ;
		int buffer ;
		
		try{
			
			while(! input.isEmpty() ) {
				buffer = input.pop() ;
				
				while(! output.isEmpty() && output.peek() < buffer ) {
					input.push(output.pop()) ;
				}
				
				output.push(buffer) ;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		return output ;
	}
}