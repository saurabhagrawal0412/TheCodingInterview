package chapter3;

public class MyStack_List_Test {

	public static void main(String[] args) {
		
		MyStack_List stack = new MyStack_List() ;
		
		try {
			stack.push(4) ;
			stack.push(7) ;
			stack.pop() ;
			System.out.println(stack.peek()) ;
			System.out.println(stack.isEmpty()) ;
			stack.pop() ;
			stack.peek() ;
		}
		catch (EmptyStackException_List ese) {
			ese.printStackTrace() ;
		}
	}

}
