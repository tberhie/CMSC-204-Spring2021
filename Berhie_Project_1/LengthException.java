
public class LengthException extends Exception {


public LengthException(String message) {
         message = "The password must be at least 6 characters long";
		super(message);
	}
}