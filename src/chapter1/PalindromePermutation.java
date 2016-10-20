package chapter1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PalindromePermutation
{

	public static void main(String[] args)
	{
		PalindromePermutation pp = new PalindromePermutation() ;
		pp.checkPalindrome("Tactcat") ;
	}

	private void checkPalindrome(String input)
	{
		int[] chars = new int[26] ;
		ArrayList<Integer> spaces = new ArrayList<Integer>() ;
		
		int t ;
		char c ;
		for(int i=0 ; i<input.length() ; i++)
		{
			c = input.charAt(i) ;
			if(c == ' ')
				spaces.add(i) ;
			else
			{
				t = (int) Character.toLowerCase(c) ;
				chars[t-97] += 1 ;
			}
		}
		
		char t3 ;
		for(int t2=0 ; t2<chars.length ; t2++)
		{
			t3 = (char)(t2+97) ;
			System.out.println(t3 + " " + chars[t2]) ;
		}
		
		int odds = 0 ;
		boolean isPalindrome = true ;
		for(int t4=0 ; t4<chars.length ; t4++)
		{
			if(chars[t4]%2 != 0)
			{
				odds++ ;
			}
			if(odds >= 2)
			{
				System.out.println("Odds out") ;
				isPalindrome = false ;
				break ;
			}
		}
		if(isPalindrome == false)
		{
			System.out.println("Palindrome not working") ;
			return ;
		}
		else
		{
			System.out.println("Working is Palindrome") ;
		}
		
		//Making palindromes
		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>() ;
		char t5 ;
		for(int i=0 ; i<chars.length ; i++)
		{
			if(chars[i] > 0)
			{
				t5 = (char)(i+97) ;
				coordinates.add(new Coordinates(t5, chars[i])) ;
			}
		}
		
		for(Coordinates c3 : coordinates)
		{
			System.out.println(c3.c + " " + c3.count) ;
		}
		
		
	}

}

class Coordinates
{
	public char c ;
	public int count ;
	
	public Coordinates(char c , int count)
	{
		this.c = c ;
		this.count = count ;
	}
}
