package chapter16;

public class ContiguousSquence_Test {

	public static void main(String[] args) {
		ContiguousSequenceFinder obj = new ContiguousSequenceFinder() ;
		int[] input = {2, -8, 3, -2, 4, -10} ;
		int maxSum = 0 ;
		try {
			maxSum = obj.findMaxSumSubsequence(input) ;
		}
		catch(IllegalInputSizeException e) {
			e.printStackTrace() ;
		}
		System.out.println("Max Sum = " + maxSum) ;
	}
}

class ContiguousSequenceFinder {
	public int findMaxSumSubsequence(int[] input) throws IllegalInputSizeException {
		if(input.length < 2) {
			throw new IllegalInputSizeException() ;
		}
		int maxSum = Integer.MIN_VALUE ;
		int prevSum = 0 ;
		for(int i=0 ; i<input.length ; i++) {
			if(prevSum >= 0) {
				prevSum += input[i] ;
			}
			else {
				prevSum = input[i] ;
			}
			if(prevSum > maxSum) {
				maxSum = prevSum ;
			}
		}
		return maxSum ;
	}
}