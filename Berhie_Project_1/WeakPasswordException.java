
public class WeakPasswordException extends Exception{
	public WeakPasswordException(String message) {
		message = " The password is OK but weak - it contains fewer than 10 characters";
			super(message);
		}
	}
}
