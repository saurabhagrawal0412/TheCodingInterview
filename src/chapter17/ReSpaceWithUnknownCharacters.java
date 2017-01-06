package chapter17;

import java.util.HashSet;

public class ReSpaceWithUnknownCharacters {

	public static void main(String[] args) {
		ReSpaceWithUnknownCharacters obj = new ReSpaceWithUnknownCharacters() ;
		HashSet<String> dict = obj.constructDictionary() ;
		String input = "JESSLOOKSJUSTLIKETIMHERBROTHER" ;
		String output = obj.respaceString(dict, input) ;
		System.out.println("Output = " + output) ;
	}

	String respaceString(HashSet<String> dict, String input) {
		String output = "" ;
		int[][] unrecog = new int[input.length()][input.length()] ;
		String[][] wordBreak = new String[input.length()][input.length()] ;
		
		for(int i=0 ; i<input.length() ; i++) {
			int row = 0, col = i ;
			
			while(row < unrecog.length && col < unrecog.length) {
				String curr = input.substring(row, col+1) ;
				System.out.println("Curr = " + curr) ;
				if(dict.contains(curr)) {
					unrecog[row][col] = 0 ;
					wordBreak[row][col] = input.substring(row, col+1) ;
				}
				else {
					int min = Integer.MAX_VALUE, temp, tIndex=0 ;
					for(int j=1 ; j<curr.length()-1 ; j++) {
						temp = unrecog[row][j] + unrecog[row+j+1][col] ;
						if(temp < min) {
							min = temp ;
							tIndex = j ;
						}
					}
					wordBreak[row][col] = wordBreak[row][tIndex] + " " + wordBreak[row+tIndex][col] ;
					//wordBreak[row][col] = curr.substring(0, tIndex) + " " + curr.substring(tIndex, curr.length()) ;
				}
				row ++ ;
				col ++ ;
			}
		}
		
		/*for(int i=0 ; i<wordBreak.length ; i++) {
			for(int j=0 ; j<wordBreak.length ; j++) {
				System.out.print(wordBreak[i][j] + " ") ;
			}
			System.out.println() ;
		}*/
		System.out.println("Blah" + wordBreak[0][wordBreak.length-1]) ;
		System.out.println() ;
		/*System.out.println(unrecog[0][unrecog.length-1]) ;
		
		Stack<Coordinate> forOutput = new Stack<>() ;
		
		forOutput.push(new Coordinate(0, unrecog.length-1)) ;
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
		}*/
		return output ;
	}

	private HashSet<String> constructDictionary() {
		HashSet<String> dict = new HashSet<>() ;
		dict.add("I") ;
		dict.add("LOO") ;
		dict.add("LOOK") ;
		dict.add("LOOKED") ;
		dict.add("JUST") ;
		dict.add("LIKE") ;
		dict.add("HER") ;
		dict.add("THE") ;
		dict.add("OTHER") ;
		dict.add("BROTHER") ;
		return dict ;
	}
}
