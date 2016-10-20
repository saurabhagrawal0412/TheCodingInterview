package chapter3;

public class Queue_Array_Test {
	
	public static void main(String[] args) {
		Queue_Array queue = new Queue_Array(5) ;
		try {
			queue.insert(5) ;
			queue.insert(7) ;
			queue.delete() ;
			System.out.println(queue.peek()) ;
			queue.delete() ;
			System.out.println(queue.isEmpty()) ;
			//System.out.println(queue.peek()) ;
			
			for(int i=10 ; i<=15 ; i++)
				queue.insert(i) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}
}

class Queue_Array {
	
	private int head ;
	private int tail ;
	private int[] elements ;
	
	public Queue_Array(int length) {
		elements = new int[length] ;
		head = -1 ;
		tail = -1 ;
	}
	
	public void insert(int element) throws Queue_Array_Full_Exception {
		if(! isFull() ) {
			head = next() ;
			elements[head] = element ;
			
			if(tail == -1) {
				tail = 0 ;
			}
		}
		else
			throw new Queue_Array_Full_Exception() ;
	}

	public boolean isFull() {
		if(next() == tail)
			return true ;
		else
			return false ;
	}
	
	private int next() {
		return ( (head+1) % elements.length ) ;
	}
	
	public void delete() throws Queue_Array_Empty_Exception {
		if(! isEmpty() ) {
			if(head == tail) {
				head = -1 ;
				tail = -1 ;
			}
			else
				tail = previous() ;
		}
		else
			throw new Queue_Array_Empty_Exception() ;
	}

	public boolean isEmpty() {
		if(tail == -1)
			return true ;
		else
			return false ;
	}
	
	private int previous() {
		if(tail==9)
			return 0 ;
		else if(tail==0 && head == 0)
			return -1 ;
		else
			return (tail+1) ;
	}
	
	public int peek() throws Queue_Array_Empty_Exception {
		if(! isEmpty())
			return elements[head] ;
		else
			throw new Queue_Array_Empty_Exception() ;
	}
}

@SuppressWarnings("serial")
class Queue_Array_Full_Exception extends Exception {
	public String getMessage() {
		return "Queue is full" ;
	}
}

@SuppressWarnings("serial")
class Queue_Array_Empty_Exception extends Exception {
	public String getMessage() {
		return "Queue is empty" ;
	}
}