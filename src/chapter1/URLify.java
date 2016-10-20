package chapter1;

public class URLify
{
	//Unconvincing
	public static void main(String[] args)
	{
		String str = "Mr John Smith" ;
		char[] c = str.toCharArray() ;
		
		StringBuilder sb = new StringBuilder() ;
		
		for(char c1 : c)
		{
			if(c1==' ')
			{
				sb.append("%20") ;
			}
			else
			{
				sb.append(c1) ;
			}
		}
		System.out.println(sb) ;
	}
}
