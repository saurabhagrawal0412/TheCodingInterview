package chapter3 ;

public class Queue_DLL_Test {

	public static void main(String[] args) {
		
		Queue_DLL queue = new Queue_DLL() ;
		System.out.println(queue.isEmpty()) ;
		
		try {
			for(int i=1 ; i<=5 ; i++)
				queue.insert(i) ;
			System.out.println(queue.peek()) ;
			
			for(int i=1 ; i<=6 ; i++)
				queue.delete() ;
		}
		catch(EmptyQueueException eqe) {
			eqe.printStackTrace() ;
		}
	}
}

class MyDoublyLinkedList {
	
	private MyDoublyLinkedList prev ;
	private int key ;
	private MyDoublyLinkedList next ;
	
	public MyDoublyLinkedList() {}
	
	public MyDoublyLinkedList(int key) {
		this.key = key ;
	}
	
	public MyDoublyLinkedList(int key , MyDoublyLinkedList next) {
		this.key = key ;
		this.next = next ;
	}
	
	public int key() {
		return this.key ;
	}
	
	public void setKey(int key) {
		this.key = key ;
	}
	
	public MyDoublyLinkedList next() {
		return this.next ;
	}
	
	public void setNext(MyDoublyLinkedList next) {
		this.next = next ;
	}
	
	public MyDoublyLinkedList prev() {
		return this.prev ;
	}
	
	public void setPrev(MyDoublyLinkedList prev) {
		this.prev = prev ;
	}
}

class Queue_DLL {
	
	private MyDoublyLinkedList head=null ;
	private MyDoublyLinkedList tail=null ;
	
	public void insert(int element) {
		if(head == null) {
			head = new MyDoublyLinkedList(element) ;
			tail = head ;
		}
		else {
			MyDoublyLinkedList curr = new MyDoublyLinkedList(element , head) ;
			head.setPrev(curr) ;
			head = curr ;
		}
	}
	
	public void delete() throws EmptyQueueException {
		if(! isEmpty() ) {
			if(head == tail) {
				head = null ;
				tail = null ;
			}
			else {
				tail = tail.prev() ;
			}
		}
		else
			throw new EmptyQueueException() ;
	}

	public boolean isEmpty() {
		if(head == null)
			return true ;
		else
			return false ;
	}
	
	public int peek() throws EmptyQueueException {
		if(! isEmpty() )
			return head.key() ;
		else
			throw new EmptyQueueException() ;
	}
}

@SuppressWarnings("serial")
class EmptyQueueException extends Exception {
	public String getMessage() {
		return "Queue is empty" ;
	}
}