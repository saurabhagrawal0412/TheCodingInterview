package chapter1;

public class RotateSquareMatrix
{

	public static void main(String[] args)
	{
		int[][] matr = new int[4][4] ;
		char dir = 'l' ;
		int counter = 1 ;
		for(int i=0 ; i<matr.length ; i++)
			for(int j=0 ; j<matr[0].length ; j++)
				matr[i][j] = counter++ ;
		
		printMatrix(matr) ;
		
		int t1 , t2 , t3 , t4 ;
		
		for(int i=0 ; i<matr.length/2 ; i++)
		{
			for(int j=i ; j<matr.length-i-1 ; j++)
			{
				t1 = matr[i][j] ;
				t2 = matr[j][matr.length-i-1] ;
				t3 = matr[matr.length-i-1][matr.length-j-1] ;
				t4 = matr[matr.length-j-1][i] ;
				
				System.out.println("Before change") ;
				System.out.println("t1 = " + t1) ;
				System.out.println("t2 = " + t2) ;
				System.out.println("t3 = " + t3) ;
				System.out.println("t4 = " + t4) ;
				
				if(dir=='r')
				{
					matr[i][j] = t4 ;
					matr[j][matr.length-i-1] = t1 ;
					matr[matr.length-i-1][matr.length-j-1] = t2 ;
					matr[matr.length-j-1][i] = t3 ;
				}
				else if(dir=='l')
				{
					matr[i][j] = t2 ;
					matr[j][matr.length-i-1] = t3 ;
					matr[matr.length-i-1][matr.length-j-1] = t4 ;
					matr[matr.length-j-1][i] = t1 ;
				}
			}
		}
		
		printMatrix(matr) ;
	}
	
	private static void printMatrix(int[][] matr)
	{
		System.out.println("\nPrinting matrix") ;
		for(int[] t1 : matr)
		{
			for(int t2 : t1)
				System.out.print(t2 + "\t") ;
			System.out.println() ;
		}
	}

}
