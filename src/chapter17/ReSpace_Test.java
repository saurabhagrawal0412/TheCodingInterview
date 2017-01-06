package chapter17;

import java.util.HashSet;
import java.util.Stack;

public class ReSpace_Test {

	public static void main(String[] args) {
		ReSpace_Test obj = new ReSpace_Test() ;
		HashSet<String> dict = new HashSet<>() ;
		dict.add("dog") ;
		dict.add("er") ;
		dict.add("walk") ;
		String input = "dogwalker" ;
		String output = obj.respaceString(dict, input) ;
		System.out.println("Output = " + output) ;
	}
	
	String respaceString(HashSet<String> dict, String input) {
		String output = "" ;
		boolean[][] tracker = new boolean[input.length()][input.length()] ;
		int[][] wordBreak = new int[input.length()][input.length()] ;
		
		for(int i=0 ; i<input.length() ; i++) {
			int row = 0, col = i ;
			
			while(row < tracker.length && col < tracker.length) {
				String curr = input.substring(row, col+1) ;
				System.out.println("Curr = " + curr) ;
				if(dict.contains(curr)) {
					tracker[row][col] = true ;
					wordBreak[row][col] = -1 ;
				}
				else {
					for(int j=1 ; j<curr.length()-1 ; j++) {
						if(tracker[row][j] == true && tracker[row+j+1][col] == true) {
							tracker[row][col] = true ;
							wordBreak[row][col] = row+j ;
							break ;
						}
					}
				}
				row ++ ;
				col ++ ;
			}
		}
		
		System.out.println(tracker[0][tracker.length-1]) ;
		
		Stack<Coordinate> forOutput = new Stack<>() ;
		
		forOutput.push(new Coordinate(0, tracker.length-1)) ;
		while(! forOutput.isEmpty()) {
			Coordinate temp = forOutput.pop() ;
			int val = wordBreak[temp.row][temp.col] ;
			if(wordBreak[temp.row][temp.col] == -1) {
				output += input.substring(temp.row, temp.col+1) + " " ;
			}
			else {
				forOutput.push(new Coordinate(val+1, temp.col)) ;
				forOutput.push(new Coordinate(temp.row, val)) ;
			}
		}
		return output ;
	}
}
