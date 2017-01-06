package chapter17;

import java.util.ArrayList;

public class WordTransformer_Test {

	HashMapList<String, String> dictList = new HashMapList<>() ;
	public static void main(String[] args) {
		WordTransformer_Test obj = new WordTransformer_Test() ;
		ArrayList<String> dictionary = obj.createDictionary() ;
		obj.preprocessDictionary(dictionary) ;
		obj.transformWord(dictionary.get(0), dictionary.get(dictionary.size()-1)) ;
	}

	private ArrayList<String> createDictionary() {
		ArrayList<String> dictionary = new ArrayList<>() ;
		return dictionary ;
	}

	private void preprocessDictionary(ArrayList<String> dictionary) {
		for(String word : dictionary) {
			ArrayList<String> patterns = getPatterns(word) ;
			for(String pattern: patterns) {
				dictList.put(pattern, word) ;
			}
		}
	}
	
	private ArrayList<String> getPatterns(String word) {
		ArrayList<String> patterns = new ArrayList<>() ;
		for(int i=0 ; i<word.length() ; i++) {
			String pattern = word.substring(0, i) + "_" + word.substring(i+1, word.length()) ;
			patterns.add(pattern) ;
		}
		return patterns ;
	}
	
	private void transformWord(String word1, String word2) {
		ArrayList<WordGraph> fQueue = new ArrayList<>() ;
		WordGraph front = new WordGraph(word1, null, null) ;
		fQueue.add(front) ;
		
		ArrayList<WordGraph> bQueue = new ArrayList<>() ;
		WordGraph back = new WordGraph(word2, null, null) ;
		bQueue.add(back) ;
		
		while(fQueue.size() > 0 && bQueue.size() > 0 && front != back) {
			front = fQueue.get(0) ;
			fQueue.remove(0) ;
			back = bQueue.get(0) ;
			bQueue.remove(0) ;

			if(front == back) {
				break ;
			}
			
			ArrayList<WordGraph> fAdjWords = getAdjacentWords(front.curr, front, null) ;
			fQueue.addAll(fAdjWords) ;
			
			ArrayList<WordGraph> bAdjWords = getAdjacentWords(back.curr, null, back) ;
			bQueue.addAll(bAdjWords) ;
			
			if(front == back) {
				traceGraph(front, word1, word2) ;
			}
			else {
				System.out.println("Transformation not possible") ;
			}
		}
	}

	private ArrayList<WordGraph> getAdjacentWords(String word, WordGraph prev, WordGraph next) {
		ArrayList<String> patterns = getPatterns(word) ;
		ArrayList<WordGraph> adjWordGraph = new ArrayList<>() ;
		
		for(String pattern: patterns) {
			ArrayList<String> adjWords = dictList.get(pattern) ;
			
			for(String adjWord: adjWords) {
				WordGraph curr = new WordGraph(adjWord, prev, next) ;
				adjWordGraph.add(curr) ;
			}
		}
		return adjWordGraph ;
	}
	
	private void traceGraph(WordGraph junction, String word1, String word2) {
		StringBuilder fTrace = traceGraph(junction.prev, word1, false) ;
		StringBuilder bTrace = traceGraph(junction.next, word2, true) ;
		
		StringBuilder fullTrace = fTrace.append(junction.curr) ;
		fullTrace = fullTrace.append(bTrace) ;
		
		System.out.println(fullTrace) ;
	}

	private StringBuilder traceGraph(WordGraph node, String destWord, boolean isForward) {
		StringBuilder trace = new StringBuilder() ;
		while(! node.curr.equals(destWord)) {
			if(!isForward) {
				StringBuilder temp = new StringBuilder(node.curr) ;
				temp.append("->") ;
				trace = temp.append(trace) ;
				node = node.prev ;
			}
			else {
				trace.append("->") ;
				trace = trace.append(node.curr) ;
				node = node.next ;
			}
		}
		return trace ;
	}
}

class WordGraph {
	String curr ;
	WordGraph prev ;
	WordGraph next ;
	boolean isVisited = false ;
	
	WordGraph(String curr, WordGraph prev, WordGraph next) {
		this.curr = curr ;
		this.prev = prev ;
		this.next = next ;
	}
}

