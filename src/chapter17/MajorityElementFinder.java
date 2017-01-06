package chapter17;

public class MajorityElementFinder {

	public static void main(String[] args) {
		MajorityElementFinder obj = new MajorityElementFinder() ;
		int[] input = {1, 2, 5, 9, 5, 9, 5, 5, 5} ;
		int majorityElement ;
		try {
			majorityElement = obj.findMajorityElement(input) ;
			System.out.println("Majority Element = " + majorityElement) ;
		} catch(MajorityElementNotFound e) {
			System.out.println("Majority Element not found") ;
		}
	}

	int findMajorityElement(int[] input) throws MajorityElementNotFound {
		int majorityElement = input[0], count = 0 ;
		
		for(int i=0 ; i<input.length ; i++) {
			if(count == 0 || majorityElement == input[i]) {
				majorityElement = input[i] ;
				count ++ ;
			}
			else {
				count-- ;
			}
		}
		if(count>0) {
			return majorityElement ;
		}
		else {
			throw new MajorityElementNotFound() ;
		}
	}
}
