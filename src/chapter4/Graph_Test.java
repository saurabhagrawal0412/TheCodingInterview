package chapter4 ;

import java.util.HashMap;

public class Graph_Test {

	public static void main(String[] args) {
		Graph_Test test = new Graph_Test() ;
		int[][] distanceMatrix = 	{
										{0,5,7,3,0,0},
										{5,0,0,1,0,0},
										{8,0,0,2,0,0},
										{1,0,3,5,0,0},
										{0,0,0,0,0,2},
										{0,0,0,0,2,0}
									} ;
		GraphNode[] nodes = test.convertDistanceMatrixToGraph(distanceMatrix) ;
		
		test.printGraph(nodes) ;
		
	}

	public GraphNode[] convertDistanceMatrixToGraph(int[][] distanceMatrix) {
		
		GraphNode[] nodes = new GraphNode[distanceMatrix.length] ;
		
		for(int i=0 ; i<distanceMatrix.length ; i++) {
			nodes[i] = new GraphNode(i+1) ;
			System.out.println("Value = " + nodes[i].getNodeID()) ;
		}
		
		for(int i=0 ; i<distanceMatrix.length ; i++) {
			for(int j=0 ; j<distanceMatrix.length ; j++) {
				if(distanceMatrix[i][j] != 0) {
					nodes[i].addAdjacent(nodes[j] , distanceMatrix[i][j]) ;
				}
			}
		}
		
		return nodes ;
	}
	
	public void printGraph(GraphNode[] nodes) {

		for(int i=0 ; i<nodes.length ; i++) {
			System.out.println("Node " + nodes[i].getNodeID()) ;

			if(nodes[i].getadjNodes() == null) {
				System.out.println("No adjacent nodes") ;
				continue ;
			}
			System.out.println("Size of adj list: " + nodes[i].getadjNodes().size() );
			System.out.println("Node\tDistance") ;

			for(GraphNode adjNode2 : nodes[i].getadjNodes().keySet()) {
				if(adjNode2 != null) {
					System.out.print(adjNode2.getNodeID() + "\t") ;
					System.out.println(nodes[i].getadjNodes().get(adjNode2)) ;
				}
			}
		}
	}
	
	public GraphNode getNode(int nodeID, GraphNode[] nodes) {
		GraphNode node = null ;
		
		for(GraphNode tempNode: nodes) {
			if(tempNode.getNodeID() == nodeID) {
				node = tempNode ;
				break ;
			}
		}
		
		return node ;
	}
}

class GraphNode {
	
	private final int nodeID ;
	private HashMap<GraphNode, Integer> adjNodes ;
	private boolean isVisited = false ;

	public GraphNode(int value) {
		this.nodeID = value ;
	}
	
	public int getNodeID() {
		return nodeID ;
	}
	
	public HashMap<GraphNode, Integer> getadjNodes() {
		return adjNodes ;
	}

	public void setadjNodes(HashMap<GraphNode, Integer> adjNodes) {
		this.adjNodes = adjNodes ;
	}
	
	public boolean isVisited() {
		return isVisited ;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited ;
	}

	public void addAdjacent(GraphNode node, int distance) {
		if(adjNodes == null)
			adjNodes = new HashMap<GraphNode, Integer>() ;
		
		adjNodes.put(node, distance) ;
	}
	
	public boolean deleteAdjacent(GraphNode node) {
		if(adjNodes.get(node) != null)
			adjNodes.remove(node) ;
		
		return false ;
	}
}