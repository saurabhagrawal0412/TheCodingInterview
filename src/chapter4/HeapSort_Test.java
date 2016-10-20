package chapter4;

import java.util.Random;

public class HeapSort_Test {

	public static void main(String[] args) {
		int inputLength = 25 ;
		Random rand = new Random() ;
		int[] input = new int[inputLength] ;
		System.out.println("Input array") ;
		for(int i=0 ; i<input.length ; i++) {
			input[i] = rand.nextInt(1000) ;
			System.out.print(input[i] + " ") ;
		}
		System.out.println() ;
		
		HeapSort sorter = new HeapSort(input) ;
		sorter.sort() ;
		sorter.printHeap(inputLength-1) ;
	}
}

class HeapSort {
	private int[] input, heap ;
	private int heapIndex = -1 ;
	
	public HeapSort(int[] input) {
		this.input = input ;
		heap = new int[input.length] ;
	}
	
	public void sort() {
		for(int i=0 ; i<input.length ; i++) {
			insert(input[i]) ;
		}
		for(int i=0 ; i<input.length ; i++) {
			extractMax() ;
		}
	}
	
	public void insert(int element) {
		heapIndex++ ;
		heap[heapIndex] = element ;
		
		int level = getLevel(heapIndex) ;
		int current = heapIndex, parentIndex ;
		
		//System.out.println("index=" + heapIndex + " level=" + level + " parent=" + parentIndex) ;
		
		for(int i=level ; i> 1 ; i--) {
			parentIndex = getParent(current) ;
			if(heap[current] > heap[parentIndex]) {
				swap(current, parentIndex) ;
				current = parentIndex ;
			}
			else
				break ;
		}
		printHeap(heapIndex) ;
	}
	
	public void extractMax() {
		System.out.println("Inside extractMax") ;
		input[heapIndex] = heap[0] ;
		
		swap(0,heapIndex) ;
		heapIndex-- ;
		System.out.println("heapIndex=" + heapIndex) ;
		int level = getLevel(heapIndex) ;
		int bigger, lIndex, rIndex, current=0 ;
		for(int i=1 ; i<level ; i++) {
			lIndex = (current*2) + 1 ;
			lIndex = (lIndex <= heapIndex) ? lIndex : -1 ;
			
			rIndex = (current*2) + 2 ;
			rIndex = (rIndex <= heapIndex) ? rIndex : -1 ;
			
			if(lIndex == -1 && rIndex == -1)
				break ;
			
			bigger = findBigger(lIndex, rIndex) ;
			System.out.println("current=" + current + " lIndex=" + lIndex +
					" rIndex=" + rIndex + " bigger=" + bigger) ;
			
			if(heap[bigger] > heap[current]) {
				swap(current, bigger) ;
				current = bigger ;
			}
			else
				break ;
		}
		printHeap(heapIndex) ;
	}
	
	public int getLevel(int heapIndex) {
		return ( (int) (Math.log(heapIndex+1)/Math.log(2)) + 1 ) ;
	}
	
	public int getParent(int heapIndex) {
		return (int) Math.ceil( (heapIndex+1)/2) - 1 ;
	}
	
	public void swap(int first, int second) {
		
		int temp = heap[first] ;
		heap[first] = heap[second] ;
		heap[second] = temp ;
	}
	
	public void printHeap(int heapIndex) {
		for(int i=0 ; i<=heapIndex ; i++)
			System.out.print(heap[i] + " ") ;
		System.out.println() ;
	}
	
	public int findBigger(int first, int second) {
		if(first == -1 && second != -1)
			return second ;
		else if(first != -1 && second == -1)
			return first ;
		else if(first != -1 && second != -1)
			return (heap[first]<=heap[second]) ? second : first ;
		else
			return -1 ;
	}
}
