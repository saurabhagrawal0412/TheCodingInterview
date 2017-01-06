package chapter17;

import java.util.ArrayList ;
import java.util.HashMap ;

public class BabyNames {

	public static void main(String[] args) {
		
	}
	
	ArrayList<BabyName> findRealFrequency(ArrayList<BabyName> input, ArrayList<NamePair> namePairs) {
		ArrayList<BabyName> output = new ArrayList<>() ;
		HashMap<String, BabyName> nameMap = new HashMap<>() ;
		for(BabyName tBaby: input) {
			nameMap.put(tBaby.name, tBaby) ;
		}
		for(NamePair namePair: namePairs) {
			BabyName first = nameMap.get(namePair.first) ;
			BabyName second = nameMap.get(namePair.second) ;
			first.neighbors.add(second) ;
			second.neighbors.add(first) ;
		}
		
		for(String name: nameMap.keySet()) {
			int total = 0 ;
			BabyName babyName = nameMap.get(name) ;
			ArrayList<BabyName> bfsQueue = new ArrayList<>() ;
			bfsQueue.add(babyName) ;
			
			while(! bfsQueue.isEmpty()) {
				BabyName temp = bfsQueue.get(0) ;
				bfsQueue.remove(0) ;
				total += temp.freq ;
				bfsQueue.addAll(temp.neighbors) ;
			}
		}
		
		return output ;
	}
}

class BabyName {
	String name ;
	int freq ;
	ArrayList<BabyName> neighbors = new ArrayList<BabyName>() ;
	boolean isVisited = false ;
	
	public BabyName(String name, int freq) {
		this.name = name;
		this.freq = freq;
	}
}

class NamePair {
	String first ;
	String second ;
	
	NamePair(String first, String second) {
		this.first = first ;
		this.second = second ;
	}
}
