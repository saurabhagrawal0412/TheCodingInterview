package chapter1;

/*
 * Author: Saurabh Agrawal
 * This program checks whether two given strings are permutations of each other or not
 * It takes constant space and linear time (proportional to the total size of both the strings)
 * */

public class CheckPermutation {

	public static void main(String[] args) {
		CheckPermutation obj = new CheckPermutation() ;
		
		System.out.println( obj.isPermutation("banner", "benran") );
		System.out.println( obj.isPermutation("apple", "papel") );
		System.out.println( obj.isPermutation("apple", "lapel") );
	}

	private boolean isPermutation(final String word1, final String word2) {
		if(word1.length() != word2.length()) {
			return false ;
		}
		
		byte[] charFrequency = new byte[256] ;
		
		for(int i=0 ; i<word1.length() ; i++) {
			charFrequency[(int)word1.charAt(i)] ++ ;
			charFrequency[(int)word2.charAt(i)] -- ;
		}
		
		return isZeroArray(charFrequency) ;
	}

	private boolean isZeroArray(final byte[] charFrequency) {
		for(byte curr : charFrequency) {
			if(curr != 0) {
				return false ;
			}
		}
		return true ;
	}
}
