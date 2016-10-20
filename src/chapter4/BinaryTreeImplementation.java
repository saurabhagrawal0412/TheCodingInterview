package chapter4;

public class BinaryTreeImplementation {

	public static void main(String[] args) {
		
		try {
			BinaryTreeNode root = new BinaryTreeNode(100) ;
			System.out.println(root.getValue()) ;

			BinaryTreeNode c1 = root.addChild(50) ;
			System.out.println(c1.getValue()) ;

			BinaryTreeNode c2 = root.addChild(150) ;
			System.out.println(c2.getValue()) ;
			
			System.out.println("Heights") ;
			root.findHeight(root) ;
			System.out.println(root.getlHeight()) ;
			System.out.println(root.getrHeight()) ;
			
			System.out.println("In-order traversal") ;
			root.inOrderTraverse(root) ;
			
			System.out.println("Pre-order traversal") ;
			root.preOrderTraverse(root) ;
			
			System.out.println("Post-order traversal") ;
			root.postOrderTraverse(root) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

}

class BinaryTreeNode extends TreeNode {
	
	private BinaryTreeNode[] children = null ;
	private int lHeight = 0, rHeight = 0 ;
	private static BinaryTreeNode root ;
	
	public BinaryTreeNode(int value) {
		super(value) ;
		
		if(root == null)
			root = this ;
	}
	
	public int getlHeight() {
		return lHeight ;
	}

	public int getrHeight() {
		return rHeight ;
	}

	public BinaryTreeNode addChild(int value) throws BinaryPropertyViolatedException {
		int nextIndex = nextIndexOf() ;
		
		if(nextIndex <= 1) {
			if(children == null)
				children = new BinaryTreeNode[2] ;
			BinaryTreeNode child = new BinaryTreeNode(value) ;
			children[nextIndex] = child ;
			return child ;
		}
		else
			throw new BinaryPropertyViolatedException() ;
	}
	
	protected int nextIndexOf() {
		int nextIndex = 0 ;
		if(children == null)
			children = new BinaryTreeNode[2] ;
		else {
			for(BinaryTreeNode child : children) {
				if(child != null)
					nextIndex++ ;
			}
		}
		return nextIndex ;
	}
	
	public void findHeight(BinaryTreeNode current) {
		if(current.children != null) {
			int biggerHeight = 0 ;
			if(current.children[0] != null)	{
				findHeight(current.children[0]) ;
				biggerHeight = (current.children[0].lHeight <= current.children[0].rHeight) 
						? rHeight : lHeight ;
				lHeight = 1 + biggerHeight ;
			}
			if(current.children[1] != null)	{
				findHeight(current.children[1]) ;
				biggerHeight = (current.children[1].lHeight <= current.children[1].rHeight) 
						? rHeight : lHeight ;
				rHeight = 1 + biggerHeight ;
			}
		}
			
	}
	
	public void inOrderTraverse(BinaryTreeNode node) {
		if(node.children != null && node.children[0] != null) {
			inOrderTraverse(node.children[0]) ;
		}
		
		inOrderLogic(node) ;
		
		if(node.children != null && node.children[1] != null) {
			inOrderTraverse(node.children[1]) ;
		}
	}
	
	private void inOrderLogic(BinaryTreeNode node) {
		System.out.println("Before increment: value= " + node.value) ;
		System.out.println("After increment: value= " + (++node.value)) ;
	}
	
	public void preOrderTraverse(BinaryTreeNode node) {
		preOrderLogic(node) ;
		
		if(node.children != null && node.children[0] != null) {
			preOrderTraverse(node.children[0]) ;
		}

		if(node.children != null && node.children[1] != null) {
			preOrderTraverse(node.children[1]) ;
		}
	}
	
	private void preOrderLogic(BinaryTreeNode node) {
		System.out.println("Before doubling: value= " + node.value) ;
		System.out.println("After doubling: value= " + (node.value*=2)) ;
	}
	
	public void postOrderTraverse(BinaryTreeNode node) {
		
		if(node.children != null && node.children[0] != null) {
			postOrderTraverse(node.children[0]) ;
		}

		if(node.children != null && node.children[1] != null) {
			postOrderTraverse(node.children[1]) ;
		}
		
		postOrderLogic(node) ;
	}
	
	private void postOrderLogic(BinaryTreeNode node) {
		System.out.println("Before dividing: value= " + node.value) ;
		System.out.println("After dividing: value= " + (node.value/=10)) ;
	}
	
}

@SuppressWarnings("serial")
class BinaryPropertyViolatedException extends Exception {
	public String getMessage() {
		return "A binary tree node cannot have more than two children" ;
	}
}