package chapter2;

import java.util.Stack ;
public class Palindrome
{
	MyLinkedList head ;
	public static void main(String[] args)
	{
		Palindrome obj = new Palindrome() ;
		obj.makePalindrome() ;
		obj.printLinkedList() ;
		obj.findPalindrome() ;
	}
	
	private MyLinkedList makePalindrome()
	{
		MyLinkedList current=null , prev=null ;
		int maxValue = 21 ;
		int temp = 105 ;
		for(int i=1 ; i<=maxValue ; i++)
		{
			if((i<=maxValue/2) || (i==(maxValue/2)+1 && maxValue%2==1))
			{
				temp = temp-5 ;
			}
			else if(i>maxValue/2+1)
			{
				temp = temp+5 ;	
			}
			
			if(head == null)
			{
				head = new MyLinkedList() ;
				current = new MyLinkedList(temp,null) ;
				head.setNext(current) ;
				prev = current ;
				
			}
			else
			{
				current = new MyLinkedList(temp,null) ;
				prev.setNext(current) ;
				prev = current ;
			}
		}
		return head ;
	}
	
	private void printLinkedList()
	{
		MyLinkedList current = head.next() ;
		
		while(current != null)
		{
			System.out.print(current.key() + " ") ;
			current = current.next() ;
		}
		System.out.println() ;
	}
	
	private void findPalindrome()
	{
		MyLinkedList slow = head , fast = head ;
		//System.out.println(slow.key() + " " + fast.key()) ;
		Stack<Integer> st = new Stack<Integer>() ;
		int counter = 0 ;
		while(slow.next() != null)
		{
			slow = slow.next() ;
			if(fast.next() != null)
			{
				counter++ ;
				st.push(slow.key()) ;
				fast = fast.next() ;
				if(fast.next() == null)
					continue ;
				else
					fast = fast.next() ;

				System.out.println(slow.key() + " " + fast.key()) ;
			}
			else
			{
				if(counter%2 == 1)
					st.pop() ;
				else
				{
					if(slow.key() == st.lastElement())
						st.pop() ;
				}
			}
		}
		
		System.out.println(st.size()) ;
		if(! st.isEmpty())
			System.out.println(st.elementAt(0)) ;
	}
	
}
