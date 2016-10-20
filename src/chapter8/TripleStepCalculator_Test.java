package chapter8;

public class TripleStepCalculator_Test {

	public static void main(String[] args) {
		TripleStepCalculator obj = new TripleStepCalculator() ;
		int ways = obj.calculateWays(3) ;
		System.out.println("Ways = " + ways) ;
	}

}

class TripleStepCalculator {
	public int calculateWays(int stepCount) {
		int ways ;
		if(stepCount <= 0) {
			ways = 0 ;
		}
		else if(stepCount == 1) {
			ways = 1 ;
		}
		else if(stepCount == 2) {
			ways = 2 ;
		}
		else {
			int[] stepMatrix = new int[stepCount+1] ;
			stepMatrix[0] = 1 ;
			stepMatrix[1] = 1 ;
			stepMatrix[2] = 2 ;
			
			for(int i=3 ; i<=stepCount ; i++) {
				stepMatrix[i] = stepMatrix[i-1] + stepMatrix[i-2] + stepMatrix[i-3] ; 
			}
			ways = stepMatrix[stepCount] ;
		}
		return ways ;
	}
}