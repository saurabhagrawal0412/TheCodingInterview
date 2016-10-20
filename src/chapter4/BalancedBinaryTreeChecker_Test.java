package chapter4;

public class BalancedBinaryTreeChecker_Test {

	public static void main(String[] args) {
		
		BalancedBinaryTreeChecker_Test obj = new BalancedBinaryTreeChecker_Test() ;
		BinaryTreeNode_4_4 root = obj.generateTree() ;
		System.out.println("Inorder") ;
		obj.printInOrder(root) ;
		System.out.println("Preorder") ;
		obj.printPreOrder(root) ;
		
		BalancedBinaryTreeChecker checker = new BalancedBinaryTreeChecker() ;
		
		try {
			System.out.println(checker.isBalanced(root)) ;
		}
		catch (InvalidBinaryTreeException e) {
			e.printStackTrace();
		}
	}

	private BinaryTreeNode_4_4 generateTree() {
		BinaryTreeNode_4_4 root = new BinaryTreeNode_4_4(0) ;
		BinaryTreeNode_4_4 l1_child1 = new BinaryTreeNode_4_4(1) ;
		BinaryTreeNode_4_4 l1_child2 = new BinaryTreeNode_4_4(2) ;
		root.setlChild(l1_child1) ;
		root.setrChild(l1_child2) ;
		l1_child1.setParent(root) ;
		l1_child2.setParent(root) ;
		
		BinaryTreeNode_4_4 l2_child1 = new BinaryTreeNode_4_4(3) ;
		BinaryTreeNode_4_4 l2_child2 = new BinaryTreeNode_4_4(4) ;
		BinaryTreeNode_4_4 l2_child3 = new BinaryTreeNode_4_4(5) ;
		BinaryTreeNode_4_4 l2_child4 = new BinaryTreeNode_4_4(6) ;
		l1_child1.setlChild(l2_child1) ;
		l1_child1.setrChild(l2_child2) ;
		l1_child2.setlChild(l2_child3) ;
		l1_child2.setrChild(l2_child4) ;
		/*l2_child1.setParent(l1_child1) ;
		l2_child2.setParent(l1_child1) ;
		l2_child3.setParent(l1_child2) ;
		l2_child4.setParent(l1_child2) ;*/
		
		BinaryTreeNode_4_4 l3_child1 = new BinaryTreeNode_4_4(7) ;
		l2_child3.setrChild(l3_child1) ;
		BinaryTreeNode_4_4 l4_child1 = new BinaryTreeNode_4_4(8) ;
		l3_child1.setrChild(l4_child1) ;
		
		
		return root ;
	}
	
	private void printInOrder(BinaryTreeNode_4_4 root) {
		if(root.lChild() != null)
			printInOrder(root.lChild()) ;
		System.out.println("Value = " + root.key()) ;
		if(root.rChild() != null)
			printInOrder(root.rChild()) ;
	}
	
	private void printPreOrder(BinaryTreeNode_4_4 root) {
		System.out.println("Value = " + root.key()) ;
		if(root.lChild() != null)
			printPreOrder(root.lChild()) ;
		if(root.rChild() != null)
			printPreOrder(root.rChild()) ;
	}

}

class BalancedBinaryTreeChecker {
	public boolean isBalanced(BinaryTreeNode_4_4 root) throws InvalidBinaryTreeException {
		if(root == null)
			throw new InvalidBinaryTreeException() ;
		System.out.println("Root = " + root.key()) ;
		boolean isBalanced = true ;
		
		if(root.lChild() != null) {
			System.out.println("Root's left child: " + root.lChild().key()) ;
			isBalanced = isBalanced(root.lChild()) ;
			if(! isBalanced)
				return false ;
		}
		
		if(root.rChild() != null) {
			System.out.println("Root's right child: " + root.rChild().key()) ;
			isBalanced = isBalanced(root.rChild()) ;
			if(! isBalanced)
				return false ;
		}
		
		getHeight(root) ;
		isBalanced = ( (int)Math.abs ( root.lHeight()-root.rHeight() ) <= 1) ? true : false ;
		return isBalanced ;
	}

	private void getHeight(BinaryTreeNode_4_4 node) {
		int maxHeight ;
		BinaryTreeNode_4_4 tempNode ;
		
		if(node.lChild() != null) {
			tempNode = node.lChild() ;
			maxHeight = (tempNode.lHeight() > tempNode.rHeight() ? tempNode.lHeight() : tempNode.rHeight() ) ;
			node.setlHeight(1+maxHeight) ;
		}
		
		if(node.rChild() != null) {
			tempNode = node.rChild() ;
			maxHeight = (tempNode.lHeight() > tempNode.rHeight() ? tempNode.lHeight() : tempNode.rHeight() ) ;
			node.setrHeight(1+maxHeight) ;
		}
		
		System.out.println("Node = " + node.key()) ;
		System.out.println("Left height=" + node.lHeight() + " Right height=" + node.rHeight()) ;
	}
}

class BinaryTreeNode_4_4 {
	private int key ;
	private BinaryTreeNode_4_4 parent ;
	private BinaryTreeNode_4_4 lChild, rChild ;
	private int lHeight=0, rHeight=0 ;
	
	public BinaryTreeNode_4_4(int key) {
		this.key = key;
	}

	public BinaryTreeNode_4_4 parent() {
		return parent;
	}

	public void setParent(BinaryTreeNode_4_4 parent) {
		this.parent = parent;
	}

	public BinaryTreeNode_4_4 lChild() {
		return lChild;
	}

	public void setlChild(BinaryTreeNode_4_4 lChild) {
		lChild.setParent(this) ;
		this.lChild = lChild;
	}

	public BinaryTreeNode_4_4 rChild() {
		return rChild;
	}

	public void setrChild(BinaryTreeNode_4_4 rChild) {
		rChild.setParent(this) ;
		this.rChild = rChild;
	}

	public int lHeight() {
		return lHeight;
	}

	public void setlHeight(int lHeight) {
		this.lHeight = lHeight;
	}

	public int rHeight() {
		return rHeight;
	}

	public void setrHeight(int rHeight) {
		this.rHeight = rHeight;
	}

	public int key() {
		return key;
	}
}

@SuppressWarnings("serial")
class InvalidBinaryTreeException extends Exception {
	public String getMessage() {
		return "Invalid binary tree" ;
	}
}