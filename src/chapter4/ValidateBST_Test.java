package chapter4;

import java.util.ArrayList;

public class ValidateBST_Test {

	public static void main(String[] args) {
		
		ValidateBST_Test obj = new ValidateBST_Test() ;
		BinarySearchTreeNode_4_5 root = obj.createBST_4_5() ;

		BSTValidator validator = new BSTValidator() ;
		boolean isValid ;
		try {
			isValid = validator.validateBST(root) ;
			System.out.println("IsValid = " + isValid) ;
		}
		catch(InvalidBinaryTreeException e) {
			e.printStackTrace() ;
		}
	}
	
	public BinarySearchTreeNode_4_5 createBST_4_5() {
		BinarySearchTreeNode_4_5 root = new BinarySearchTreeNode_4_5(10) ;
		root.insert(5) ;
		root.insert(15) ;
		
		/*BinarySearchTreeNode_4_5 adhoc = new BinarySearchTreeNode_4_5(20) ;
		root.rChild().setlChild(adhoc) ;*/
		root.traverseDepthFirst() ;
		return root ;
	}
}

class BSTValidator {
	private static int  prev = Integer.MIN_VALUE ;
	private static boolean isValid = true ;
	public boolean validateBST(BinarySearchTreeNode_4_5 root) throws InvalidBinaryTreeException {
		if(root == null)
			throw new InvalidBinaryTreeException() ;
		
		if(root.lChild() != null) {
			validateBST(root.lChild()) ;
		}
		if(! isValid)
			return isValid ;
		
		if(root.key() >= prev)
			prev = root.key() ;
		else {
			isValid = false ;
			return isValid ;
		}
		
		if(root.rChild() != null) {
			validateBST(root.rChild()) ;
		}
		return isValid ;
	}
}

class BinarySearchTreeNode_4_5 {
	
	private int key ;
	private BinarySearchTreeNode_4_5[] children = new BinarySearchTreeNode_4_5[2] ;
	private BinarySearchTreeNode_4_5 parent ;
	private BinarySearchTreeNode_4_5 root ;
	private int[] heights = new int[2] ;
	
	public BinarySearchTreeNode_4_5(int key) {
		this.key = key;
		
		if(root == null)
			root = this ;
	}

	public BinarySearchTreeNode_4_5[] getChildren() {
		return children;
	}
	
	public BinarySearchTreeNode_4_5 lChild() {
		return children[0] ;
	}
	
	public BinarySearchTreeNode_4_5 rChild() {
		return children[1] ;
	}
	
	public void setlChild(BinarySearchTreeNode_4_5 lChild) {
		lChild.setParent(this) ;
		this.children[0] = lChild ;
	}
	
	public void setrChild(BinarySearchTreeNode_4_5 rChild) {
		rChild.setParent(this) ;
		this.children[1] = rChild ;
	}

	public BinarySearchTreeNode_4_5 parent() {
		return parent;
	}

	public void setParent(BinarySearchTreeNode_4_5 parent) {
		this.parent = parent;
	}

	public BinarySearchTreeNode_4_5 root() {
		return root;
	}

	private void setRoot(BinarySearchTreeNode_4_5 root) {
		this.root = root;
	}

	public int[] getHeights() {
		return heights;
	}
	
	public int lHeight() {
		return heights[0] ;
	}
	
	public int rHeight() {
		return heights[1] ;
	}

	private void setHeights(int[] heights) {
		this.heights = heights;
	}

	public int key() {
		return key;
	}
	
	public void insert(int key) {
		BinarySearchTreeNode_4_5 node = new BinarySearchTreeNode_4_5(key) ;
		BinarySearchTreeNode_4_5 temp = root ;
		int index ;
		
		while(true) {
			index = (key <= temp.key()) ? 0 : 1 ;
			
			if(temp.children[index] == null) {
				temp.children[index] = node ;
				node.setParent(temp) ;
				break ;
			}
			else
				temp = temp.children[index] ;
		}
	}
	
	public void traverseDepthFirst() {
		if(root == null) {
			System.out.println("Root is null") ;
			return ;
		}
		ArrayList<BinarySearchTreeNode_4_5> nodes = new ArrayList<BinarySearchTreeNode_4_5>() ;
		nodes.add(root) ;
		
		BinarySearchTreeNode_4_5 temp = null ;
		while(nodes.size() >= 1 && nodes.get(0) != null) {
			temp = nodes.get(0) ;
			System.out.println("Value = " + temp.key() ) ;
			
			for(BinarySearchTreeNode_4_5 temp2 : temp.children) {
				if(temp2 != null)
					nodes.add(temp2) ;
			}
			nodes.remove(0) ;
		}
	}
}