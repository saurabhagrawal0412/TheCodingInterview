package chapter3;

public class ThreeStacksTest {

	public static void main(String[] args) {
		try {
			ThreeStacks threeStacks = new ThreeStacks(9) ;
			
			for(int i=0 ; i<9 ; i++)
				threeStacks.push(i%3, i) ;
			
			int arrayNo ;
			for(int i=0 ; i<9 ; i++)
			{
				arrayNo = i%3 ;
				System.out.println( threeStacks.peek(arrayNo) ) ;
				threeStacks.pop(arrayNo) ;
				System.out.println( threeStacks.isEmpty(arrayNo) ) ;
			}
			
			threeStacks.pop(1) ;
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
	}

}

class ThreeStacks {
	
	private int[] elements ;
	private int[] heads ;
	
	public ThreeStacks(int length) throws IncorrectLengthException {
		if(length%3 != 0 )
			throw new IncorrectLengthException() ;
		else {
			elements = new int[length] ;
			heads = new int[3] ;
			
			for(int i=0 ; i<3 ; i++)
				heads[i] = -1 ;
		}
	}
	
	public void push(int arrayNo , int element) throws StackFullException {
		if(! isFull(arrayNo) ) {
			elements[getHead(arrayNo)+1] = element ;
			heads[arrayNo] ++ ;
		}
		else
			throw new StackFullException() ;
	}

	public boolean isFull(int arrayNo) {
		if(heads[arrayNo] == (elements.length/3) -1)
			return true ;
		else
			return false ;
	}
	
	private int getHead(int arrayNo) {
		return ( (arrayNo * elements.length/3) + heads[arrayNo] ) ;
	}
	
	public void pop(int arrayNo) throws StackEmptyException {
		if(! isEmpty(arrayNo) )
			heads[arrayNo] -- ;
		else
			throw new StackEmptyException() ;
	}
	
	public boolean isEmpty(int arrayNo) {
		if(heads[arrayNo] == -1)
			return true ;
		else
			return false ;
	}
	
	public int peek(int arrayNo) throws StackEmptyException {
		if(! isEmpty(arrayNo) )
			return elements[getHead(arrayNo)] ;
		else
			throw new StackEmptyException() ;
	}
}

@SuppressWarnings("serial")
class IncorrectLengthException extends Exception {
	public String getMessage() {
		return "Length should be multiple of 3" ;
	}
}

@SuppressWarnings("serial")
class StackFullException extends Exception {
	public String getMessage() {
		return "Stack is full" ;
	}
}

@SuppressWarnings("serial")
class StackEmptyException extends Exception {
	public String getMessage() {
		return "Stack is empty" ;
	}
}