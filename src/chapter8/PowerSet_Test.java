package chapter8;

import java.util.ArrayList;

public class PowerSet_Test {

	public static void main(String[] args) {
		PowerSet_Test test = new PowerSet_Test() ;
		PowerSetCalculator1 calculator1 = new PowerSetCalculator1() ;
		ArrayList<Integer> set = new ArrayList<Integer>() ;
		for(int i=1 ; i<=5 ; i++)
			set.add(i) ;
		ArrayList<ArrayList<Integer>> subsets1 = calculator1.returnSubsets(set) ;
		test.printSubsets(subsets1) ;	
	}
	
	public void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
		for(ArrayList<Integer> tempList: subsets) {
			for(int temp: tempList) {
				System.out.print(temp + " ") ;
			}
			System.out.println() ;
		}
	}
}

class PowerSetCalculator1 {
	public ArrayList<ArrayList<Integer>> returnSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>() ;
		if(set == null || set.size() == 0)
			return null ;
		else if(set.size() == 1) {
			subsets.add((ArrayList<Integer>) set.subList(0,0)) ;
			return subsets ;
		}
		
		subsets.add(new ArrayList<Integer>()) ;
		ArrayList<Integer> first = new ArrayList<Integer>() ;
		first.add(set.get(0)) ;
		ArrayList<Integer> second = new ArrayList<Integer>() ;
		second.add(set.get(1)) ;
		subsets.add(first) ;
		subsets.add(second) ;
		ArrayList<Integer> third = new ArrayList<Integer>() ;
		third.add(set.get(0)) ;
		third.add(set.get(1)) ;
		subsets.add(third) ;
		
		if(set.size() > 2) {
			int subsetSize ;
			int value ;
			ArrayList<Integer> tempList1, tempList2 ;
			for(int i=2 ; i<set.size() ; i++) {
				value = set.get(i) ;
				subsetSize = subsets.size() ;
				for(int j=0 ; j<subsetSize ; j++) {
					tempList1 = subsets.get(j) ;
					tempList2 = new ArrayList<Integer>() ;
					for(int k=0 ; k<tempList1.size() ; k++) {
						tempList2.add(tempList1.get(k)) ;
					}
					tempList2.add(value) ;
					subsets.add(tempList2) ;
				}
			}
		}
		return subsets ;
	}
}

class PowerSetCalculator2 {
	public ArrayList<ArrayList<Integer>> returnSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>() ;
		int subsetCount = (int) Math.pow(2, set.size()) ;
		ArrayList<Integer> tempSubset ;
		for(int i=0 ; i<subsetCount ; i++) {
			tempSubset = getSubset(i, set) ;
			subsets.add(tempSubset) ;
		}
		return subsets ;
	}

	private ArrayList<Integer> getSubset(int mask, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>() ;
		for(int i=0 ; i<=4 ; i++) {
			if(mask%2 == 1)
				subset.add(set.get(i)) ;
			mask = mask >> 1 ;
		}
		return subset ;
	}
}