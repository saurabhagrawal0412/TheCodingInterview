package chapter4 ;

import java.util.ArrayList ;

public class TreeImplementation {

	public static void main(String[] args) {
		
		try {
			TreeNode root = new TreeNode(0) ;
			System.out.println(root.getValue()) ;

			TreeNode c1 = root.addChild(1) ;
			System.out.println(c1.getValue()) ;

			TreeNode c2 = root.addChild(2) ;
			System.out.println(c2.getValue()) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

}

class TreeNode {
	
	protected int value ;
	private ArrayList<TreeNode> childrenList ;
	
	public TreeNode(int value) {
		this.value = value ;
	}

	public int getValue() {
		return value ;
	}

	public void setValue(int value) {
		this.value = value ;
	}

	public ArrayList<TreeNode> getChildrenList() {
		return childrenList ;
	}
	
	public TreeNode addChild(int value) throws Exception {
		if(childrenList == null)
			childrenList = new ArrayList<TreeNode>() ;
		
		TreeNode child = new TreeNode(value) ;
		childrenList.add(child) ;
		
		return child ;
	}
}