package chapter5;

public class PairwiseSwap_Test {

	public static void main(String[] args) {
		PairwiseSwap swapper = new PairwiseSwap() ;
		int swappedVal = swapper.swapPairwise(38) ;
		System.out.println(swappedVal) ;
	}

}

class PairwiseSwap {
	public int swapPairwise(int num) {
		//int evenMask = 0xAAAAAAAA ;
		//int oddMask = 0x55555555 ;
		
		int oddBits = num & 0x55555555 ;
		int evenBits = num & 0xAAAAAAAA ;
		
		return ( (oddBits<<1) | (evenBits>>1) ) ;
	}
}