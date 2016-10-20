package chapter5;

public class DoubleToString_Test {

	public static void main(String[] args) {
		DoubleToStringConverter converter = new DoubleToStringConverter() ;
		converter.printDouble(0.473213546) ;
	}

}

class DoubleToStringConverter {
	public void printDouble(double num) {
		
		if(num <= 0 || num >= 1) {
			System.out.println("Error") ;
			return ;
		}
		
		StringBuilder bitString = new StringBuilder("0.") ;
		
		for(int i=1 ; i<=32 && num != 0.0 ; i++) {
			num *= 2 ;
			
			if(num >= 1) {
				bitString.append("1") ;
				num -= 1 ;
			}
			else
				bitString.append("0") ;
		}
		
		if(num != 0) {
			System.out.println("Error") ;
		}
		
		System.out.println(bitString) ;
	}
}