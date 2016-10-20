package chapter1;

import java.util.ArrayList;

public class Temp
{
	/*public static void main(String[] args)
	{
		String s1 = "HaHaHa" ;
		String s2 = s1 ;
		s1 = "No " + s1 ;
		System.out.println(s1.equals(s2)) ;
		System.out.println(s1 == s2) ;
		
		//System.out.println((int)'a' + " " + (int)'z' + " " + (int)' ') ;
		
		StringBuilder sb = new StringBuilder("abcd") ;
		
		sb.deleteCharAt(2) ;
		System.out.println(sb);
		
	}*/
	
	public static void main(String[] args) {
		ArrayList<Integer> vals = new ArrayList<Integer>() ;
		vals.add(1) ;
		vals.add(3) ;
		
		/*for(int i: vals)
			System.out.println(i) ;*/
		
		vals.add(1,2) ;
		vals.add(0,0) ;
		for(int i: vals)
			System.out.println(i) ;
	}
}
