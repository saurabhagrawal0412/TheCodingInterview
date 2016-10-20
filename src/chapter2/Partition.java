package chapter2;

import java.util.Random;

public class Partition
{
	MyLinkedList head=null ;
	public static void main(String[] args)
	{
		Partition obj = new Partition() ;
		MyLinkedList head = obj.fillLinkedList() ;
		obj.printLinkedList() ;
		obj.partition(head) ;
		System.out.println("Finally") ;
		obj.printLinkedList() ;
	}

	private MyLinkedList fillLinkedList()
	{
		MyLinkedList current=null , prev=null ;
		Random rand = new Random() ;
		int temp ;
		for(int i=1 ; i<=21 ; i++)
		{
			temp = rand.nextInt(9) + 1 ;
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
		
		while(current.next() != null)
		{
			System.out.print(current.key() + " ") ;
			current = current.next() ;
		}
		System.out.println() ;
	}
	
	private void partition(MyLinkedList head)
	{
		MyLinkedList pivot = head.next() ;
		MyLinkedList smaller = pivot.next() ;
		MyLinkedList greater = pivot.next() ;
		System.out.println("pivot = " + pivot.key()) ;
		
		int temp ;
		while(smaller.next() != null && greater.next() != null)
		{
			System.out.println("while runs again: smaller=" + smaller.key()) ;
			printLinkedList() ;
			while(smaller.next() != null && smaller.key() <= pivot.key())
			{
				System.out.println("Smaller = " + smaller.key()) ;
				smaller = smaller.next() ;
			}
			if(smaller.next() != null)
				greater = smaller.next() ;
			
			while(greater.next() != null && greater.key() > pivot.key())
			{
				System.out.println("Greater = " + greater.key()) ;
				greater = greater.next() ;
			}
			
			if( ( smaller.key()>pivot.key() ) && ( greater.key()<=pivot.key() ) )
			{
				System.out.println("Exchanging " + smaller.key() + " with " + greater.key()) ;
				temp = smaller.key() ;
				smaller.setKey(greater.key()) ;
				greater.setKey(temp) ;
				
				if(smaller.next() != null && greater.next() != null)
				{
					smaller = smaller.next() ;
					greater = greater.next() ;
				}
				continue ;
			}
		}
		/*System.out.println("Swapping") ;
		temp = pivot.getKey() ;
		pivot.setKey(smaller.getKey()) ;
		smaller.setKey(temp) ;*/
		
		//Shifting pivot after smaller
		System.out.println("Before swapping: smaller = " + smaller.key()) ;
		printLinkedList() ;
		head.setNext(pivot.next()) ;
		MyLinkedList t1 = smaller.next() ;
		smaller.setNext(pivot) ;
		pivot.setNext(t1) ;
		temp = smaller.key() ;
		smaller.setKey(pivot.key()) ;
		pivot.setKey(temp) ;
		System.out.println("After swapping") ;
		printLinkedList() ;
	}
}
