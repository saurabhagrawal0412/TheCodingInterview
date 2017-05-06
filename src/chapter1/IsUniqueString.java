package chapter1;

/*
 * Author: Saurabh Agrawal
 * Program checks whether the string has all unique characters or not
 * Uses bit vector of 26 bits to save the character state
 * 
 * */

public class IsUniqueString {

	public static void main(String[] args) {
		IsUniqueString obj = new IsUniqueString() ;
		System.out.println(obj.isUnique("apple")) ;
		System.out.println(obj.isUnique("bricks")) ;
	}
	
	private boolean isUnique(final String word) {
		int bitVector = 0 ;
		
		for(int i=0 ; i<word.length() ; i++) {
			char curr = word.charAt(i) ;
			int index = getCharIndex(curr) ;
			
			if(isBitSet(bitVector, index)) {
				return false ;
			}
			bitVector = setBit(bitVector, index) ;
		}
		return true ;
	}

	private int getCharIndex(final char curr) {
		return ( (int)curr - 97 ) ;
	}

	private boolean isBitSet(final int bitVector, final int index) {
		int mask = 1 << index ;
		mask = (mask & bitVector) >> index ;
		return (mask == 1) ? true : false ;
	}
	
	private int setBit(int bitVector, final int index) {
		int mask = 1 << index ;
		return (bitVector | mask) ;
	}
}
