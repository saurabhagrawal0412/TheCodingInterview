package chapter17 ;

import java.util.Random ;

public class MaxSubmatrix_Test {

	public static void main(String[] args) {
		MaxSubmatrix_Test obj = new MaxSubmatrix_Test() ;
		int[][] input = new int[10][10] ;
		Random rand = new Random() ;

		for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				input[i][j] = rand.nextInt(10) ;
				boolean isNegative = rand.nextBoolean() ;
				if(isNegative) {
					input[i][j] *= -1 ;
				}
				System.out.print(input[i][j] + "\t") ;
			}
			System.out.println() ;
		}
		SubMatrix maxSubMatrix = obj.getMaxSubMatrix(input) ;
		System.out.println(maxSubMatrix.toString()) ;
	}

	private SubMatrix getMaxSubMatrix(int[][] input) {
		SubmatrixHelper[][] matrix = convertToSubmatrixHelper(input) ;
		SubMatrix maxSubMatrix = null ;
		
		for(int row=0 ; row<matrix.length ; row++) {
			for(int col=0 ; col<matrix[0].length ; col++) {
				SubmatrixHelper curr = matrix[row][col] ;
				
				curr.colSum = (row>0) ? matrix[row-1][col].colSum + curr.val : curr.val ;
				curr.rowSum = (col>0) ? matrix[row][col-1].rowSum + curr.val : curr.val ;
				int diagSum = (row>0 && col>0) ? matrix[row-1][col-1].maxSum + curr.rowSum + curr.colSum - curr.val : Integer.MIN_VALUE ;
				
				if(curr.val >= curr.rowSum && curr.val >= curr.colSum && curr.val >= diagSum) {
					curr.maxSum = curr.val ;
					curr.start = new Coordinate(row, col) ;
				}
				else if(diagSum >= curr.val && diagSum >= curr.rowSum && diagSum > curr.colSum) {
					curr.maxSum = diagSum ;
					curr.start = matrix[row-1][col-1].start ;
				}
				else if(curr.colSum >= curr.val && curr.colSum >= curr.rowSum && curr.colSum >= diagSum) {
					curr.maxSum = curr.colSum ;
					curr.start = new Coordinate(row, 0) ;
				}
				else if(curr.rowSum >= curr.val && curr.rowSum >= curr.colSum && curr.rowSum >= diagSum) {
					curr.maxSum = curr.rowSum ;
					curr.start = new Coordinate(0, col) ;
				}
				if(maxSubMatrix == null || curr.maxSum > maxSubMatrix.value) {
					maxSubMatrix = new SubMatrix(curr.start, new Coordinate(row, col), curr.maxSum) ;
				}
			}
		}
		return maxSubMatrix ;
	}

	private SubmatrixHelper[][] convertToSubmatrixHelper(int[][] input) {
		SubmatrixHelper[][] matrix = new SubmatrixHelper[input.length][input[0].length] ;

		for(int i=0 ; i<input.length ; i++) {
			for(int j=0 ; j<input[0].length ; j++) {
				matrix[i][j] = new SubmatrixHelper(input[i][j]) ;
			}
		}
		return matrix ;
	}
}

class SubMatrix {
	Coordinate start ;
	Coordinate end ;
	int value ;

	public SubMatrix(Coordinate start, Coordinate end, int value) {
		this.start = start;
		this.end = end;
		this.value = value ;
	}
	public String toString() {
		StringBuilder output = new StringBuilder() ;
		output.append("Start coordinate\n") ;
		output.append(start.toString()) ;
		output.append("End coordinate\n") ;
		output.append(end.toString()) ;
		output.append("\nValue=") ;
		output.append(value) ;
		return output.toString() ;
	}
}

class SubmatrixHelper {
	int val ;
	int rowSum ;
	int colSum ;
	int maxSum = Integer.MIN_VALUE ;
	Coordinate start ;

	SubmatrixHelper(int val) {
		this.val = val ;
		rowSum = val ;
		colSum = val ;
		maxSum = val ;
	}
}