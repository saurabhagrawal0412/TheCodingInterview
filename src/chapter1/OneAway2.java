package chapter1;

public class OneAway2 {

	public static void main(String[] args) {
		OneAway2 obj = new OneAway2() ;
		
		System.out.println(obj.isOneAway("abcd", "adcd")) ;
		System.out.println(obj.isOneAway("abcd", "acd")) ;
		System.out.println(obj.isOneAway("acd", "acd")) ;
		System.out.println(obj.isOneAway("abcd", "bcd")) ;
		System.out.println(obj.isOneAway("abcd", "cd")) ;
		System.out.println(obj.isOneAway("abcd", "aef")) ;
	}

	private boolean isOneAway(final String word1, final String word2) {
		if(word1 == null || word2 == null 
				|| word1.length() <= 0 || word2.length() <= 0 
				|| word1.length() - word2.length() > 1) {
			return false ;
		}
		
		boolean isSameLength = word1.length() == word2.length()  ;
		
		byte edits = 0 ;
		
		for(int i=0, j=0 ; i<word1.length() && j<word2.length() ; i++, j++) {
			char ch1 = word1.charAt(i) ;
			char ch2 = word2.charAt(j) ;
			
			if(ch1 != ch2) {
				edits++ ;
				if(! isSameLength) {
					j-- ;
				}
			}
			if(edits > 1) {
				return false ;
			}
		}
		return true ;
	}
}
