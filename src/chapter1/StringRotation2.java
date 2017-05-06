package chapter1;

public class StringRotation2 {

	public static void main(String[] args) {
		StringRotation2 obj = new StringRotation2() ;
		System.out.println(obj.isRotatedString("bufbuf1", "fbuf1bu")) ;
		System.out.println(obj.isRotatedString("bufbuf1", "fbufbu1")) ;
		System.out.println(obj.isRotatedString("waterbottle", "erbottlewat"));
	}

	private boolean isRotatedString(final String word1, final String word2) {
		if(word1 == null || word2 == null 
				|| word1.length() <= 0 || word2.length() <= 0 
				|| word1.length() != word2.length()) {
			return false ;
		}
		
		int index1 = 0, index2 = 0 ;
		for(int rounds=0 ; (index1<word1.length() ) && (rounds < 2*word1.length() ) ; rounds++) {
			if(word1.charAt(index1) == word2.charAt(index2)) {
				index1++ ;
			}
			else {
				index1 = 0 ;	
			}
			index2 = (index2+1) % word1.length() ;
		}
		
		if(index1 == word1.length()) {
			return true ;
		}
		else {
			return false ;
		}
	}
}
