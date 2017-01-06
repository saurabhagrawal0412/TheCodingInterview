package chapter17;

import java.util.ArrayList;
import java.util.Stack;

public class LettersAndNumbers_Test {

	public static void main(String[] args) {
		
	}
	
	char[] getLongestSubarray(char[] input) {
		ArrayList<SubArray> subs = new ArrayList<>() ;
		Stack<Character> stack = new Stack<>() ;
		int nums = 0, chars = 0 ;
		
		for(int i=0 ; i<input.length ; i++) {
			stack.push(input[i]) ;
			if(Character.isDigit(input[i])) {
				nums++ ;
			}
			else {
				chars++ ;
			}
			if(nums == chars) {
				performMultipop(stack, 2*nums) ;
				SubArray t1 = new SubArray(i-2*nums+1, i) ;
				subs.add(t1) ;
				mergeIfContinuous(subs) ;
			}
		}
		int currSize=0, maxSize = Integer.MIN_VALUE ;
		SubArray maxSub = null ;
		for(SubArray temp: subs) {
			currSize = temp.end - temp.start + 1 ;
			if(currSize > maxSize) {
				maxSize = currSize ;
				maxSub = temp ;
			}
		}
		
		char[] output = new char[maxSize] ;
		for(int i=0 ; i<maxSize ; i++) {
			output[i] = input[maxSub.start + i] ;
		}
		return output ;
	}

	private void mergeIfContinuous(ArrayList<SubArray> subs) {
		if(subs.size() < 2) {
			return ;
		}
		else {
			SubArray curr = subs.get(subs.size()-1) ;
			SubArray prev = subs.get(subs.size()-2) ;
			if(curr.start - prev.end == 1) {
				prev.end = curr.end ;
				subs.remove(subs.size()-1) ;
			}
		}
	}

	void performMultipop(Stack<Character> stack, int count) {
		for(int i=1 ; i<=count ; i++) {
			stack.pop() ;
		}
	}
}

class SubArray {
	int start, end ;
	SubArray(int start, int end) {
		this.start = start ;
		this.end = end ;
	}
}