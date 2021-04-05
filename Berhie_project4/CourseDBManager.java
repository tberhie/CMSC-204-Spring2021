import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Implements the CourseDBManagerInterface 
 *  The data manager allows the user to read the courses
 *  from a file or to enter the data by hand
 *  @author Tsega
 * */


public class CourseDBManager implements CourseDBManagerInterface
{
	CourseDBStructure CD = new CourseDBStructure(20);
    CourseDBManager()
    {

    }

    @Override
    public void add(String ID, int CRN, int credits, String roomNum, String instructor)
    {
        CD.add(new CourseDBElement(ID, CRN, credits, roomNum, instructor));

    }
    @Override
    public CourseDBElement get(int crn)
    {
        try {
            return CD.get(crn);
        }
        catch(Exception e)
        {
            return null;
        }
    }
    @Override
    public void readFile(File file) throws FileNotFoundException {
    	
    	Scanner keyword = new Scanner(file); 
    	
        String Id= "";
        String Crn = "";
        String Credit = "";
        String Instructor = "";
        String Room = "";
        
        int crn = 0;
        int noOfCredits = 0;

        
        while (keyword.hasNext()) {
            if (keyword.hasNext()) {
                Id = keyword.next();
            }

            if (keyword.hasNext()) {
                Crn = keyword.next();
            }
            crn = Integer.parseInt(Crn);

            if (keyword.hasNext()) {
                Credit = keyword.next();
            }
            noOfCredits = Integer.parseInt(Credit);

            if (keyword.hasNext()) {
                Room = keyword.next();
            }
            if (keyword.hasNext()) {
                Instructor = keyword.nextLine();
            }
            add(Id, crn, noOfCredits, Room, Instructor);
        }
        keyword.close();
    }

    @Override
    public ArrayList<String> showAll()
    {
        ArrayList<String> chain = new ArrayList<>();
        for(int i = 0; i < CD.hashTable.length ; i++) {
            if (CD.hashTable[i] != null) {
                LinkedList<CourseDBElement> list = CD.hashTable[i];
                for (CourseDBElement CDE : list) {
                    chain.add(CDE.toString());

                }
            }
        }
        Collections.sort(chain);

        return chain;
    }
}