package chapter1;

/*
 * Author: Saurabh Agrawal
 * This program compresses a string by replacing repeating letters by their frequencies 
 * */

public class StringCompression2 {

	public static void main(String[] args) {
		StringCompression2 obj = new StringCompression2() ;
		System.out.println(obj.compressString("abc")) ;
	}
	
	private String compressString(final String word) {
		StringBuffer out = new StringBuffer() ;
		int freq = 1 ;
		
		for(int i=0 ; i<word.length() ; i++) {
			char curr = word.charAt(i) ;
			
			if(i+1 < word.length() && curr == word.charAt(i+1)) {
				freq++ ;
			}
			else {
				out.append(curr) ;
				out.append(freq) ;
				freq = 1 ;
			}
		}
		if(out.length() == word.length()) {
			return word ;
		}
		else {
			return out.toString() ;
		}
	}
}
