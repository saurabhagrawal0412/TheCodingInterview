package chapter4;

import java.util.ArrayList;

public class ListOfDepths_test {

	public static void main(String[] args) throws InterruptedException {
		BinaryTree_4_3 root = new BinaryTree_4_3(0) ;
		BinaryTree_4_3 l1_child1 = new BinaryTree_4_3(1) ;
		BinaryTree_4_3 l1_child2 = new BinaryTree_4_3(2) ;
		root.setlChild(l1_child1) ;
		root.setrChild(l1_child2) ;
		l1_child1.setParent(root) ;
		l1_child2.setParent(root) ;
		
		BinaryTree_4_3 l2_child1 = new BinaryTree_4_3(3) ;
		BinaryTree_4_3 l2_child2 = new BinaryTree_4_3(4) ;
		BinaryTree_4_3 l2_child3 = new BinaryTree_4_3(5) ;
		BinaryTree_4_3 l2_child4 = new BinaryTree_4_3(6) ;
		l1_child1.setlChild(l2_child1) ;
		l1_child1.setrChild(l2_child2) ;
		l1_child2.setlChild(l2_child3) ;
		l1_child2.setrChild(l2_child4) ;
		l2_child1.setParent(l1_child1) ;
		l2_child2.setParent(l1_child1) ;
		l2_child3.setParent(l1_child2) ;
		l2_child4.setParent(l1_child2) ;
		
		DepthListCreator obj = new DepthListCreator() ;
		ArrayList<LinkedList_4_3> depthLists = obj.createLists(root) ;
		
		printDepthLists(depthLists) ;
	}

	public static void printDepthLists(ArrayList<LinkedList_4_3> depthLists) {
		for(LinkedList_4_3 list : depthLists) {
			while(list != null) {
				System.out.print(list.node().getValue() + " ") ;
				list = list.next() ;
			}
			System.out.println() ;
		}
	}
}

class DepthListCreator {
	
	public ArrayList<LinkedList_4_3> createLists(BinaryTree_4_3 treeRoot) throws InterruptedException {
		if(treeRoot == null)
			return null ;
		
		ArrayList<LinkedList_4_3> depthLists = new ArrayList<LinkedList_4_3>() ;
		LinkedList_4_3 root1 = new LinkedList_4_3(treeRoot) ;
		depthLists.add(root1) ;
		int index = 0 ;
		LinkedList_4_3 currRoot ;
		LinkedList_4_3 nextRoot=null, nextTemp=null, temp ;
		
		while(depthLists.get(index) != null) {
			
			System.out.println("Index = " + index) ;
			currRoot = depthLists.get(index) ;
			System.out.println("First while: currRoot = " + currRoot.node().getValue()) ;
			
			while(currRoot != null) {
				
				System.out.println("Second while: currRoot = " + currRoot.node().getValue()) ;
				if(currRoot.node().getlChild() != null) {
					System.out.println("Left child: " + currRoot.node().getlChild().getValue()) ;
					if(nextRoot == null) {
						nextRoot = new LinkedList_4_3(currRoot.node().getlChild()) ;
						System.out.println("Left: nextRoot = " + currRoot.node().getlChild().getValue()) ;
						nextTemp = nextRoot ;
					}
					else {
						temp = new LinkedList_4_3(currRoot.node().getlChild()) ;
						nextTemp.setNext(temp) ;
						nextTemp = nextTemp.next() ;
						System.out.println("Left: nextElement = " + nextTemp.node().getValue()) ;
					}
				}
				if(currRoot.node().getrChild() != null) {
					System.out.println("Right child: " + currRoot.node().getrChild().getValue()) ;
					if(nextRoot == null) {
						System.out.println("Right: nextRoot = " + currRoot.node().getrChild().getValue()) ;
						nextRoot = new LinkedList_4_3(currRoot.node().getrChild()) ;
						nextTemp = nextRoot ;
					}
					else {
						temp = new LinkedList_4_3(currRoot.node().getrChild()) ;
						nextTemp.setNext(temp) ;
						nextTemp = nextTemp.next() ;
						System.out.println("Left: nextElement = " + nextTemp.node().getValue()) ;
					}
				}
				
				currRoot = currRoot.next() ;
			}
			depthLists.add(nextRoot) ;
			index++ ;
			
			nextRoot = null ;
			nextTemp = null ;
			temp = null ;
		}
		
		return depthLists ;
	}
}

class LinkedList_4_3 {
	private BinaryTree_4_3 node ;
	private LinkedList_4_3 next ;
	
	public LinkedList_4_3(BinaryTree_4_3 node) {
		this.node = node  ;
	}

	public BinaryTree_4_3 node() {
		return node;
	}

	public LinkedList_4_3 next() {
		return next;
	}

	public void setNext(LinkedList_4_3 next) {
		this.next = next;
	}
}

class BinaryTree_4_3 {
	
	private BinaryTree_4_3 root ;
	private BinaryTree_4_3 parent, lChild, rChild ;
	private int value ;
	
	public BinaryTree_4_3(int value) {
		this.value = value ;
		if(root == null)
			root = this ;
	}

	public BinaryTree_4_3 getRoot() {
		return root ;
	}

	public void setRoot(BinaryTree_4_3 root) {
		this.root = root ;
	}

	public BinaryTree_4_3 getParent() {
		return parent ;
	}

	public void setParent(BinaryTree_4_3 parent) {
		this.parent = parent ;
	}

	public BinaryTree_4_3 getlChild() {
		return lChild ;
	}

	public void setlChild(BinaryTree_4_3 lChild) {
		this.lChild = lChild ;
	}

	public BinaryTree_4_3 getrChild() {
		return rChild ;
	}

	public void setrChild(BinaryTree_4_3 rChild) {
		this.rChild = rChild ;
	}

	public int getValue() {
		return value ;
	}
}