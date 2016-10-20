package chapter5;

public class Insertion_Test {

	public static void main(String[] args) {
		Inserter inserter = new Inserter() ;
		int insertedVal = inserter.insert(64, 3, 3, 2) ;
		System.out.println(insertedVal) ;
	}
}

class Inserter {
	public int insert(int first, int second, int start, int end) {
		int mask = ~0 ;
		mask = mask<<start ;
		mask = mask + (int)(Math.pow(2, end)) - 1 ;
		
		first = first & mask ;
		second = second << end ;
		return (first | second) ;
	}
}