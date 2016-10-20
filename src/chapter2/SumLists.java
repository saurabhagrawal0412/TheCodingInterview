package chapter2 ;

import java.util.Random;

public class SumLists
{
	MyLinkedList head1 = null ;
	MyLinkedList head2 = null ;
	MyLinkedList head3 = null ;
	
	public static void main(String[] args)
	{
		SumLists obj = new SumLists() ;
		obj.fillLinkedLists() ;
		System.out.println("head1") ;
		obj.printLinkedLists(obj.head1) ;
		System.out.println("head2") ;
		obj.printLinkedLists(obj.head2) ;
		obj.sumLinkedLists() ;
		System.out.println("head3") ;
		obj.printLinkedLists(obj.head3) ;
	}
	
	private void fillLinkedLists()
	{
		MyLinkedList current1=null , prev1=null ;
		MyLinkedList current2=null , prev2=null ;
		Random rand = new Random() ;
		int temp1 , temp2 ;
		for(int i=1 ; i<=5 ; i++)
		{
			temp1 = rand.nextInt(9) + 1 ;
			temp2 = rand.nextInt(9) + 1 ;
			//System.out.println("temp1=" + temp1 + " temp2=" + temp2) ;
			if(head1 == null && head2 == null)
			{
				head1 = new MyLinkedList() ;
				head2 = new MyLinkedList() ;
				current1 = new MyLinkedList(temp1,null) ;
				current2 = new MyLinkedList(temp2,null) ;
				head1.setNext(current1) ;
				head2.setNext(current2) ;
				prev1 = current1 ;
				prev2 = current2 ;
				
			}
			else
			{
				current1 = new MyLinkedList(temp1,null) ;
				prev1.setNext(current1) ;
				prev1 = current1 ;
				
				current2 = new MyLinkedList(temp2,null) ;
				prev2.setNext(current2) ;
				prev2 = current2 ;
			}
		}
	}
	
	private void printLinkedLists(MyLinkedList head)
	{
		MyLinkedList current = head.next() ;
		
		while(current.next() != null)
		{
			System.out.print(current.key() + " ") ;
			current = current.next() ;
		}
		System.out.println() ;
	}
	
	private void sumLinkedLists()
	{
		MyLinkedList list1 = new MyLinkedList() ;
		list1.setNext(head1.next()) ;
		list1 = list1.next() ;
		MyLinkedList list2 = new MyLinkedList() ;
		list2.setNext(head2.next()) ;
		list2 = list2.next() ;
		
		head3 = new MyLinkedList() ;
		MyLinkedList curr = null , prev = head3 ;
		int sum=0 , pCarry=0 , tCarry=0 ;
		
		while(true)
		{
			sum = (list1.key()+list2.key() + pCarry) % 10 ;
			tCarry = (sum) / 10 ;
			System.out.println("Sum=" + sum + " Carry=" + tCarry) ;
			curr = new MyLinkedList(sum,null) ;
			
			prev.setNext(curr) ;
			prev = curr ;
			pCarry = tCarry ;
			tCarry = 0 ;
			
			if(list1.next()==null && list2.next()==null)
				break ;
			
			list1 = list1.next() ;
			list2 = list2.next() ;
		}
		
		if(tCarry != 0)
		{
			curr = new MyLinkedList(tCarry , null) ;
			prev.setNext(curr) ;
		}
	}
}
