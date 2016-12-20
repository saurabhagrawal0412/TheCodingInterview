package chapter10;

public class RankFinder_Test {

	public static void main(String[] args) {
		RankFinder_Test test = new RankFinder_Test() ;
		RankFinder rf = test.insertData() ;
		rf.traverseInorder() ;
		rf.traversePreorder() ;
		int rank = rf.getRank(20) ;
		System.out.println("Rank = " + rank) ;
	}
	
	public RankFinder insertData() {
		RankFinder rf = new RankFinder() ;
		rf.track(20) ;
		rf.track(10) ;
		rf.track(30) ;
		rf.track(5) ;
		rf.track(15) ;
		rf.track(25) ;
		rf.track(35) ;
		return rf ;
	}

}

class RankFinder {
	
	private ModifiedBST root ;
	
	public void track(int key) {
		ModifiedBST node = new ModifiedBST(key) ;
		
		if(root == null) {
			root = node ;
		}
		
		else {
			ModifiedBST temp = root ;
			boolean isInserted = false ;
			
			while(!isInserted) {
				temp.setNodeCount(temp.getNodeCount() + 1) ;
				if(temp.getKey() < key) {
					if(temp.getRight() == null) {
						temp.setRight(node) ;
						isInserted = true ;
					}
					else {
						temp = temp.getRight() ;
					}
				}
				else {
					if(temp.getLeft() == null) {
						temp.setLeft(node) ;
						isInserted = true ;
					}
					else {
						temp = temp.getLeft() ;
					}
				}
			}
		}
	}
	
	public int getRank(int key) {
		if(root == null) {
			return -1 ;
		}
		int rank = (root.getLeft()==null) ? 1 : root.getLeft().getNodeCount() + 1 ;
		ModifiedBST temp = root, t1 ;
		
		while(temp.getKey() != key) {
			
			if(temp.getKey() > key) {
				t1 = temp.getLeft() ;
				
				if(t1.getRight() == null) {
					rank-- ;
				}
				else {
					rank = rank - t1.getRight().getNodeCount() ;
				}
			}
			else {
				t1 = temp.getRight() ;
				
				if(t1.getLeft() == null) {
					rank++ ;
				}
				else {
					rank = rank + t1.getLeft().getNodeCount() ;
				}
			}
			temp = t1 ;
			t1 = null ;
		}
		return rank ;
	}
	
	public void traverseInorder() {
		System.out.println("\nInorder traversal");
		traverseInorder(root) ;
	}
	
	public void traverseInorder(ModifiedBST root) {
		if(root.getLeft() != null) {
			traverseInorder(root.getLeft()) ;
		}
		System.out.println("Key=" + root.getKey() + " NodeCount=" + root.getNodeCount()) ;
		if(root.getRight() != null) {
			traverseInorder(root.getRight()) ;
		}
	}
	
	public void traversePreorder() {
		System.out.println("\nPreorder traversal");
		traversePreorder(root) ;
	}
	
	public void traversePreorder(ModifiedBST root) {
		System.out.println("Key=" + root.getKey() + " NodeCount=" + root.getNodeCount()) ;
		if(root.getLeft() != null) {
			traversePreorder(root.getLeft()) ;
		}
		if(root.getRight() != null) {
			traversePreorder(root.getRight()) ;
		}
	}
}

class ModifiedBST {
	
	private int key ;
	private ModifiedBST left ;
	private ModifiedBST right ;
	private int nodeCount = 1 ;

	public ModifiedBST(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public ModifiedBST getLeft() {
		return left;
	}

	public void setLeft(ModifiedBST left) {
		this.left = left;
	}

	public ModifiedBST getRight() {
		return right;
	}

	public void setRight(ModifiedBST right) {
		this.right = right;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
}