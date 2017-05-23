package exceptionHandling;

public class GpaTooBigException extends Exception {
	public GpaTooBigException() {
		super("\nInvalid GPA !:0.0 - 4.0");
	}
	
}
