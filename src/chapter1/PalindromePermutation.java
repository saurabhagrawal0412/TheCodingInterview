package chapter1;

import java.util.Stack;

/* Author: Saurabh Agrawal
 * This program checks if the given string is a palindrome or not
 * It uses stack to find it*/

public class PalindromePermutation {
	public static void main(String[] args) {
		PalindromePermutation obj = new PalindromePermutation() ;
		System.out.println(obj.isPermutation("malayalam")) ;
		System.out.println(obj.isPermutation("faaf")) ;
		System.out.println(obj.isPermutation("apple")) ;
	}
	
	private boolean isPermutation(final String word) {
		int length = word.length() ;
		int pushIndex = length/2 - 1 ;
		int popIndex = (length%2 == 1) ? (pushIndex + 2) : (pushIndex + 1) ;
		
		Stack<Character> permutStack = new Stack<>() ;
		
		for(int i=0 ; i<length ; i++) {
			char curr = word.charAt(i) ;
			if(i <= pushIndex) {
				permutStack.push(curr) ;
			}
			else if(i >= popIndex) {
				if(permutStack.pop() != curr) {
					return false ;
				}
			}
		}
		return true ;
	}
}