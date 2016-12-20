package chapter16;

public class NumberSwapper {

	public static void main(String[] args) {
		int[] arr = {5, 4} ;
		for(int t: arr) {
			System.out.println(t) ;
		}
		swap(arr) ;
		for(int t: arr) {
			System.out.println(t) ;
		}
	}

	static void swap(int[] arr) {
		arr[0] += arr[1] ;
		arr[1] = arr[0] - arr[1] ;
		arr[0] -= arr[1] ;
	}
}
