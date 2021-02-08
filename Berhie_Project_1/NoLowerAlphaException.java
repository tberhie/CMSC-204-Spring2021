

public class NoLowerAlphaException extends Exception {
	   public NoLowerAlphaException(String message) {
	       message = "The password must contain at least one lowercase alphabetic character";
	    super(message);

}
