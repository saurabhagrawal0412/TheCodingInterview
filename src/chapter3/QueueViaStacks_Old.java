package chapter3;

public class QueueViaStacks_Old
{
	int[] input = new int[10] ;
	int top1=0 , top2=0 ;
	
	public static void main(String[] args)
	{
		QueueViaStacks_Old obj = new QueueViaStacks_Old() ;
		
		for(int i=4 ; i<=9 ; i++)
			obj.add(i) ;
		for(int i=1 ; i<=3 ; i++)
			obj.delete() ;
		int top = obj.peek() ;
		System.out.println("top = " + top) ;
	}

	private void add(int number)
	{
		if((top1 == top2-1) || (top1==9 && top2==0))
		{
			System.out.println("Queue is full") ;
			return ;
		}
		
		if(top1==9 && top2!=0)
			top1 = 0 ;
		else if(top1 != 9)
			top1++ ;
		input[top1] = number ;
	}

	private void delete()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty") ;
			return ;
		}
		System.out.println("Deleting " + input[top2]) ;
		top2++ ;
		
	}
	
	private boolean isEmpty()
	{
		if(top1 == top2)
			return true ;
		else
			return false ;
	}
	
	private int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty") ;
			return -1 ;
		}
		return(input[top1]) ;
	}
}
