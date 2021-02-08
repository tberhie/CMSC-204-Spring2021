
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for STUDENT_TEST
 * @author Tsega
 *
 */
public class PasswordCheckerSTUDENT_Test {

	@Before
	public void setUp() throws Exception {
		String[] trial = {"323232", "IamLegend", "DramaQueen00", "$Dollarsign", 
				     "Tsegazeab", "Chrysler00&", "check00@"};
		ArrayList <String> passwords = new ArrayLisr<String>();
		passwords.addAll(Arrays.asList(trial));
	
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ABCcheck0"));
			PasswordCheckerUtility.isValidPassword("aaccbb");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Another exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("&&ooAAcheck"));
			PasswordCheckerUtility.isValidPassword("&&oocheck");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Another exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("&&ooAAcheck"));
			PasswordCheckerUtility.isValidPassword("&&AA");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Another exception besides lengthException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Password$$"));
			boolean weakPswd = PasswordCheckerUtility.isWeakPassword("Password");
			assertTrue(weakPswd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("&&ooAAcheck"));
			PasswordCheckerUtility.isValidPassword("&&ooAAAheck");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Another exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("&&ooAAcheck"));
			PasswordCheckerUtility.isValidPassword("&ooAAcheck");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Another exception besides lengthException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Hello1@23"));
			PasswordCheckerUtility.isValidPassword("Hello1@23");
			assertTrue("Didn't throw lengthException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threwed a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Another exception besides lengthException",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> checker = null;
		
		checker = PasswordCheckerUtility.getInvalidPasswords(checker);
		Scanner scan = new Scanner(checker.get(3)); 
		assertEquals(scan.next(), "34343434");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("passChecker"));
	}
	
}
