package chapter5;

public class GetAndSetBits_Test {

	public static void main(String[] args) {
		GetAndSetBits_Test obj = new GetAndSetBits_Test() ;
		System.out.println(obj.getBit(16, 3)) ;
		System.out.println(obj.setBit(2, 0)) ;
		System.out.println(obj.findMSB(16)) ;
		
		int a = 0 ;
		int b = ~a ;
		System.out.println("b=" + b) ;
		
		System.out.println(obj.changeBit(25, 0)) ;
		System.out.println(obj.isSquareOfTwo(127)) ;
		
	}
	
	private boolean getBit(int num, int posn) {
		int mask = 1 << posn ;
		return (num & mask) != 0 ;
	}
	
	private int setBit(int num, int posn) {
		int mask = 1 << posn ;
		return (num | mask) ;
	}
	
	private int findMSB(int num) {
		int msbIndex = 0 ;
		int temp = num ;
		while(temp>>1 > 0) {
			temp = temp >> 1 ;
			msbIndex ++ ;
		}
		return msbIndex ;
	}
	
	private int changeBit(int num, int index) {
		int mask = 1 ;
		mask = mask << index ;
		return num ^ mask ;
	}
	
	private boolean isSquareOfTwo(int num) {
		int temp = (num & (num-1)) ;
		
		if(temp == 0)
			return true ;
		else
			return false ;
	}
}
