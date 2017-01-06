package chapter17;

public class PreprocessingNotPerformedException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Preprocessing not performed" ;
	}
}
