package chapter4;

public class BalancedBinarySearchTreeImplementation {

	public static void main(String[] args) {
		
	}

}

class BalancedBinarySearchTreeNode extends BinaryTreeNode {
	
	private BalancedBinarySearchTreeNode root ;
	private BalancedBinarySearchTreeNode[] childrenArray = new BalancedBinarySearchTreeNode[2] ;
	private BalancedBinarySearchTreeNode parent ;
	private int[] heights = new int[2] ;
	
	public BalancedBinarySearchTreeNode(int value) {
		super(value) ;
	}
	
	public BalancedBinarySearchTreeNode getRoot() {
		return root ;
	}

	public void setRoot(BalancedBinarySearchTreeNode root) {
		this.root = root ;
	}
	
	public BalancedBinarySearchTreeNode[] getChildrenArray() {
		return this.childrenArray ;
	}
	
	public BalancedBinarySearchTreeNode getLeftChild() {
		return this.childrenArray[0] ;
	}
	public BalancedBinarySearchTreeNode getRightChild() {
		return this.childrenArray[1] ;
	}
	
	public BalancedBinarySearchTreeNode getParent() {
		return parent;
	}

	public void setParent(BalancedBinarySearchTreeNode parent) {
		this.parent = parent;
	}

	public int[] getHeights() {
		return this.heights ;
	}
	
	public int getLHeight() {
		return heights[0] ;
	}
	
	public int getRHeight() {
		return heights[1] ;
	}
	
	public void insert(int value) {
		BalancedBinarySearchTreeNode node = addNode(value) ;
		checkHeight(node) ;
	}
	
	public void checkHeight(BalancedBinarySearchTreeNode node) {
		BalancedBinarySearchTreeNode temp = node ;
		BalancedBinarySearchTreeNode[] children ;
		
		while(temp == null) {
			children = temp.getChildrenArray() ;
			
			for(int i=0 ; i<=1 ; i++) {
				heights[i] = getMaxHeight(children[i]) ;
			}
			if(Math.abs(heights[0]-heights[2]) > 1) {
				performBalancing(temp) ;
			}
		}
	}

	private int getMaxHeight(BalancedBinarySearchTreeNode node) {
		int[] heights = node.getHeights() ;
		return (heights[0] >= heights[1]) ? heights[0] : heights[1] ;
	}
	
	public void performBalancing(BalancedBinarySearchTreeNode node) {
		BalancedBinarySearchTreeNode child, grandChild ;
		
		if(true) {
			
		}
		child = (node.getLHeight() <= node.getLHeight()) ?
					node.getRightChild() : node.getLeftChild() ;
					
		grandChild = (child.getLHeight() <= child.getLHeight()) ?
					child.getRightChild() : child.getLeftChild() ;
	}

	public BalancedBinarySearchTreeNode addNode(int value) {
		
		if(root == null) {
			root = new BalancedBinarySearchTreeNode(value) ;
			return root ;
		}
		else {
			BalancedBinarySearchTreeNode child = new BalancedBinarySearchTreeNode(value) ;
			BalancedBinarySearchTreeNode temp = root ;
			
			while(true) {
				int index = (value <= temp.value) ? 0 : 1 ;

				if(temp.childrenArray[index] == null) {
					temp.childrenArray[index] = child ;
					break ;
				}
				else
					temp = temp.childrenArray[index] ;
			}
			return child ;
		}
	}
}