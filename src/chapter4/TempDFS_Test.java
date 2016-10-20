package chapter4;

import java.util.Stack;

public class TempDFS_Test {

	public static void main(String[] args) {
		TempDFS_Test obj = new TempDFS_Test() ;
		char[][] input1 = {
							{'s','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','d'}
						} ;
		CharGraphNode[][] graph1 = obj.buildGraph(input1) ;
		
		GraphCoordinate src1 = new GraphCoordinate(0, 0) ;
		ArrayGraphDFS obj1 = new ArrayGraphDFS(graph1, src1, 'd') ;
		System.out.println(obj1.findDFSRoute()) ;
		
		System.out.println("The second innings") ;
		
		char[][] input2 = {
				{'s','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','d'}
			} ;
		CharGraphNode[][] graph2 = obj.buildGraph(input2) ;
		GraphCoordinate src2 = new GraphCoordinate(3, 3) ;
		ArrayGraphDFS obj2 = new ArrayGraphDFS(graph2, src2, 's') ;
		System.out.println(obj2.findDFSRoute()) ;
	}
	
	public CharGraphNode[][] buildGraph(char[][] input) {

		CharGraphNode[][] graph = new CharGraphNode[input.length][input[0].length] ; 
		for(int i=0 ; i<graph.length ; i++) {
			for(int j=0 ; j<graph[0].length ; j++)
			graph[i][j] = new CharGraphNode(input[i][j]) ;
		}
		return graph ;
	}

}

class ArrayGraphDFS {
	
	private CharGraphNode[][] graph ;
	private GraphCoordinate src ;
	private char dest ;
	
	public ArrayGraphDFS(CharGraphNode[][] graph, GraphCoordinate src, char dest) {
		this.graph = graph ;
		this.src = src ;
		this.dest = dest ;
	}
	
	public CharGraphNode[][] getGraph() {
		return graph ;
	}

	public void setGraph(CharGraphNode[][] graph) {
		this.graph = graph ;
	}

	public GraphCoordinate getSrc() {
		return src ;
	}

	public void setSrc(GraphCoordinate src) {
		this.src = src ;
	}

	public char getDest() {
		return dest;
	}

	public void setDest(char dest) {
		this.dest = dest;
	}

	public boolean findDFSRoute() {
		boolean isRoute = false ;
		Stack<GraphCoordinate> toBeVisited = new Stack<GraphCoordinate> () ;
		toBeVisited.push(src) ;
		
		while(! toBeVisited.isEmpty() ) {
			GraphCoordinate temp = toBeVisited.pop() ;
			int x = temp.x ;
			int y = temp.y ;
			CharGraphNode node = graph[x][y] ;
			
			if(! node.isVisited())
				System.out.println("Coordinates: x=" + x + " y=" + y) ;
			
			//Destination node found
			if(node.getVal() == dest) {
				isRoute = true ;
				break ;
			}
			
			//If barrier 'b' reached continue
			else if(node.getVal() == 'b') {
				continue ;
			}
			
			//If node is already visited continue
			if(node.isVisited()) {
				continue ;
			}
			else {
				graph[x][y].setVisited(true) ;
				
				if(x-1 >= 0 && y-1 >= 0)
					toBeVisited.push(new GraphCoordinate(x-1, y-1)) ;
				if(y-1 >= 0)
					toBeVisited.push(new GraphCoordinate(x, y-1)) ;
				if(x+1 < graph.length && y-1 >= 0)
					toBeVisited.push(new GraphCoordinate(x+1, y-1)) ;
				if(x+1 < graph.length)
					toBeVisited.push(new GraphCoordinate(x+1, y)) ;
				if(x+1 < graph.length && y+1 < graph[0].length)
					toBeVisited.push(new GraphCoordinate(x+1, y+1)) ;
				if(y+1 < graph[0].length)
					toBeVisited.push(new GraphCoordinate(x, y+1)) ;
				if(x-1 >= 0 && y+1 < graph[0].length)
					toBeVisited.push(new GraphCoordinate(x-1, y+1)) ;
				if(x-1 >= 0)
					toBeVisited.push(new GraphCoordinate(x-1, y)) ;
			}
		}
		return isRoute ;
	}
}

class CharGraphNode {
	private final char val ;
	private boolean isVisited= false ;
	
	public CharGraphNode(char val) {
		this.val = val;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public char getVal() {
		return val;
	}
}

class GraphCoordinate {
	public int x ;
	public int y ;
	
	public GraphCoordinate(int x, int y) {
		this.x = x ;
		this.y = y ;
	}
}