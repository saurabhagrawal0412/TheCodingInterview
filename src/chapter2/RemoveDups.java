package chapter2 ;

import java.util.LinkedList ;
import java.util.Random ;

public class RemoveDups
{
	LinkedList<Integer> input = new LinkedList<Integer>() ;
	
	public static void main(String[] args)
	{
		RemoveDups rd = new RemoveDups() ;
		rd.fillData() ;
		rd.displayInput() ;
		rd.removeDuplicates() ;
		rd.displayInput() ;
	}

	private void fillData()
	{
		Random rand = new Random() ;
		for(int i=0 ; i<20 ; i++)
		{
			input.add(rand.nextInt(4)+1) ;
		}
	}
	
	private void displayInput()
	{
		for(int temp : input)
			System.out.print(temp + " ") ;
		System.out.println() ;
	}
	
	private void removeDuplicates()
	{
		for(int i=0 ; i<input.size() ; i++)
		{
			for(int j=0 ; j<input.size() ; j++)
			{
				if(i==j)
					continue ;
				//System.out.println("i=" + i + " j=" + j) ;
				if(input.get(i) == input.get(j))
				{
					input.remove(j) ;
					if(j<i)
						i-- ;
				}
			}
		}
	}

}
