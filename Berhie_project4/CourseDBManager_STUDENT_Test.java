import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataManager = new CourseDBManager();

    @Before
    public void setUp() throws Exception {
        dataManager = new CourseDBManager();
    }

    public void tearDown() throws Exception {
        dataManager = null;
    }

    @Test
    public void testAddToDB() {
        try {
            dataManager.add("CMSC204",20001,4,"CM10","Tsega Berhie");
        }
        catch(Exception e) {
            fail("It does not have an Exception");
        }
    }

    @Test
    public void testShowAll() {
        dataManager.add("CMSC140",20004,4,"C45","Micheal PObs");
        dataManager.add("CMSC203",20001,4,"C45","Rahel Minale");
        dataManager.add("CMSC204",20007,4,"C45","Mahlet Kassa");
        ArrayList<String> list = dataManager.showAll();

     // assertEquals(list.get(0),"\nCourse:CMSC203 CRN:20001 Credits:4 Instructor:Rahel Minale Room:C45");
     // assertEquals(list.get(1),"\nCourse:CMSC140 CRN:20004 Credits:4 Instructor:Micheal PObs Room:C45");
        assertEquals(list.get(2),"\nCourse:CMSC204 CRN:20007 Credits:4 Instructor:Mahlet Kassa Room:C45");
    }

    @Test
    public void testRead() {
        try {
            File inputFile = new File("StudentTest.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC140 20004 4 C45 Micheal PObs");
            inFile.println("CMSC203 20004 4 C45 Rahel Minale");

            inFile.close();
            dataManager.readFile(inputFile);
            System.out.print(dataManager.showAll());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}

