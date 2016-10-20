package chapter8;

import java.util.ArrayList;

public class Temp {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>() ;
		list1.add(4) ;
		list1.add(8) ;
		list1.add(12) ;
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1) ;
		list2.add(16) ;
		list1.add(20) ;
		
		list1.set(0, 400) ;
		
		System.out.println("List 1") ;
		for(int i: list1)
			System.out.println(i) ;
		
		System.out.println("List 2") ;
		for(int i: list2)
			System.out.println(i) ;
		
		//ArrayList<Integer> list3 = (ArrayList<Integer>) list2.subList(0, 0) ;
	}

}
