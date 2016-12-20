package chapter8;

public class NQueen_Test {

	public static void main(String[] args) {
		
	}

}

class NQueenFinder {
	public void findNQueens(int size) {
		if(size < 4) {
			System.out.println("Queens not possible") ;
			return ;
		}

		boolean isPossible = false ;
		char[][] matrix = new char[size][size] ;
		
		for(int row=0 ; row<matrix.length ; row++) {
			for(int col=0 ; col<matrix[0].length ; col++) {
				if(isPossible){
					
				}
			}
		}
	}
}