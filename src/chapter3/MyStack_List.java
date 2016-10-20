package chapter3;

public class MyStack_List {
	private MyLinkedList top ;
	
	public void push(int element) {
		if(top == null) {
			top = new MyLinkedList(element) ;
		}
		else {
			MyLinkedList curr = new MyLinkedList(element) ;
			curr.setNext(top) ;
			top = curr ;
			
			System.out.println("top.key = " + top.key()) ;
		}
	}
	
	public void pop() throws EmptyStackException_List {
		if(! isEmpty()) {
			top = top.next() ;
		}
		else
			throw new EmptyStackException_List() ;
	}
	
	public boolean isEmpty() {
		if(top == null)
			return true ;
		else
			return false ;
	}
	
	public int peek() throws EmptyStackException_List {
		if(! isEmpty())
			return top.key() ;
		else
			throw new EmptyStackException_List() ;
	}
}

class MyLinkedList {
	private int key ;
	private MyLinkedList next ;
	
	public MyLinkedList() {}
	
	public MyLinkedList(int key) {
		this.key = key ;
	}
	
	public void setKey(int key) {
		this.key = key ;
	}
	
	public void setNext(MyLinkedList next) {
		this.next = next ;
	}
	
	public int key() {
		return this.key ;
	}
	
	public MyLinkedList next() {
		return this.next ;
	}
}

@SuppressWarnings("serial")
class EmptyStackException_List extends Exception {
	public String getMessage() {
		return "Stack is empty.." ;
	}
}