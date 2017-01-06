package chapter17;

public class CountOf2s {

	public static void main(String[] args) {
		CountOf2s obj = new CountOf2s() ;
		int count = obj.countTwosMethod1(21) ;
		System.out.println(count) ;
	}

	//Method 1
	int countTwosMethod1(int upper) {
		int count = 0 ;
		int currCount = 0 ;
		for(int i=0 ; i<=upper ; i++) {
			currCount = countTwoInInt(i) ;
			count += currCount ;
		}
		return count ;
	}

	private int countTwoInInt(int num) {
		int count = 0 ;
		while(num>0) {
			if(num%10 == 2) {
				count++ ;
			}
			num /= 10 ;
		}
		return count ;
	}
	//Method 1 end
	
	//Method 2
	int countTwosMethod2(int upper) {
		int count = 0 ;
		
		return count ;
	}
}
