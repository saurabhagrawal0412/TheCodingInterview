package chapter2;

public class ReturnKthToLast
{
	
	public static void main(String[] args)
	{
		ReturnKthToLast obj = new ReturnKthToLast() ;
		MyLinkedList head = obj.getList() ;
		int k = 19 ;
		int kthFromLast = obj.findKthToLast(head , k) ;
		System.out.println("Kth element from last = " + kthFromLast) ;
	}
	
	private MyLinkedList getList()
	{
		MyLinkedList head=null , current=null , prev=null ;
		
		for(int i=1 ; i<=21 ; i++)
		{
			if(head == null)
			{
				head = new MyLinkedList() ;
				current = new MyLinkedList(i,null) ;
				head.setNext(current) ;
				prev = current ;
				
			}
			else
			{
				current = new MyLinkedList(i,null) ;
				prev.setNext(current) ;
				prev = current ;
			}
		}
		return head ;
	}
	
	private int findKthToLast(MyLinkedList head , int k)
	{
		int kthFromLast = 0 ;
		int sCount=0 , fCount=0 , index=-1 ;
		MyLinkedList slow=head , fast=head ;
		while(true)
		{
			if(slow.next() != null)
			{
				slow = slow.next() ;
				sCount++ ;
			}
			if(fast.next() != null)
			{
				fast = fast.next() ;
				fCount++ ;
				if(fast.next() != null)
				{
					fast = fast.next() ;
					fCount++ ;
				}
			}
			else if(fast.next() == null)
			{
				index = fCount - k ;
				
				if(index == sCount)
				{
					kthFromLast = slow.key() ;
					break ;
				}
				else if(index > sCount)
				{
					while(index-sCount > 0)
					{
						slow = slow.next() ;
						sCount++ ;
					}
					kthFromLast = slow.key() ;
					break ;
				}
				else if(index < sCount)
				{
					while(index > 0)
					{
						head = head.next() ;
						index-- ;
					}
					kthFromLast = head.key() ;
					break ;
					
				}
				
			}
			
			System.out.println("slow=" + slow.key()) ;
			System.out.println("fast=" + fast.key()) ;
		}
		
		return kthFromLast ;
	}

}


