
public class NoDigitException extends Exception {
	
public NoDigitException(String message) {
		message = "The password must contain at least one digit";
		super(message);
	}

}
