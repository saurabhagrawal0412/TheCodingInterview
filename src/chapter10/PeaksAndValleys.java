package chapter10;

public class PeaksAndValleys {

	int[] arr = {5, 3, 1, 2, 3} ;
	public static void main(String[] args) {
		PeaksAndValleys obj = new PeaksAndValleys() ;
		obj.displayArray() ;
		obj.findPeaksAndValleys() ;
		obj.displayArray() ;
	}

	public void findPeaksAndValleys() {
		if(arr.length > 2) {
			for(int i=1 ; i<arr.length-1 ; i++) {
				if(arr[i-1] < arr[i] && arr[i] < arr[i+1]) {
					swap(i, i+1) ;
				}
				else if(arr[i-1] > arr[i] && arr[i] > arr[i+1]) {
					swap(i, i+1) ;
				}
			}
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = temp ;
	}
	
	private void displayArray() {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + " ") ;
		}
		System.out.println() ;
	}
}
