package examples;

import java.util.ArrayList;
import java.util.HashMap;

public class ACubeBCube {

	public static void main(String[] args) {
		ACubeBCube obj = new ACubeBCube() ;
		//obj.employMethod1() ;
		obj.employMethod2() ;
	}
	
	private void employMethod1() {
		System.out.println("Method 1") ;
		for(int i=1 ; i<10 ; i++) {
			for(int j=1 ; j<10 ; j++) {
				for(int k=1 ; k<10 ; k++) {
					int first = (int)Math.pow(i, 3) + (int)Math.pow(j, 3) ;
					int lCube = first - (int)Math.pow(k, 3) ;
					int l = (int)Math.cbrt(lCube) ;
					int second = (int)Math.pow(k, 3) + (int)Math.pow(l, 3) ;

					if(first < 1000 && first == second && i!=k && l>0) {
						System.out.println("Total = " + first) ;
						System.out.printf("i=%d, j=%d, k=%d, l=%d\n", i, j, k, l) ;
					}
				}
			}
		}
	}
	
	private void employMethod2() {
		System.out.println("Method 2") ;
		HashMap<Integer, ArrayList<Pair> > map = new HashMap<>() ;
		
		for(int i=1 ; i<=1000 ; i++) {
			for(int j=1 ; j<=1000 ; j++) {
				int cube = (int)( Math.pow(i, 3) + Math.pow(j, 3) ) ;
				ArrayList<Pair> list ;
				if(map.containsKey(cube)) {
					list = map.get(cube) ;
				}
				else {
					list = new ArrayList<>() ;
					map.put(cube, list) ;
				}
				list.add(new Pair(i, j)) ;
			}
		}
		
		for(int cube : map.keySet()) {
			ArrayList<Pair> pairList = map.get(cube) ;
			
			if(pairList.size() > 2) {
				printList(cube, pairList) ;
			}
		}
	}

	private void printList(int cube, ArrayList<Pair> pairList) {
		System.out.printf("The cubic value is %d \n", cube) ;
		System.out.println("Printing the list") ;
		
		for(Pair pair: pairList) {
			System.out.println(pair.toString()) ;
		}
	}

}

class Pair {
	int first,  second ;

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("First = ") ;
		buffer.append(first) ;
		buffer.append("\nSecond = ") ;
		buffer.append(second) ;
		buffer.append('\n') ;
		return buffer.toString() ;
	}
}