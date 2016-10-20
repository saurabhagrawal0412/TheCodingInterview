package chapter1 ;

public class ZeroMatrix
{
	private int[][] input =	{
						{5,3,0},
						{2,0,1},
						{1,2,3}
					} ;
	
	public static void main(String[] args)
	{
		ZeroMatrix zm = new ZeroMatrix() ;
		zm.displayInput() ;
		zm.makeZeroMatrix() ;
		System.out.println("\n\n\n") ;
		zm.displayInput() ;
	}

	private void makeZeroMatrix()
	{
		int[] rows = new int[input.length] ;
		int[] cols = new int[input[0].length] ;
		int k=0 ;
		for(int i=0 ; i<input.length ; i++)
		{
			for(int j=0 ; j<input[0].length ; j++)
			{
				if(input[i][j] == 0)
				{
					rows[k] = i ;
					cols[k] = j ;
					k++ ;
				}
			}
		}
		
		for(int l=0 ; l<k ; l++)
		{
			makeZero(rows[l],cols[l]) ;
		}
	}

	private void makeZero(int i , int j)
	{
		for(int k=0 ; k<input.length ; k++)
		{
			input[i][k] = 0 ;
			input[k][j] = 0 ;
		}
	}
	
	private void displayInput()
	{
		for(int[] t1 : input)
		{
			for(int t2 : t1)
				System.out.print(t2 + "\t") ;
			System.out.println() ;
		}
	}
}
