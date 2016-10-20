package chapter3 ;

import java.util.LinkedList ;

public class AnimalShelter_Test {

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter() ;
		
		for(int i=1 ; i<=5 ; i++)
			shelter.enqueue( (i%2==1) ? 'D' : 'C') ;
		for(int i=1 ; i<=5 ; i++)
			shelter.dequeue( (i%2==1) ? 'C' : 'D') ;
	}
}

class Animal {
	private char type ;
	private int distanceFromNext = -1 ;
	
	public Animal(char type) {
		this.type = type ;
	}

	public char getType() {
		return type ;
	}

	public void setType(char type) {
		this.type = type ;
	}

	public int getDistanceFromNext() {
		return distanceFromNext ;
	}

	public void setDistanceFromNext(int distanceFromNext) {
		this.distanceFromNext = distanceFromNext ;
	}
}

class AnimalShelter {
	
	private LinkedList<Animal> animalQueue = new LinkedList<Animal>() ;
	private int[] heads = {-1,-1} ;
	private int[] tails = {-1,-1} ;
	
	public void enqueue(char animalType) {
		Animal animal = new Animal(animalType) ;
		animalQueue.add(animal) ;
		
		int animalIndex ;
		if(animalType == 'D')
			animalIndex = 0 ;
		else
			animalIndex = 1 ;
		
		if(heads[animalIndex] == -1) {
			heads[animalIndex] = 0 ;
			tails[animalIndex] = 0 ;
		}
		else {
			animalQueue.get(tails[animalIndex]).
				setDistanceFromNext(animalQueue.size()-1-tails[animalIndex]) ;
			tails[animalIndex] = animalQueue.size() - 1 ;
		}
	}
	
	public void dequeue(char animalType) {
		int animalIndex ;
		
		if(animalType == 'C')
			animalIndex = 1 ;
		else if(animalType == 'D')
			animalIndex = 0 ;
		else
			animalIndex = (heads[0] > heads[1]) ? 1 : 0 ;
		
		heads[animalIndex] = animalQueue.get(animalIndex).getDistanceFromNext() ;
		animalQueue.remove(heads[animalIndex]) ;
		
		for(int i=0 ; i<=1 ; i++) {
			heads[i] -- ;
			tails[i] -- ;
		}
	}
}