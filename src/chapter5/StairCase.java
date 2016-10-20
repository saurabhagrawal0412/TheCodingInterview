package chapter5;

public class StairCase {

	public static void main(String[] args) {
		
		int n = 100 ;
		StringBuilder spaces = new StringBuilder() ;

		for(int i=1 ; i<=n ; i++) {
			spaces.append(" ") ;
		}

		StringBuilder stars = new StringBuilder("*") ;

		StringBuilder temp ;

		for(int i=1 ; i<=n ; i++) {
			spaces.deleteCharAt(0) ;
			temp = new StringBuilder() ;
			temp.append(spaces) ;
			temp.append(stars) ;
			System.out.println(temp) ;
			stars.append("*") ;
        }
	}

}
