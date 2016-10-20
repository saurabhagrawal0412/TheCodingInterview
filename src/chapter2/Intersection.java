package chapter2;

import java.util.Random;

public class Intersection
{

	private MyLinkedList head1 , head2 ;
	private int length1 = 0 , length2 = 0 ;
	
	public static void main(String[] args)
	{
		Intersection obj = new Intersection() ;
		obj.fillLinkedLists() ;
		obj.printLinkedLists(obj.head1) ;
		obj.printLinkedLists(obj.head2) ;
		boolean isIntersect = obj.isIntersection() ;
		
		if(isIntersect)
		{
			obj.findIntersection() ;
		}
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
		
		MyLinkedList mixed = new MyLinkedList(6,null) ;
		MyLinkedList prev = mixed , curr ;
		for(int i=7 ; i<=10 ; i++)
		{
			curr = new MyLinkedList(i , null) ;
			prev.setNext(curr) ;
			prev = curr ;
		}
		current1.setNext(mixed) ;
		current2.setNext(mixed) ;
		
		MyLinkedList t2 = head1 ;
		for(int i=-2 ; i<=0 ; i++)
		{
			
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
	
	private boolean isIntersection()
	{
		MyLinkedList list1 = head1 , list2 = head2 ;
		while(list1.next() != null)
		{
			length1++ ;
			list1 = list1.next() ;
		}
		while(list2.next() != null)
		{
			length2++ ;
			list2 = list2.next() ;
		}
		
		if(list1 == list2)
			return true ;
		else
			return true ;
	}
	
	private void findIntersection()
	{
		MyLinkedList list1 = head1.next() , list2 = head2.next() ;
		if(length1 > length2)
			removeElements(list1 , length1-length2) ;
		else if((length1 < length2))
			removeElements(list2 , length2-length1) ;
		
		while(list1!=null && list2!=null)
		{
			
		}
		
		System.out.println("list1.key() = " + list1.key()) ;
		System.out.println("list2.key() = " + list2.key()) ;
	}

	private void removeElements(MyLinkedList head, int offset)
	{
		while(offset > 0)
		{
			head = head.next() ;
			offset-- ;
		}
	}

}
