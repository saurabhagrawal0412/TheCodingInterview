package chapter1;

public class StringRotation
{
	private String str1="waterbottle" , str2="erbottlewat" ;

	public static void main(String[] args)
	{
		StringRotation sr = new StringRotation() ;
		boolean isPermuation = sr.checkPermutation() ;
		if(isPermuation)
			System.out.println(sr.str1 + " and " + sr.str2 + " are permutations") ;
		else
			System.out.println(sr.str1 + " and " + sr.str2 + " are not permutations") ;
		
		System.out.println("Alternate method") ;
		sr.alternateMethod() ;
	}

	private boolean checkPermutation()
	{
		System.out.println("String1=" + str1 + " String2=" + str2) ;
		if(str1.length() != str2.length())
			return false ;
		
		boolean isPermuation = false ;
		int index=-1 ;
		
		for(int i=0 ; i<str1.length() ; i++)
		{
			if(i>0 && index==-1)
				break ;
			
			for(int j=0 ; j<str2.length() ; j++)
			{
				System.out.println("i=" + str1.charAt(i)) ;
				System.out.println("Index=" + index) ;
				if(index==-1)
				{
					System.out.println("j=" + str2.charAt(j)) ;
					
					if(str1.charAt(i) == str2.charAt(j))
					{
						index = j+1 ;
						break ;
					}
					else
					{
						continue ;
					}
				}
				else if(index!=-1)
				{
					if(index>=str2.length())
					{
						index = index - str2.length() ;
					}
					System.out.println("index=" + str2.charAt(index)) ;
					
					if(str1.charAt(i) == str2.charAt(index))
					{
						index++ ;
						break ;
					}
					else
					{
						index = -1 ;
						break ;
					}
				}				
			}
			if(index != -1)
				isPermuation = true ;
			else
				isPermuation = false ;
		}
		
		return isPermuation ;
	}
	
	private void alternateMethod()
	{
		String str3 = str2 + str2 ;
		
		System.out.println(str3.lastIndexOf(str1)) ;
		
	}
}
