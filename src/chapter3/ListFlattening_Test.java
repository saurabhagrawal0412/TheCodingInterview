package chapter3;

public class ListFlattening_Test {

	ModifiedDLL head = null, tail = null ;
	
	public static void main(String[] args) {
		
	}

	private void flattenDLL() throws NullInputException {
		if(head == null || tail == null) {
			throw new NullInputException() ;
		}
		flattenDLL(head, null, null) ;
	}

	private void flattenDLL(ModifiedDLL curr, ModifiedDLL prev, ModifiedDLL next) {
		if(prev == null) {
			head = curr ;
		}
		if(curr.child != null) {
			flattenDLL(curr.child, curr, curr.next) ;
			next = curr.next ;
			curr.next = curr.child ;
			curr.child.prev = curr ;
		}
	}
}

class ModifiedDLL {
	int data ;
	ModifiedDLL prev ;
	ModifiedDLL next ;
	ModifiedDLL child ;
	
	ModifiedDLL(int data) {
		this.data = data ;
	}
}