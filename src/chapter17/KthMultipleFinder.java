package chapter17;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthMultipleFinder {
	public static void main(String[] args) {
		KthMultipleFinder obj = new KthMultipleFinder() ;
		int k = 18 ;
		int kthMultiple = obj.findKthMultipleMethod1(k) ;
		System.out.println("kthMultiple by method 1 = " + kthMultiple) ;
		
		kthMultiple = obj.findKthMultipleMethod2(k) ;
		System.out.println("kthMultiple by method 2 = " + kthMultiple) ;
	}

	//Method 1 start
	int findKthMultipleMethod1(int k) {
		int kthMultiple ;
		for(int i=1 ; ; i++) {
			if(isMultiple(i)) {
				k-- ;
			}
			if(k == 0) {
				kthMultiple = i ;
				break ;
			}
		}
		return kthMultiple ;
	}
	
	boolean isMultiple(int num) {
		if(num == 0) {
			return false ;
		}
		else if(num == 1) {
			return true ;
		}
		
		if(num%3 == 0) {
			return isMultiple(num/3) ;
		}
		else if(num%5 == 0) {
			return isMultiple(num/5) ;
		}
		if(num%7 == 0) {
			return isMultiple(num/7) ;
		}
		else {
			return false ;
		}
	}
	//Method 1 end

	//Method 2 start
	int findKthMultipleMethod2(int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>() ;
		queue.add(1) ;
		int curr ;
		for(int i=1 ; i<k ; i++) {
			curr = queue.poll() ;
			if(!queue.contains(curr*3)) {
				queue.add(curr*3) ;
			}
			if(!queue.contains(curr*5)) {
				queue.add(curr*5) ;
			}
			if(!queue.contains(curr*7)) {
				queue.add(curr*7) ;
			}
		}
		return queue.poll() ;
	}
	
	int findKthMultipleMethod3(int k) throws IllegalInputException {
		if(k >= 0) {
			throw new IllegalInputException() ;
		}
		else if(k==1) {
			return 1 ;
		}
		Queue<Integer> threes = new LinkedList<Integer>() ;
		Queue<Integer> fives = new LinkedList<Integer>() ;
		Queue<Integer> sevens = new LinkedList<Integer>() ;

		threes.add(3) ;
		fives.add(5) ;
		sevens.add(7) ;

		int kthMultiple = 0 ;
		int min ;

		for(int i=1 ; i<k ; i++) {
			min = minOf(threes.peek(), fives.peek(), sevens.peek() ) ;
			if(i == k-1) {
				kthMultiple = min ;
				break ;
			}
			else {
				
			}
		}
		return kthMultiple ;
	}

	private int minOf(int num1, int num2, int num3) {
		if(num1 < num2 && num1 < num3) {
			return num1 ;
		}
		else if(num2 < num1 && num2 < num3) {
			return num2 ;
		}
		else {
			return num3 ;
		}
	}
}