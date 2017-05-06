package chapter1;
/*
 * Author: Saurabh Agrawal
 * This program takes a String array and replaces the spaces with "%20"
 * The spaces at the end of the array provide abundant space to store the output array
 * */

public class URLify {
	
	public static void main(String[] args) {
		URLify obj = new URLify() ;
		char[] arr = "Mr John Doe    ".toCharArray() ;
		
		obj.urlifyStringArray(arr) ;
		
		for(char curr : arr) {
			System.out.print(curr) ;
		}
	}
	
	// Makes the changes in the parameter object itself
	private void urlifyStringArray(char[] arr) {
		int ptr1 = arr.length-1 ;
		int ptr2 = arr.length-1 ;
		
		while(arr[ptr1] == ' ') {
			ptr1-- ;
		}
		
		while(ptr1 >= 0) {
			if(arr[ptr1] == ' ') {
				arr[ptr2--] = '0' ;
				arr[ptr2--] = '2' ;
				arr[ptr2--] = '%' ;
			}
			else {
				arr[ptr2--] = arr[ptr1] ;
			}
			ptr1-- ;
		}
	}
}
