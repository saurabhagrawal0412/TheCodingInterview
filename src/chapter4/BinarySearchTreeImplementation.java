package chapter4 ;

public class BinarySearchTreeImplementation {

	public static void main(String[] args) {
		
		BinarySearchTreeNode root ;
		/*System.out.println(root.getValue()) ;
		root.setRoot(root) ;
		BinarySearchTreeNode c1 = root.addChild(5) ;
		BinarySearchTreeNode c2 = root.addChild(15) ;*/
		root = new BinarySearchTreeNode(50) ;
		root.addChild(70) ;
		root.addChild(30) ;
		root.addChild(80) ;
		root.addChild(60) ;
		root.addChild(40) ;
		root.addChild(20) ;
		
		root.traverseInorder(root) ;
		
		/*BinarySearchTreeNode[] children = root.children ;
		if(children == null)
			System.out.println("children is null") ;
		
		for(BinarySearchTreeNode child : children)
			System.out.println(child.getValue()) ;*/
	}

}

class BinarySearchTreeNode extends BinaryTreeNode {
	
	protected static BinarySearchTreeNode root ;
	protected BinarySearchTreeNode[] children = new BinarySearchTreeNode[2] ;
	
	public BinarySearchTreeNode(int value) {
		super(value) ;
		if(root == null)
			root = this ;
	}
	
	public BinarySearchTreeNode addChild(int value) {
		BinarySearchTreeNode child = addChildToBinaryTree(value) ;
		return child ;
	}
	
	public static BinarySearchTreeNode getRoot() {
		return root ;
	}

	public static void setRoot(BinarySearchTreeNode root) {
		BinarySearchTreeNode.root = root ;
	}

	public static BinarySearchTreeNode addChildToBinaryTree(int value) {
		
		if(root == null) {
			root = new BinarySearchTreeNode(value) ;
			return root ;
		}
		else {
			BinarySearchTreeNode child = new BinarySearchTreeNode(value) ;
			BinarySearchTreeNode temp = root ;
			
			while(true) {
				int index = (value <= temp.value) ? 0 : 1 ;

				if(temp.children[index] == null) {
					temp.children[index] = child ;
					break ;
				}
				else
					temp = temp.children[index] ;
			}
			return child ;
		}
	}
	
	public void traverseInorder(BinarySearchTreeNode node) {
		if(node == null) {
			System.out.println("Root is null. Can't traverse tree") ;
			return ;
		}
		
		if(node.children[0] != null)
			traverseInorder(node.children[0]) ;
		
		System.out.println(node.getValue()) ;
		
		if(node.children[1] != null)
			traverseInorder(node.children[1]) ;
	}
}