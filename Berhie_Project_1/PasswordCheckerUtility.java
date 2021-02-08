
/**
 * @author Tsega
 * PasswordUtilityChecker class implements the methods LengthException,
                                      NoDigitException,
                                      NoUpperAlphaException,
                                      NoLowerAlphaException,
                                      InvalidSequenceException and 
                                      NOSpecialSymbolException
                                      WeakPasswordException 
 */


import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordCheckerUtility {
    
    public PasswordCheckerUtility() {}
      
    /**
     * Checks if password is valid but between 6 -9 characters
     * @throws weak password exception
     */
    
    public static boolean isWeakPassword( java.lang.String password) {
    
        boolean checkIfWeak = false; 
        
        if(password.length() >= 6 && password.length() <= 9)
        	checkIfWeak = true;
        
        return checkIfWeak; 
        
    }
    
    /**
     * Return true if valid password 
     * (follows all rules from above), returns false if an invalid password
     * @throws NoSpecialSymbolException 
     */
    
    public static boolean isValidPassword(java.lang.String password)
                               throws LengthException,
                                      NoDigitException,
                                      NoUpperAlphaException,
                                      NoLowerAlphaException,
                                      InvalidSequenceException, NoSpecialSymbolException {

        
        boolean Isvalid; 
        // LengthException
        if (passwordString.length() < 6)
            throw new LengthException("Password must contain at least 6 characters");
        // NoUpperAlphaException
        else if (toMatch("(?s).*[A-Z].*", password) == false)
            throw new NoUpperAlphaException("Must contain at least one upper case letter");
        // NoLowerAlphaException
        else if (toMatch(".*[a-z].*", password) == false)
            throw new NoLowerAlphaException("Password must contain at least one lower case letter");
        // NoDigitException
        else if (toMatch("(.)*(\\d)(.)*", password) == false)
            throw new NoDigitException("Password must contain at least one digit");
        // NoSpecialSymbolException
        else if (toMatch("(.*[@#$%^&+=!].*)",password)==false)
       	throw new NoSpecialSymbolException ("Password must contain at least 1 special character");
        // InvalidSequenceException
        else if (uniqueCharacters(password) == true)
            throw new InvalidSequenceException("Cannot contain more than 2 of the same characters in a sequence");
        
        else 
            Isvalid = true; 
        
        return Isvalid; 
         
    }
       
    
    /**
     * Reads a file of passwords and the passwords that failed 
     * the check will be added to an invalidPasswords with the reason
     * @return an ArrayList (of Strings) of invalid passwords 
     */
    
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {         
        
        ArrayList<String> checkPswd = new ArrayList<>(); 
        boolean valid = false; 
        
        for(int i = 0; i < passwords.size(); i++) {
        	// thrown if length is less than 6 characters 
            if(passwords.get(i).length() < 6)
            	checkPswd.add(passwords.get(i) + " " + "Password must contain at least 6 characters"); 
            // thrown if no uppercase alphabetic 
            else if(toMatch("(?s).*[A-Z].*", passwords.get(i)) == false)
            	checkPswd.add(passwords.get(i) + " " + "Password must contain at least one uppercase letter");
            // thrown if no lowercase alphabetic 
            else if(toMatch(".*[a-z].*", passwords.get(i)) == false)
            	checkPswd.add(passwords.get(i) + " " + "Password must contain at least one lowercase letter");
            // thrown if no digit
            else if(toMatch("(.)*(\\d)(.)*", passwords.get(i)) == false)
            	checkPswd.add(passwords.get(i) + " " + "Password must contain at least one digit");
            // thrown if does not meet SpecialCharacter requirement 
            else if(toMatch("(.*[@#$%^&+=!].*)", passwords.get(i)) == false)
            	checkPswd.add(passwords.get(i) + " " + "Password must contain at least 1 special character");
            // thrown if more than 2 of same character. 
            else if(uniqueCharacters(passwords.get(i)) == true)
            	checkPswd.add(passwords.get(i) + " " + "Cannot contain more than 2 of the same characters in a sequence");
        }
    
        return checkPswd; 
        
    }
        
    /**
     * uniqueCharacters method checks if
     *  a given password has more than 2
     * instances of any one character in a sequence
     * 
     */
    
    private static boolean uniqueCharacters(String password) { 
        
        char[] toArray;
        boolean Sequence = false; 
        
        toArray = password.toCharArray();
       
        for (int i = 0; i < toArray.length; i++) {
    
            if(i > (toArray.length - 3))
                break;
            
            else if (toArray[i] == toArray[i + 1]
                    && toArray[i] == toArray[i + 2])
                Sequence = true;           
        }

        return Sequence; 
        // return sequence requirment
    }
    
    /**
     * 
     * toMatched is a method that is given example on the assignment sheet that 
     * indicates whether a given String matches a 
     * particular regex
     * @return a boolean value indicating whether our password matches regex
     * 
     */
    
    private static boolean toMatch(String regex, String str) {
             
        
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

		Matcher matcher = pattern.matcher(str));

		return (!matcher.matches());
          
    }   
    
   
   
}
