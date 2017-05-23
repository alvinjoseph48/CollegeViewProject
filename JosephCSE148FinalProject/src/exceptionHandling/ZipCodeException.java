package exceptionHandling;

public class ZipCodeException extends Exception {
	public ZipCodeException() {
		super("\nZip Code must be 5 digits!");
	}
	public ZipCodeException(String message) {
		super(message);
	}
}
