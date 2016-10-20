package chapter5;

public class NextAndPrevLargest_Test {

	public static void main(String[] args) {
		
	}

}

class NextAndPrevLargest {
	public int findNextLargest(int num) {
		int firstOne = findOne(num , 'r') ;
		int lastOne = findOne(num , 'l') ;
		
		boolean isInserted = false ;
		
		for(int i=lastOne ; i>=0 ; i--) {
			if(!getBit(num,i)) {
				num = changeBit(num, i) ;
			}
		}
		return lastOne;
	}

	private int findOne(int num, char c) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean getBit(int num, int i) {
		num = num >> i ;
		return (num%2 == 1) ;
	}
	
	private int changeBit(int num, int index) {
		int mask = 1 ;
		mask = mask << index ;
		return num ^ mask ;
	}
	
}