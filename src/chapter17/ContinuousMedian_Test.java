package chapter17;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ContinuousMedian_Test {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator()) ;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>() ;
	double median ;

	public static void main(String[] args) {
		ContinuousMedian_Test obj = new ContinuousMedian_Test() ;
		Random rand = new Random() ;
		int count = rand.nextInt(50) ;
		System.out.println("Count=" + count) ;
		for(int i=1 ; i<=count ; i++) {
			obj.addElement(rand.nextInt(count)) ;
		}
		obj.printMedian() ;
	}

	private void addElement(int num) {
		System.out.print(num + " ") ;
		if(maxHeap.size() == 0 && minHeap.size() == 0) {
			maxHeap.add(num) ;
			median = num ;
			return ;
		}

		if(num <= median) {
			maxHeap.add(num) ;
		}
		else {
			minHeap.add(num) ;
		}

		balanceHeaps() ;
		setMedian() ;
	}

	private void balanceHeaps() {
		int diff = maxHeap.size() - minHeap.size() ;
		if(Math.abs(diff) < 2) {
			return ;
		}
		if(diff > 0) {
			minHeap.add(maxHeap.remove()) ;
		}
		else {
			maxHeap.add(minHeap.remove()) ;
		}
	}

	private void setMedian() {
		if(maxHeap.size() > minHeap.size()) {
			median = maxHeap.peek() ;
		}
		else if(maxHeap.size() < minHeap.size()) {
			median = minHeap.peek() ;
		}
		else {
			median = (double)(maxHeap.peek() + minHeap.peek())/2 ;
		}
	}

	private void printMedian() {
		System.out.println("\nMedian = " + median) ;
	}
}

class MaxComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		return num2 - num1 ;
	}
}