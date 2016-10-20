package chapter1;

public class OneAway
{

	public static void main(String[] args)
	{
		String first = "august" ;
		String second = "ugust" ;
		
		boolean isOneAway = findOneAway(first , second) ;
		if(isOneAway)
			System.out.println("Strings: " + first + " and " + second + " are indeed one away") ;
		else
			System.out.println("Strings: " + first + " and " + second + " are not one away") ;
	}

	private static boolean findOneAway(String first, String second)
	{
		boolean isOneAway = true ;
		int aways = 0 ;
		if(first.length() == second.length())
		{
			System.out.println("Lengths are same") ;
			for(int i=0 ; i<first.length() ; i++)
			{
				if(first.charAt(i) != second.charAt(i))
				{
					aways++ ;
					if(aways >= 2)
					{
						isOneAway = false ;
						break ;
					}
				}
			}
		}
		else
		{
			String bigger = (first.length()>second.length()) ? first : second ;
			String smaller = (first.length()<second.length()) ? first : second ;
			
			int front, back = bigger.length()-1 ;
			
			for(front=0 ; front<smaller.length() ; front++)
			{
				if(bigger.charAt(front) == smaller.charAt(front))
				{
					continue ;
				}
				else
					break ;
			}
			System.out.println("Front = " + front) ;
			
			for(int i=1 ; i<=smaller.length() ; i++)
			{
				back-- ;
				System.out.println("bigger.charAt(bigger.length()-i) = " + bigger.charAt(bigger.length()-i)) ;
				System.out.println("smaller.charAt(smaller.length()-i)" + smaller.charAt(smaller.length()-i)) ;
				
				if(bigger.charAt(bigger.length()-i) == smaller.charAt(smaller.length()-i))
				{
					continue ;
				}
				else
					break ;
			}
			System.out.println("Front=" + front + " Back=" + back) ;
			if(front >= back)
				isOneAway = true ;
			else
				isOneAway = false ;
		}
		
		return isOneAway ; 
	}


}
