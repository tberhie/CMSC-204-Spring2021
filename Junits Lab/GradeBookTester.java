/**
 * @author tsega
 * 
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

      private GradeBook Obj1 , Obj2;
      
      @Before
      public void setUp() {
    	  
    	  // Object 1 and 2 initiated with 7 and 4      	  
            Obj1 = new GradeBook(7);
            Obj2 = new GradeBook(4);
            
            Obj1.addScore(46.0);
            Obj1.addScore(97.0);
            Obj1.addScore(87.0);
            Obj1.addScore(93);
            Obj1.addScore(81.0);
            Obj1.addScore(97.0);
            Obj1.addScore(10.0);
            
            Obj2.addScore(19.0);
            Obj2.addScore(98.0);
            Obj2.addScore(100.0);
            Obj2.addScore(69.0);
      } 

      @After
      public void tearDown() {
           Obj1 = null;
           Obj2 = null;
      }

      @Test
      public void addScoreTest() {
    	  assertEquals(false, (Obj1.toString()).equals("46.0 97.0 87.0 93.0 81.0 97.0 10.0"));
          assertEquals(false, (Obj2.toString()).equals("19.0 98.0 100.0 69.0"));
          assertEquals(7, Obj1.getScoreSize(), 0.001);
          assertEquals(4, Obj2.getScoreSize(), 0.001);
      }

      @Test
      public void testSum() {
    	// Compare sum and expected sum scores
    	  assertEquals(511.0, Obj1.sum(), 0.0001);  
          assertEquals(286.0, Obj2.sum(), 0.0001);
      }

      @Test
      public void testMinimum() {
    	// Compare minimum and expected minimum scores
    	  assertEquals(10.0, Obj1.minimum(), 0.001); 
          assertEquals(19.0, Obj2.minimum(), 0.001);
      }

      @Test
      public void testFinalScore() {
    	// Compare finalScore and expected finalScore
    	  assertEquals(501.0, Obj1.finalScore(), 0.0001); 
          assertEquals(267.0, Obj2.finalScore(), 0.0001);
      }
}