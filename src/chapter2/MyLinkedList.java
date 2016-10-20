package chapter2;

public class MyLinkedList
{
	private int key ;
	private MyLinkedList next ;
	
	public MyLinkedList()
	{}
	public MyLinkedList(int key , MyLinkedList next)
	{
		this.key = key ;
		this.next = next ;
	}
	
	public int key()
	{
		return key ;
	}
	public void setKey(int key)
	{
		this.key = key ;
	}
	public void setNext(MyLinkedList next)
	{
		this.next = next ;
	}
	
	public MyLinkedList next()
	{
		return this.next ;
	}
	
}