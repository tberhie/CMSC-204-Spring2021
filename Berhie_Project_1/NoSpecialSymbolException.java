
public class NoSpecialSymbolException extends Exception{
	
public NoSpecialSymbolException(String message) {
		message = "The password must contain at least one special character";
		super(message);
	}
	

}
