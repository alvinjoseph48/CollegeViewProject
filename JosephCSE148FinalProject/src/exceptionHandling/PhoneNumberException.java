package exceptionHandling;

public class PhoneNumberException extends Exception  {
	public PhoneNumberException() {
		super("\nPhone Number must be 10 digits!");
	}
	
	public PhoneNumberException(String message) {
		super(message);
	}
}
