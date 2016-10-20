package chapter4;

import java.util.Stack;

public class RouteBetweenNodes_Test {

	public static void main(String[] args) {
		
	}

}

class RouteBetweenNodes {

	public boolean isRoute(GraphNode[] nodes, GraphNode src, GraphNode dest) {
		boolean isRoute = false ;
		Stack<GraphNode> srcStack = new Stack<GraphNode>() ;
		srcStack.push(src) ;
		
		Stack<GraphNode> destStack = new Stack<GraphNode>() ;
		destStack.push(dest) ;
		
		GraphNode tempSrc, tempDest ;
		
		while(! srcStack.isEmpty() && ! destStack.isEmpty() ) {
			tempSrc = srcStack.pop() ;
			tempDest = destStack.pop() ;
			
			if(! tempSrc.isVisited() ) {
				tempSrc.setVisited(true) ;
				pushAllAdjacentNodes(tempSrc, srcStack) ;
			}
			else {
				isRoute = true ;
				break ;
			}
			
			if(! tempDest.isVisited() ) {
				tempDest.setVisited(true) ;
				pushAllAdjacentNodes(tempDest, destStack) ;
			}
			else {
				isRoute = true ;
				break ;
			}
		}
		return isRoute ;
	}
	
	public Stack<GraphNode> pushAllAdjacentNodes(GraphNode node, Stack<GraphNode> stack) {
		if(node.getadjNodes() != null) {
			for(GraphNode adjNode : node.getadjNodes().keySet()) {
				stack.push(adjNode) ;
			}
		}
		return stack ;
	}

}