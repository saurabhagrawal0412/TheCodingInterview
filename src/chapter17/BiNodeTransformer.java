package chapter17;

public class BiNodeTransformer {

	BiNode head = null, tail = null ;
	
	public static void main(String[] args) {
		BiNodeTransformer obj = new BiNodeTransformer() ;
		BiNode root = obj.constructTree() ;
		
		System.out.println("\nIn order") ;
		obj.printInOrder(root) ;
		System.out.println("\nPre order") ;
		obj.printPreOrder(root) ;
		System.out.println() ;
		
		try {
			obj.transformBSTtoDLL(root) ;
		}
		catch (IllegalInputException e) {
			e.getMessage() ;
		}
		
		obj.printForwardTraversal() ;
		obj.printBackwardTraversal() ;
	}

	private BiNode constructTree() {
		BiNode root = new BiNode(4) ;
		
		BiNode level1Left = new BiNode(2) ;
		BiNode level1Right = new BiNode(6) ;
		
		root.node1 = level1Left ;
		root.node2 = level1Right ;
		
		BiNode level2Left1 = new BiNode(1) ;
		BiNode level2Right1 = new BiNode(3) ;
		
		level1Left.node1 = level2Left1 ;
		level1Left.node2 = level2Right1 ;
		
		BiNode level2Left2 = new BiNode(5) ;
		BiNode level2Right2 = new BiNode(7) ;
		
		level1Right.node1 = level2Left2 ;
		level1Right.node2 = level2Right2 ;
		
		return root ;
	}

	private void printInOrder(BiNode curr) {
		if(curr.node1 != null) {
			printInOrder(curr.node1) ;
		}
		System.out.print(curr.data + " ") ;
		if(curr.node2 != null) {
			printInOrder(curr.node2) ;
		}
	}
	
	private void printPreOrder(BiNode curr) {
		System.out.print(curr.data + " ") ;
		if(curr.node1 != null) {
			printPreOrder(curr.node1) ;
		}
		if(curr.node2 != null) {
			printPreOrder(curr.node2) ;
		}
	}
	
	private void printForwardTraversal() {
		if(head == null) {
			System.out.println("Head not available") ;
			return ;
		}
		System.out.println("Performing forward traversal") ;
		BiNode curr = head ;
		while(curr != null) {
			System.out.print(curr.data + " ") ;
			curr = curr.node2 ;
		}
		System.out.println() ;
	}
	
	private void printBackwardTraversal() {
		if(tail == null) {
			System.out.println("Tail not available") ;
			return ;
		}
		System.out.println("Performing backward traversal") ;
		BiNode curr = tail ;
		while(curr != null) {
			System.out.print(curr.data + " ") ;
			curr = curr.node1 ;
		}
		System.out.println() ;
	}
	
	void transformBSTtoDLL(BiNode root) throws IllegalInputException {
		if(root == null) {
			throw new IllegalInputException() ;
		}
		
		transformBSTtoDLL(root, null, null) ;
	}
	
	void transformBSTtoDLL(BiNode curr, BiNode prev, BiNode next) {
		if(curr.node1 != null) {
			transformBSTtoDLL(curr.node1, prev, curr) ;
			prev = curr.node1 ;
		}
		
		if(prev == null) {
			head = curr ;
		}
		else {
			curr.node1 = prev ;
			prev.node2 = curr ;
		}
		
		if(curr.node2 != null) {
			transformBSTtoDLL(curr.node2, curr, next) ;
			next = curr.node2 ;
		}
		
		if(next == null) {
			tail = curr ;
		}
		else {
			curr.node2 = next ;
			next.node1 = curr ;
		}
	}
}

class BiNode {
	int data ;
	BiNode node1, node2 ;
	
	BiNode(int data) {
		this.data = data ;
	}
}