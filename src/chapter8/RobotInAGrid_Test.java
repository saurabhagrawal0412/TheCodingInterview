package chapter8;

import java.util.ArrayList;

public class RobotInAGrid_Test {

	public static void main(String[] args) {
		/*char[][] grid = {
						  {'1','1','1','1','D',}
						} ;*/
		
		char[][] grid = {
						  {'1','0','1','1','1',},
						  {'1','0','1','1','1',},
						  {'1','0','1','1','1',},
						  {'1','1','1','0','1',},
						  {'1','1','1','0','D',}
						} ;
		RobotInAGrid pathFinder = new RobotInAGrid() ;
		ArrayList<Position> path = pathFinder.findPath(grid) ;
		
		for(Position temp : path) {
			System.out.println(temp.row() + " " + temp.column()) ;
		}
	}

}

class Position {
	private int row , column ;
	
	public Position(int row, int column) {
		this.row = row ;
		this.column = column ;
	}

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}
}

class RobotInAGrid {
	private static ArrayList<Position> path ;
	private static char[][] grid ;
	public ArrayList<Position> findPath(char[][] grid) {
		RobotInAGrid.grid = grid ;
		path = new ArrayList<Position>() ;
		Position initial = new Position(0, 0) ;
		boolean isPathFound = findPath(initial) ;
		
		if(isPathFound)
			System.out.println("Path found") ;
		else
			System.out.println("Path not found") ;
		
		return path ;
	}
	
	private boolean findPath(Position current) {
		if(grid[current.row()][current.column()] == '0' || grid[current.row()][current.column()] == 'R') {
			return false ;
		}
		else if(grid[current.row()][current.column()] == 'D') {
			path.add(current) ;
			return true ;
		}
		else {
			grid[current.row()][current.column()] = 'R' ;
			path.add(current) ;
			boolean pathFound = false ;
			
			if(grid.length > current.row() + 1) {
				pathFound = findPath(new Position(current.row()+1 , current.column() ) ) ;
			}
			if(! pathFound && grid[0].length > current.column() + 1) {
				pathFound = findPath(new Position(current.row() , current.column()+1 ) ) ;
			}
			return pathFound ;
		}
	}
}