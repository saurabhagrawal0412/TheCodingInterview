package chapter2 ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class Temp
{

	/*public static void main(String[] args)
	{
		MyLinkedList second = new MyLinkedList(2,null) ;
		MyLinkedList first = new MyLinkedList(1,second) ;
		MyLinkedList head = new MyLinkedList(0,first) ;
		
		head.setNext(second) ;
		second.setNext(first) ;
		first.setNext(null) ;
		MyLinkedList temp = new MyLinkedList(0,head.next()) ;
		while(temp.next() != null)
		{
			if(temp.next() != null)
				temp = temp.next() ;
			System.out.println(temp.key()) ;			
		}
	}*/
	
	/*public static void main(String[] args)
	{
		Stack<Integer> st = new Stack<Integer>() ;
		st.push(1) ;
		st.push(2) ;
		st.push(3) ;
		
		if(3 == st.lastElement())
			st.pop() ;
		
		System.out.println(st.lastElement()) ;
	}*/

	/*public static void main(String[] args)
	{
		HashSet<String> hashExample = new HashSet<String>() ;
		hashExample.add("aa") ;
		hashExample.add("bb") ;
		hashExample.add("cc") ;
		hashExample.add("aa") ;
		
		for(String t1 : hashExample)
			System.out.println(t1) ;
		
		if(hashExample.contains("aa"))
			System.out.println("Duplicate found") ;
		
		HashMap<Integer,String> myMap = new HashMap<Integer,String>() ;
		myMap.put(1,"a") ;
		myMap.put(2,"b") ;
		myMap.put(3,"c") ;
		myMap.put(1,"d") ;
		myMap.put(1,"e") ;
		
		for(int key: myMap.keySet())
		{
			String value = myMap.get(key) ;
			System.out.println("key=" + key + " value=" + value) ;
		}
		System.out.println("key=" + 5 + " value=" + myMap.get(5)) ;
		
		Hashtable<Boolean,String> myHashTable = new Hashtable<Boolean,String>() ;
		myHashTable.put(true , "true") ;
		myHashTable.put(false , "false") ;
		myHashTable.put(true , "false") ;
		
		System.out.println("My hash table") ;
		for(boolean key: myHashTable.keySet())
		{
			String value = myHashTable.get(key) ;
			System.out.println("key=" + key + " value=" + value) ;
		}
	}*/
	
	/*public static void main(String[] args)
	{
		//System.out.println(Math.pow(5, 2)) ;
		int n=9 ;
		System.out.printf("%d\n",n) ;
		
		MyLinkedList head = new MyLinkedList(1,null) ;
		MyLinkedList t1=head , t2=head ;
		
		System.out.println(t1 == t2) ;
	}*/
	
	public static void main(String[] args)
	{
		LinkedList<Character> c = new LinkedList<>() ;
		c.add('e') ;
		c.add('f') ;
		c.add('b') ;
		
		int y = c.indexOf('f') ;
		System.out.println(y);
	}
	
}