package chapter1;

public class StringCompression
{

	public static void main(String[] args)
	{
		StringCompression sc = new StringCompression() ;
		String input = "aabbccdd" ;
		String output = sc.compressString(input) ;
		System.out.println(output) ;
	}

	private String compressString(String input)
	{
		int iLength = input.length() ;
		if(iLength <= 1)
			return input ;

		StringBuilder intermediate = new StringBuilder() ;
		
		int counter = 1 ;
		char prev=input.charAt(0) ;
		for(int i=1 ; i<input.length() ; i++)
		{
			if(prev == input.charAt(i))
			{
				counter++ ;
			}
			else
			{
				intermediate.append(prev) ;
				intermediate.append(counter) ;
				prev = input.charAt(i) ;
				counter = 1 ;
			}
		}
		intermediate.append(prev) ;
		intermediate.append(counter) ;
		
		if(intermediate.length() < input.length())
			return(intermediate.toString()) ;
		else
			return input ;
	}

}
