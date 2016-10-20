package chapter3;

public class ThreeInOne
{
	private int[] input ;
	private int[] tops ;
	private int noOfStacks , arraySize ;
	public static void main(String[] args)
	{
		ThreeInOne obj = new ThreeInOne() ;
		obj.noOfStacks=3 ;
		obj.arraySize=12 ;
		obj.constructStacks() ;
		
		for(int temp : obj.tops)
			System.out.println(temp);
	}
	
	private void constructStacks()
	{
		input = new int[arraySize] ;
		tops = new int[noOfStacks] ;
		
		for(int i=1 ; i<noOfStacks ; i++)
		{
			tops[i] = (arraySize/noOfStacks)*i ;
		}
	}
	
	private boolean isFull(int arrayNo)
	{
		if(tops[arrayNo] < (arrayNo+1)*arraySize/noOfStacks)
		{
			return false ;
		}
		else
			return true ;
	}
	
	private boolean isEmpty(int arrayNo)
	{
		if(tops[arrayNo] == arrayNo*arraySize/noOfStacks)
		{
			return true ;
		}
		else
			return false ;
	}
	
	private void push(int arrayNo , int element) throws ArrayFullException
	{
		if(isFull(arrayNo))
			throw new ArrayFullException() ;
		input[tops[arrayNo]+1] = element ;
	}
	
	private int pop(int arrayNo) throws ArrayEmptyException
	{
		if(isEmpty(arrayNo))
			throw new ArrayEmptyException() ;
		tops[arrayNo]-- ;
		return input[tops[arrayNo+1]] ;
	}
	
}

class ArrayFullException extends Exception
{
	public String getMessage()
	{
		return "Array is full" ;
	}
}

class ArrayEmptyException extends Exception
{
	public String getMessage()
	{
		return "Array is full" ;
	}
}