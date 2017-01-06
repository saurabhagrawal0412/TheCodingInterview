package chapter17;

public class MissingTwo_Test {

	public static void main(String[] args) {
		MissingTwo_Test obj = new MissingTwo_Test() ;
		int[] input = {1, 2, 4, 5, 6, 7, 8, 10} ;
		try {
			obj.printMissingTwo(10, input) ;
		}
		catch (IllegalInputException e) {
			System.out.println(e.getMessage()) ;
		}
	}

	void printMissingTwo(int n, int[] input) throws IllegalInputException {
		if(input.length != n-2) {
			throw new IllegalInputException() ;
		}
		int sum = findNNsum(1, n) ;
		int diff = sum ;
		
		for(int temp: input) {
			diff -= temp ;
		}

		int lVal = (int)Math.floor(diff/2) ;
		int rVal = lVal + 1 ;
		int lSum = findNNsum(1, lVal) ;
		int rSum = findNNsum(rVal, n) ;
		for(int temp: input) {
			if(temp <= lVal) {
				lSum -= temp ;
			}
			else if(temp >= rVal) {
				rSum -= temp ;
			}
		}
		System.out.println("First value = " + lSum) ;
		System.out.println("Second value = " + rSum) ;
	}
	
	int findNNsum(int first, int last) {
		int sum = (last-first+1) * (first + last) / 2 ;
		return sum ;
	}
}
