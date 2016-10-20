package chapter1;

public class RotateMatrix
{

	public static void main(String[] args)
	{
		RotateMatrix rm = new RotateMatrix() ;
		
		int[][] image = new int[4][3] ;
		int counter = 0 ;
		for(int i=0 ; i<image.length ; i++)
		{
			for(int j=0 ; j<image[0].length ; j++)
			{
				image[i][j] = counter++ ;
			}
		}
		
		/*char rotation = 'l' ;
		for(int[] t1 : image)
		{
			for(int t2 : t1)
				System.out.print(t2 + " ") ;
			System.out.println();
		}
		image = rm.doRotate(image , rotation) ;
		for(int[] t1 : image)
		{
			for(int t2 : t1)
				System.out.print(t2 + " ") ;
			System.out.println();
		}
		
		System.out.println("\n\n\n\n") ;*/
		
		char rotation = 'r' ;
		for(int[] t1 : image)
		{
			for(int t2 : t1)
				System.out.print(t2 + " ") ;
			System.out.println();
		}
		image = rm.doRotate(image , rotation) ;
		
		System.out.println("\n\n") ;
		
		for(int[] t1 : image)
		{
			for(int t2 : t1)
				System.out.print(t2 + " ") ;
			System.out.println();
		}
	}

	private int[][] doRotate(int[][] image, char rotation)
	{
		int rows = image[0].length ;
		int columns = image.length ;
		int[][] rImage = new int[rows][columns] ;
		rows -- ;
		columns -- ;
		for(int i=0 ; i<image.length ; i++)
		{
			for(int j=0 ; j<image[0].length ; j++)
			{
				if(rotation == 'l')
					rImage[rows-j][i] = image[i][j] ;
				else if(rotation == 'r')
					rImage[j][columns-i] = image[i][j] ;
			}
		}
		return rImage ;
	}

}
