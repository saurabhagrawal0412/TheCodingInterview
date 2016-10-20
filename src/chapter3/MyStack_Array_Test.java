package chapter3;

public class MyStack_Array_Test {

	public static void main(String[] args) {
		MyStack_Array stack = new MyStack_Array(5) ;
		try {
			stack.push(1) ;
			stack.push(2) ;
			stack.push(3) ;
			stack.pop() ;
			stack.pop() ;
			System.out.println( stack.peek() ) ;
			stack.pop() ;
			System.out.println( stack.isEmpty() ) ;
			stack.peek() ;
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}

class MyStack_Array {
	private int[] elements ;
	private int head ;
	
	public MyStack_Array (int length) {
		elements = new int[length] ;
		head = -1 ;
	}
	
	public void push(int element) throws MyStack_Array_Full_Exception {
		if(head == elements.length-1)
			throw new MyStack_Array_Full_Exception() ;
		else {
			head++ ;
			elements[head] = element ;
		}
	}
	
	public void pop() throws MyStack_Array_Empty_Exception {
		if(! isEmpty() ) {
			head-- ;
		}
		else
			throw new MyStack_Array_Empty_Exception() ;
	}

	public boolean isEmpty() {
		if(head == -1)
			return true ;
		else
			return false ;
	}
	
	public int peek() throws MyStack_Array_Empty_Exception {
		if(! isEmpty() )
			return elements[head] ;
		else
			throw new MyStack_Array_Empty_Exception() ;
	}
}

@SuppressWarnings("serial")
class MyStack_Array_Full_Exception extends Exception {
	public String getMessage() {
		return "Stack is full" ;
	}
}

@SuppressWarnings("serial")
class MyStack_Array_Empty_Exception extends Exception {
	public String getMessage() {
		return "Stack is empty" ;
	}
}