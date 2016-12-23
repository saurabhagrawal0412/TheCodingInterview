package chapter16;

public class SubSort_Test {

	public static void main(String[] args) {
		SubSorter sorter = new SubSorter() ;
		int[] input = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19} ;
		sorter.performSubSort(input) ;
	}
}

class SubSorter {
	
	void performSubSort(int[] input) {
		if(input.length < 2) {
			System.out.println("Array size less than minimum size of 2") ;
			return ;
		}
		if(isAlreadySorted(input)) {
			System.out.println("Already sorted") ;
			return ;
		}
		int length = input.length - 1 ;
		int start=length+1, tStart=length+1, end=-1, tEnd=-1 ;
		
		for(int i=1 ; i<=length ; i++) {
			if(input[i] < input[i-1]) {
				tStart = findStart(input, i) ;
				if(tStart < start) {
					start = tStart ;
				}
			}
		}
		
		for(int i=length-1 ; i>=0 ; i--) {
			if(input[i] > input[i+1]) {
				tEnd = findEnd(input, i) ;
				if(tEnd > end) {
					end = tEnd ;
				}
			}
		}
		
		System.out.println("Start Index = " + start) ;
		System.out.println("End Index = " + end) ;
	}

	private int findStart(int[] input, int index) {
		if(input[index] < input[0]) {
			return 0 ;
		}
		int length = input.length - 1 ;
		for(int i=1 ; i<=length ; i++) {
			if(input[i-1]<=input[index] && input[i]>input[index]) {
				return i ;
			}
		}
		return -1 ;
	}

	private int findEnd(int[] input, int index) {
		int length = input.length - 1 ;
		if(input[index] > input[length]) {
			return length ;
		}
		for(int i=length-1 ; i>index ; i--) {
			if(input[i+1]>=input[index] && input[i]<input[index]) {
				return i ;
			}
		}
		return -1 ;
	}

	private boolean isAlreadySorted(int[] input) {
		for(int i=1 ; i<input.length ; i++) {
			if(input[i] < input[i-1]) {
				return false ;
			}
		}
		return true ;
	}
}