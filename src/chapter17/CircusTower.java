package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CircusTower {

	public static void main(String[] args) throws IllegalInputSizeException {
		CircusTower obj = new CircusTower() ;
		ArrayList<Person> people = obj.generateInput() ;
		int maxHeight = obj.findMaxHeight(people) ;
		System.out.println("Max height = " + maxHeight) ;
	}
	
	private ArrayList<Person> generateInput() {
		ArrayList<Person> input = new ArrayList<>() ;
		
		Person p1 = new Person(65, 100) ;
		input.add(p1) ;
		
		Person p2 = new Person(70, 150) ;
		input.add(p2) ;
		
		Person p3 = new Person(56, 90) ;
		input.add(p3) ;
		
		Person p4 = new Person(75, 190) ;
		input.add(p4) ;
		
		Person p5 = new Person(60, 95) ;
		input.add(p5) ;
		
		Person p6 = new Person(68, 110) ;
		input.add(p6) ;
		
		return input ;
	}

	int findMaxHeight(ArrayList<Person> people) throws IllegalInputSizeException {
		//Boundary cases
		if(people == null || people.size() == 0) {
			throw new IllegalInputSizeException() ;
		}
		else if(people.size() == 1) {
			return people.get(0).height ;
		}
		//Boundary cases handled

		Collections.sort(people, new PersonComparator()) ;
		Person curr, prev ;
		int currHeight ;
		for(int i=1 ; i<people.size() ; i++) {
			curr = people.get(i) ;
			for(int j=i-1 ; j>=0 ; j--) {
				prev = people.get(j) ;
				if(curr.height > prev.height && curr.weight > prev.weight) {
					currHeight = curr.height + prev.height ;
					if(currHeight > curr.maxHeight) {
						curr.maxHeight = currHeight ;
						curr.prevIndex = j ;
					}
				}
			}
		}
		int maxHeight = people.get(0).maxHeight, maxIndex = 0 ;
		for(int i=1 ; i<people.size() ; i++) {
			curr = people.get(i) ;
			if(curr.maxHeight > maxHeight) {
				maxHeight = curr.maxHeight ;
				maxIndex = i ;
			}
		}
		trace(people, maxIndex) ;
		return maxHeight ;
	}

	private void trace(ArrayList<Person> people, int maxIndex) {
		Person curr ;
		while(maxIndex != -1) {
			curr = people.get(maxIndex) ;
			System.out.println("Height=" + curr.height + " Weight=" + curr.weight) ;
			maxIndex = curr.prevIndex ;
		}
	}
}

class Person {
	int height ;
	int weight ;
	int maxHeight ;
	int prevIndex ;
	
	Person(int height, int weight) {
		this.height = height ;
		this.weight = weight ;
		maxHeight = height ;
		prevIndex = -1 ;
	}
}

class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.height < p2.height) {
			return -1 ;
		}
		else if(p1.height > p2.height) {
			return 1 ;
		}
		else {
			if(p1.weight < p2.weight) {
				return -1 ;
			}
			else if(p1.weight > p2.weight) {
				return 1 ;
			}
			else {
				return 0 ;
			}
		}
	}
	
}