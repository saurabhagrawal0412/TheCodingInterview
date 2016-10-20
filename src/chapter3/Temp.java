package chapter3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/*public class Temp
{
	public static void main(String[] args)
	{
		int age = 120 ;
		if(age > 100)
		{
			try
			{
				throw new InvalidAgeException() ;
			}
			catch (InvalidAgeException iae)
			{
				System.out.println("Blah") ;
				iae.printStackTrace();
			}
		}
		System.out.println("Blah1") ;
		System.out.println("Blah2") ;
	}
}

class InvalidAgeException extends Exception
{
	public String getMessage()
	{
		return "Age should be lesser than 100" ;
	}
}*/

/*public class Temp
{
	public static void main(String[] args) {
		A a = new A() ;
		B b = new B() ;
		System.out.println(a.method1());
		System.out.println(b.method1());
		
		a = b ;
		System.out.println(a.method1());
	}
}

class A {
	public int method1() {
		return 0 ;
	}
}

class B extends A {
	public int method1() {
		return stMethod1() ;
	}
	
	public static int stMethod1() {
		return 1 ;
	}
}*/

/*public class Temp {
	public static void main(String[] args) {
		Test test = null ;
		
		System.out.println(test.a==null) ;
		System.out.println(test.b==null) ;
	}
}

class Test {
	public static ArrayList<Integer> a = new ArrayList<Integer>() ;
	public static ArrayList<Integer> b ;
	
	static {
		a = new ArrayList<Integer>() ;
	}
	
	public Test() {
		b = new ArrayList<Integer>() ;
	}
}*/

/*public class Temp {
	public static void main(String[] args) throws Exception {
		A a = new A() ;
		B b = new B() ;
		C c = new C() ;
		a.viewI() ;
		b.viewI() ;
		c.viewI() ;
	}
}

class A {
	protected int i ;
	A() {
		i = 5 ;
	}
	public void viewI() throws Exception {
		System.out.println(i) ;
	}
}

class B extends A {
	B() {
		super.i = 6 ;
	}
	public void viewI() throws MyTempException {
		System.out.println(i+1) ;
	}
}

class C extends B {
	C() {
		super.i = 7 ;
	}
	public void viewI() {
		System.out.println(i+2) ;
	}
}

@SuppressWarnings("serial")
class MyTempException extends Exception {
	public String getMessage() {
		return "My temp exception" ;
	}
}*/

/*public class Temp {
	AnimalShelter shelter ;
	public static void main(String[] args) {
		Temp temp = new Temp() ;
		System.out.println(temp.shelter == null) ;
	}
}*/

/*public class Temp {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>() ;
		hm.put(0,"Hello") ;
		hm.put(1,"Hii") ;
		hm.put(2,"Gracias") ;
		
		for(int i : hm.keySet())
			System.out.println(hm.get(i) ) ;
	}
}*/

/*public class Temp {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>() ;
		list.add(1) ;
		list.add(2) ;
		list.add(3) ;
		list.add(4) ;
		
		System.out.println(list.get(0)) ;
	}
}*/

/*public class Temp {
	public static void main(String[] args) {
		double a=4.4 ;
		double b=5.5 ;
		
		System.out.println(a<=b);
	}
}*/

public class Temp {
	public static void main(String[] args) {
		double a=4.4 ;
		double b=5.5 ;
		
		System.out.println(a<=b);
		
		permutation("abc") ;
		
	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
