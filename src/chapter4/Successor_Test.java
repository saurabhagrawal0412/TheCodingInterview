package chapter4;

public class Successor_Test {

	public static void main(String[] args) {
		ValidateBST_Test test = new ValidateBST_Test() ;
		BinarySearchTreeNode_4_5 root = test.createBST_4_5() ;
		
		SuccessorFinder finder = new SuccessorFinder() ;
		BinarySearchTreeNode_4_5 successor = finder.findSuccessor(root.rChild()) ;
		if(successor != null)
			System.out.println("Successor = " + successor.key()) ;
		else
			System.out.println("Successor not found") ;
	}

}

class SuccessorFinder {
	public BinarySearchTreeNode_4_5 findSuccessor(BinarySearchTreeNode_4_5 curr) {
		
		if(curr == null)
			return null ;
		
		if(curr.rChild() != null)
			return curr.rChild() ;
		
		while(! isLeftChild(curr) && curr.parent() != null) {
			System.out.println("Inside while") ;
			curr = curr.parent() ;
		}
		return curr.parent() ;
	}

	public boolean isLeftChild(BinarySearchTreeNode_4_5 curr) {
		if(curr == null) {
			System.out.println("Curr is null ") ;
			return false ;
		}
		
		if( (curr.parent() != null) && (curr.parent().lChild() != null) && (curr.parent().lChild() == curr) )
			return true ;
		else
			return false;
		
		/*if(curr.parent() != null ) {
		if(curr.parent().lChild() != null) {
			if(curr.parent().lChild() == curr)
				return true ;
			else
				return false ;
		}
		else
			return false ;
	}	*/
	}
	
}
