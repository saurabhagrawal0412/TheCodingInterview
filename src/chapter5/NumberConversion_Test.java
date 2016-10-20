package chapter5;

public class NumberConversion_Test {

	public static void main(String[] args) {
		NumberConversion obj = new NumberConversion() ;
		int flipCount = obj.getFlipCount(4,3) ;
		System.out.println("flipCount = " + flipCount) ;
	}

}

class NumberConversion {
	public int getFlipCount(int num1, int num2) {
		int flipCount = 0 ;
		int differences = num1 ^ num2 ;
		
		while(differences > 0) {
			flipCount++ ;
			differences = differences & (differences-1) ;
		}
		
		return flipCount ;
	}
}