package chapter1;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix2 {

	public static void main(String[] args) {
		ZeroMatrix2 obj = new ZeroMatrix2() ;
		int[][] matrix = {
							{5,3,0},
							{2,0,1},
							{1,2,3}
						 } ;
		obj.printMatrix(matrix) ;
		obj.convertToZeroMatrix(matrix) ;
		obj.printMatrix(matrix) ;
	}

	private void convertToZeroMatrix(int[][] matrix) {
		Set<Integer> rows = new HashSet<>() ;
		Set<Integer> cols = new HashSet<>() ;
		
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				if(matrix[i][j] == 0) {
					rows.add(i) ;
					cols.add(j) ;
				}
			}
		}
		
		for(int row : rows) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				matrix[row][j] = 0 ;
			}
		}
		
		for(int col : cols) {
			for(int i=0 ; i<matrix[0].length ; i++) {
				matrix[i][col] = 0 ;
			}
		}
	}
	
	private void printMatrix(final int[][] matrix) {
		System.out.println("Printing matrix") ;
		
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				System.out.print(matrix[i][j] + " ") ;
			}
			System.out.println() ;
		}
	}
}
