package chapter3;

import java.util.ArrayList;

public class StackOfPlates_Test {

	public static void main(String[] args) {
		
		StackOfPlates plates = new StackOfPlates() ;
		
		try {
			for(int i=1 ; i<=100 ; i++)
				plates.push(i) ;
			for(int i=1 ; i<=50 ; i++)
				System.out.println(plates.popAt(i)) ;
			plates.pop() ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}
}

class StackOfPlates {
	
	private ArrayList<SinglePlateStack> stacks ;
	private int head ;
	
	public StackOfPlates() {
		stacks = new ArrayList<SinglePlateStack>() ;
		head = -1 ;
	}
	
	public void push(int element) {
		
		if(head == -1 || stacks.get(head).getStack().size() >= 5) {
			SinglePlateStack temp = new SinglePlateStack() ;
			temp.push(element) ;
			stacks.add(temp) ;
			head++ ;
		}
		else {
			stacks.get(head).push(element) ;
		}
	}
	
	public int pop() throws StackEmptyException {
		int element ;
		if(! isEmpty(head) ) {
			element = stacks.get(head).pop() ;
			if(stacks.get(head).getStack().size() == 0)
				head-- ;
			return element ;
		}
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isEmpty(int index) {
		if(head == -1 || index > head)
			return true ;
		else
			return false ;
	}
	
	public int popAt(int index) throws InvalidStackIndexException {
		int element ;
		int listNo = index/5 - 1 ;
		int localIndex = index%5 - 1 ;
		if(index > stacks.size()*5-1 || listNo > head)
			throw new InvalidStackIndexException() ;
		else
		{
			element = stacks.get(listNo).popAt(localIndex) ;
			return element ;
		}
	}
}

class SinglePlateStack {
	
	private ArrayList<Integer> stack ;
	private int head ;
	
	public SinglePlateStack() {
		stack = new ArrayList<Integer> () ;
		head = -1 ;
	}
	
	public ArrayList<Integer> getStack() {
		return this.stack ;
	}
	
	public void push(int element) {
		stack.add(element) ;
		head++ ;
	}
	
	public int pop() throws StackEmptyException {
		int element ;
		
		if(! isEmpty(head) ) {
			element = stack.get(head) ;
			stack.remove(head) ;
			head -- ;
			return element ;
		}
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isEmpty(int index) {
		if(head == -1 || stack.size() <= index)
			return true ;
		else
			return false ;
	}
	
	public int popAt(int index) throws InvalidStackIndexException {
		int element ;
		if(! isEmpty(index)) {
			element = stack.get(index) ;
			stack.remove(index) ;
			head -- ;
			return element ;
		}
		else
			throw new InvalidStackIndexException() ;
	}
}

@SuppressWarnings("serial")
class InvalidStackIndexException extends Exception {
	public String getMessage() {
		return "Invalid index was tried to be fetched" ;
	}
}