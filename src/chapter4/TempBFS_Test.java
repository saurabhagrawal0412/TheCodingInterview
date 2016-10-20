package chapter4;

import java.util.ArrayList;
//import java.util.Stack;

public class TempBFS_Test {

	public static void main(String[] args) {
		TempBFS_Test obj = new TempBFS_Test() ;
		char[][] input1 = {
							{'s','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','d'}
						} ;
		CharGraphNode[][] graph1 = obj.buildGraph(input1) ;
		
		GraphCoordinate src1 = new GraphCoordinate(0, 0) ;
		ArrayGraphBFS obj1 = new ArrayGraphBFS(graph1, src1, 'd') ;
		System.out.println(obj1.findBFSRoute()) ;
		
		System.out.println("The second innings") ;
		
		char[][] input2 = {
				{'s','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','d'}
			} ;
		CharGraphNode[][] graph2 = obj.buildGraph(input2) ;
		GraphCoordinate src2 = new GraphCoordinate(3, 3) ;
		ArrayGraphBFS obj2 = new ArrayGraphBFS(graph2, src2, 's') ;
		System.out.println(obj2.findBFSRoute()) ;
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

class ArrayGraphBFS {
	
	private CharGraphNode[][] graph ;
	private GraphCoordinate src ;
	private char dest ;
	
	public ArrayGraphBFS(CharGraphNode[][] graph, GraphCoordinate src, char dest) {
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

	public boolean findBFSRoute() {
		boolean isRoute = false ;
		ArrayList<GraphCoordinate> toBeVisited = new ArrayList<GraphCoordinate>() ;
		toBeVisited.add(src) ;
		
		while(! toBeVisited.isEmpty() ) {
			GraphCoordinate temp = toBeVisited.get(0) ;
			toBeVisited.remove(0) ;
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
				
				if(x-1 >= 0 && y-1 >= 0) {
					toBeVisited.add(new GraphCoordinate(x-1, y-1)) ;
					//System.out.println("1 added") ;
				}
				if(y-1 >= 0) {
					toBeVisited.add(new GraphCoordinate(x, y-1)) ;
					//System.out.println("2 added") ;
				}
				if(x+1 < graph.length && y-1 >= 0) {
					toBeVisited.add(new GraphCoordinate(x+1, y-1)) ;
					//System.out.println("3 added") ;
				}
				if(x+1 < graph.length) {
					toBeVisited.add(new GraphCoordinate(x+1, y)) ;
					//System.out.println("4 added") ;
				}
				if(x+1 < graph.length && y+1 < graph[0].length) {
					toBeVisited.add(new GraphCoordinate(x+1, y+1)) ;
					//System.out.println("5 added") ;
				}
				if(y+1 < graph[0].length) {
					toBeVisited.add(new GraphCoordinate(x, y+1)) ;
					//System.out.println("6 added") ;
				}
				if(x-1 >= 0 && y+1 < graph[0].length) {
					toBeVisited.add(new GraphCoordinate(x-1, y+1)) ;
					//System.out.println("7 added") ;
				}
				if(x-1 >= 0) {
					toBeVisited.add(new GraphCoordinate(x-1, y)) ;
					//System.out.println("8 added") ;
				}
			}
		}
		return isRoute ;
	}
}