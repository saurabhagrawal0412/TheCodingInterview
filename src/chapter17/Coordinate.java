package chapter17;

public class Coordinate {
	int row, col ;
	Coordinate(int row, int col) {
		this.row = row ;
		this.col = col ;
	}
	public String toString() {
		StringBuilder output = new StringBuilder() ;
		output.append("row=") ;
		output.append(row) ;
		output.append(" col=") ;
		output.append(col) ;
		output.append("\n") ;
		return output.toString() ;
	}
}