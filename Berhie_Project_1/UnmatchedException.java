
public class UnmatchedException extends Exception{
	
	public UnmatchedException(String message) {
			message = "The passwords do not match";
			super(message);
		}

}
