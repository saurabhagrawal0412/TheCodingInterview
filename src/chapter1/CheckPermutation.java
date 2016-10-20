package chapter1;

public class CheckPermutation
{

	public static void main(String[] args)
	{
		String input1 = "abbadc" ;
		String input2 = "bacdbad" ;
		boolean isPermutation = true ;
		char[] i1 , i2 ;
		i1 = input1.toCharArray() ;
		i2 = input2.toCharArray() ;
		
		int[] chars = new int[256] ;
		for(char temp : i1)
			chars[((int)temp) -1] += 1 ;
		
		int t1 ;
		for(char temp : i2)
		{
			t1 = ((int)temp) -1 ;
			chars[t1] -= 1 ;
			if(chars[t1] == -1)
			{
				isPermutation = false ;
				break ;
			}
		}
		
		if(isPermutation == false)
			System.out.println("Not a permutation") ;
		else
			System.out.println("A permutation") ;
	}
	
	private void displayChars(int[] chars)
	{
		for(int i=0 ; i<chars.length ; i++)
		{
			if(chars[i] > 0)
				System.out.println((char)(i+1) + " " + chars[i] ) ;
		}
	}

}
