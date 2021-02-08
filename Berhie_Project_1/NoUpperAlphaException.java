

public class NoUpperAlphaException extends Exception {

	public NoUpperAlphaException(String message) {
		message = "The password must contain at least one uppercase alphabetic character";
		super(message);
	}
	
}
