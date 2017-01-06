package chapter17;


public class IllegalInputSizeException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Please enter an array with size >= 1" ;
	}
}
