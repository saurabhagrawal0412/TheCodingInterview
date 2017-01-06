package chapter17;

import java.util.HashMap;

class SSIndex {
	int start = -1 ;
	int end  = -1 ;
	int length = Integer.MAX_VALUE ;

	public SSIndex() {}

	public SSIndex(int start, int end) {
		this.start = start ;
		this.end = end ;
		setLength() ;
	}
	
	public void setStart(int start) {
		this.start = start ;
		setLength() ;
	}

	public void setEnd(int end) {
		this.end = end ;
		setLength() ;
	}

	public void setLength() {
		length = end - start + 1 ;
	}
	
	public String toString() {
		return "start=" + start + " end=" + end + " length=" + length ;
	}
}

public class ShortestSupersequenceFinder {

	public static void main(String[] args) {
		ShortestSupersequenceFinder obj = new ShortestSupersequenceFinder() ;
		int[] longer = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7} ;
		int[] shorter = {1, 5, 9} ;
		obj.findShortestSubsequence(longer, shorter) ;
	}

	SSIndex findShortestSubsequence(int[] longer, int[] shorter) {
		HashMap<Integer, Integer> prev = new HashMap<>() ;
		HashMap<Integer, Integer> curr = new HashMap<>() ;
		SSIndex sIndex = new SSIndex() ;
		SSIndex pIndex, cIndex ;
		for(int temp: shorter) {
			prev.put(temp, -1) ;
			curr.put(temp, -1) ;
		}
		int num = 0 ;
		
		for(int i=0 ; i<longer.length ; i++) {
			num = longer[i] ;
			
			if(prev.containsKey(num)) {

				if(prev.get(num) == -1) {
					prev.put(num, i) ;
					curr.put(num, i) ;
				}

				else if(curr.get(num) != -1) {
					prev.put(num, curr.get(num)) ;
					curr.put(num, i) ;
				}

				pIndex = getSSIndex(prev) ;
				if(pIndex != null && pIndex.length < sIndex.length) {
					sIndex = pIndex ;
				}
				cIndex = getSSIndex(curr) ;
				if(cIndex != null && cIndex.length < sIndex.length) {
					sIndex = cIndex ; 
				}
			}
		}
		System.out.println("Ultimate answer") ;
		System.out.println("sIndex = " + sIndex.toString()) ;
		return sIndex ;
	}

	private SSIndex getSSIndex(HashMap<Integer, Integer> map) {
		int curr, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE ;

		for(int temp: map.keySet()) {
			curr = map.get(temp) ;
			if(curr == -1) {
				return null ;
			}
			else {
				if(curr < start) {
					start = curr ;
				}
				if(curr > end) {
					end = curr ;
				}
			}
		}
		SSIndex sIndex = new SSIndex(start, end) ;
		return sIndex ;
	}
}
