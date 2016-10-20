package chapter2;

public class LoopDetection
{
	MyLinkedList head ;
	public static void main(String[] args) throws InterruptedException
	{
		LoopDetection obj = new LoopDetection() ;
		obj.fillLinkedList() ;
		obj.printLinkedList() ;
		MyLinkedList looper = obj.findLoop() ;
		if(looper == null)
			System.out.println("No loops detected") ;
		else
			System.out.println("Loop detected at " + looper.key()) ;
	}
	
	private void fillLinkedList()
	{
		MyLinkedList node6 = new MyLinkedList(6,null) ;
		MyLinkedList node5 = new MyLinkedList(5,node6) ;
		MyLinkedList node4 = new MyLinkedList(4,node5) ;
		MyLinkedList node3 = new MyLinkedList(3,node4) ;
		MyLinkedList node2 = new MyLinkedList(2,node3) ;
		MyLinkedList node1 = new MyLinkedList(1,node2) ;
		head = new MyLinkedList(0,node1) ;
		//node6.setNext(node3) ;
	}

	private void printLinkedList()
	{
		MyLinkedList temp = head ;
		
		for(int i=1 ; i<=30 && temp.next()!=null ; i++)
		{
			temp = temp.next() ;
			System.out.println(temp.key()) ;
		}
	}
	
	private MyLinkedList findLoop() throws InterruptedException
	{
		MyLinkedList looper = null ;
		MyLinkedList slow = head.next() ;
		MyLinkedList fast = slow.next() ;
		boolean isLoop = false ;
		
		while(true)
		{
			Thread.sleep(200) ;
			isLoop = checkEquality(fast, slow) ;
			System.out.println("isloop = " + isLoop) ;
			if(!isLoop)
			{
				if(fast.next() != null)
				{
					fast = fast.next() ;
					isLoop = checkEquality(fast, slow) ;
				}
			}
			if(isLoop)
			{
				looper = fast ;
				break ;
			}
			else
			{
				if(fast.next() != null)
				{
					fast = fast.next() ;
					slow = slow.next() ;
				}
				else
					break ;
			}
		}
		return looper ;
	}
	
	private boolean checkEquality(MyLinkedList node1 , MyLinkedList node2)
	{
		if(node1==node2)
			return true ;
		else
			return false ;
	}
	
}
