package chapter5;

public class FlipBitToWin_Test {

	public static void main(String[] args) {
		FlipBitToWin obj = new FlipBitToWin() ;
		int length = obj.findLongestSubsequence(1) ;
		System.out.println("length = " + length) ;
	}

}

class FlipBitToWin {
	public int findLongestSubsequence(int num) {
		int currSub = 0 ;
		int prevSub = 0 ;
		int longestSub = 0 ;
		boolean currBit = false ;
		boolean prevBit = false ;
		boolean zeroEncountered = false ;
		
		for(int i=0 ; i<32 ; i++) {
			currBit = getBit(num, i) ;
			
			if(!currBit) {
				if(!prevBit)
					prevSub = 0 ;
				else {
					prevSub = currSub + 1 ;
					currSub = 0 ;
				}
			}
			else {
				zeroEncountered = true ;
				if(prevSub == 0)
					currSub = currSub + 1 ;
				else {
					prevSub = prevSub + 1 ;
					currSub = currSub + 1 ;
				}
			}
			
			if(prevSub > longestSub)
				longestSub = prevSub ;
			if(currSub > longestSub)
				longestSub = currSub ;
			
			prevBit = currBit ;
		}
		
		if(!zeroEncountered)
			return 1 ;
		else
			return longestSub ;
	}

	private boolean getBit(int num, int index) {
		num = num >> index ;
		return (num%2 == 1) ;
	}
	
	
}