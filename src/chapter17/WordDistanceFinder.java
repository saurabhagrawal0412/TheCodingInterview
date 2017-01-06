package chapter17;

import java.util.ArrayList;
import java.util.HashMap;

public class WordDistanceFinder {

	HashMap<String, ArrayList<Integer>> wordMap ;
	
	public static void main(String[] args) {
		WordDistanceFinder obj = new WordDistanceFinder() ;
		ArrayList<String> text = obj.getInput() ;
		obj.preprocess(text) ;
		int minDist ;
		try {
			minDist = obj.getMinDistance("I", "apple") ;
			System.out.println("minDist = " + minDist) ;
		}
		catch(Exception e) {
			System.out.println("Some exception occurred") ;
			e.getMessage() ;
		}
	}
	
	private ArrayList<String> getInput() {
		ArrayList<String> text = new ArrayList<>() ;
		String temp = "I am eating an apple . I love eating apples . I even have an apple iphone and an apple watch" ;
		String[] tempArray = temp.split(" ") ;
		for(int i=0 ; i<tempArray.length ; i++) {
			String t = tempArray[i] ;
			text.add(t) ;
			System.out.println("index = " + i + " word = " + t) ;
		}
		return text ;
	}

	private void preprocess(ArrayList<String> text) {
		wordMap = new HashMap<>() ;
		ArrayList<Integer> indices ;
		for(int index=0 ; index<text.size() ; index++) {
			String curr = text.get(index) ;
			indices = null ;
			if(!wordMap.containsKey(curr)) {
				indices = new ArrayList<>() ;
				indices.add(index) ;
				wordMap.put(curr, indices) ;
			}
			else {
				wordMap.get(curr).add(index) ;
			}
		}
	}
	
	private int getMinDistance(String first, String second) throws PreprocessingNotPerformedException, IllegalInputException {
		if(wordMap == null || wordMap.size() == 0) {
			throw new PreprocessingNotPerformedException() ;
		}
		else if(!wordMap.containsKey(first) || !wordMap.containsKey(second)) {
			throw new IllegalInputException() ;
		}
		
		ArrayList<Integer> indices1 = wordMap.get(first) ;
		ArrayList<Integer> indices2 = wordMap.get(second) ;
		
		int currDist = 0, minDist = Integer.MAX_VALUE ;
		int index1 = 0, index2 = 0 ;
		
		for(int i=0, j=0 ; i<indices1.size() && j<indices2.size() ; ) {
			index1 = indices1.get(i) ;
			index2 = indices2.get(j) ;
			
			currDist = Math.abs(index1 - index2) ;
			if(currDist < minDist) {
				minDist = currDist ;
			}
			
			if(index1 < index2) {
				i++ ;
			}
			else {
				j++ ;
			}
		}
		return minDist ;
	}
}
