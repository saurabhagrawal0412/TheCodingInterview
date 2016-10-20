package chapter5;

/*public class Temp {

	public static void main(String[] args) {
		System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE) ;
		System.out.println("Float.MAX_EXPONENT = " + Float.MAX_EXPONENT) ;
		System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE) ;
		System.out.println("Float.MIN_EXPONENT = " + Float.MIN_EXPONENT) ;
		
		System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE) ;
		System.out.println("Double.MAX_EXPONENT = " + Double.MAX_EXPONENT) ;
		System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE) ;
		System.out.println("Double.MIN_EXPONENT = " + Double.MIN_EXPONENT) ;
		
		Double d = 0.23456789 ;
		String dStr = d.toHexString(d) ;
		System.out.println("dStr = " + dStr) ;
		
		Integer i = 456 ;
		String iStr = i.toBinaryString(i) ;
		System.out.println("iStr = " + iStr);
		
		Float f = 1.234f ;
		String fStr = f.toHexString(f) ;
		System.out.println("fStr = " + fStr);
		
		double d1 = ~2 ;
		//d1 = d1 >> 1 ; //Not allowed
		System.out.println(d1) ;
		int i1 = 4 ;
		i1 = i1 >> 1 ;
		
		int hex = 0xAAAAAAAA ;
		System.out.println(hex) ;
		
		int temp = 10000 * 10000 ;
		System.out.println(temp);
		
		String s1 = "pale" ;
		String s2 = "ple" ;
		
		OneAwayStatus status = OneAwayStatus.ZEROAWAY ;
		
		if(s1.length() == s2.length()) {
			
			for(int i=0 ; i<s1.length() && status != OneAwayStatus.FALSE ; i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					if(status == OneAwayStatus.ZEROAWAY)
						status = OneAwayStatus.ONEAWAY ;
					else if(status == OneAwayStatus.ONEAWAY)
						status = OneAwayStatus.FALSE ;
				}
			}
		}
		
		else {
			String bigger = (s1.length() > s2.length()) ? s1 : s2 ;
			String smaller = (s1.length() < s2.length()) ? s1 : s2 ;
			
			for(int i=0, j=0 ; i<bigger.length() && status != OneAwayStatus.FALSE ; i++, j++) {
				if(s1.charAt(i) != s2.charAt(j)) {
					if(status == OneAwayStatus.ZEROAWAY) {
						status = OneAwayStatus.ONEAWAY ;
						j-- ;
					}
					else
						status = OneAwayStatus.FALSE ;
				}
			}
		}
		
		System.out.println(status) ;
	}

}

enum OneAwayStatus {
	ZEROAWAY,
	ONEAWAY,
	FALSE
}*/

public class Temp {
	public static void main(String[] args) {
		int i = 4 ;
		char c = (char)(i+48) ;
		
		System.out.println(c) ;
	}
}