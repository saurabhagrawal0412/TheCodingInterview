package chapter8;

import java.util.Arrays;

public class OmSolution2 {

	public static void main(String[] args) {
		OmSolution2 obj = new OmSolution2();
		int arr[] = { 1, 2, 6, 5, 5, 8, 9 };
		int count = obj.solution(arr);

		System.out.println(count);

		count = obj.solution2(arr);

		System.out.println(count);

		count = obj.solution3(arr);

		System.out.println(count);
	}

	public int solution(int[] A) {
		int len = 0;
		boolean isEntered = false;
		int i, j = 0;
		for (i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				isEntered = true;
				for (j = i + 1; j < A.length; j++) {
					if (A[j] > A[i]) {
						len = j - i;
					}
				}
			}
			if (isEntered)
				break;
		}

		System.out.println("i = " + i);
		System.out.println("j = " + j);
		return len;

	}

	public int solution2(int[] A) {
		int len = 0;

		boolean isSorted = true;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				isSorted = false;
				break;
			}
		}
		if (isSorted)
			return len;

		int[] sorted = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			sorted[i] = A[i];
		}

		Arrays.sort(sorted);

		/*
		 * for(int t: A) System.out.print(t + " ") ; System.out.println();
		 * 
		 * for(int t: sorted) System.out.print(t + " ") ; System.out.println();
		 */

		int front = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != sorted[i]) {
				front = i;
				break;
			}
		}

		int back = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] != sorted[i]) {
				back = i;
				break;
			}
		}

		len = back - front + 1;

		return len;
	}

	int solution3(int arr[]) {
		int n = arr.length;
		int start = 0, end = n - 1, max, min;

		for (start = 0; start < n - 1; start++) {
			if (arr[start] > arr[start + 1])
				break;
		}
		if (start == n - 1) {
			return 0;
		}

		for (end = n - 1; end > 0; end--) {
			if (arr[end] < arr[end - 1])
				break;
		}

		max = arr[start];
		min = arr[start];
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

		for (int i = 0; i < start; i++) {
			if (arr[i] > min) {
				start = i;
				break;
			}
		}

		for (int i = n - 1; i >= end + 1; i--) {
			if (arr[i] < max) {
				end = i;
				break;
			}
		}
		return (end - start + 1);
	}
}
