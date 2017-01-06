package chapter17;

public class IllegalInputException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Illegal input" ;
	}
}
