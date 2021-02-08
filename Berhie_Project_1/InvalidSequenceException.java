
public class InvalidSequenceException extends Exception {
	
public InvalidSequenceException (String message) {
        message = "The password cannot contain more than two of the same character in sequence";
        super(message);
        
    }

}
