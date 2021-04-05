import java.io.IOException;
import java.util.LinkedList;

/**
 * CourseDBStructure Implements the CourseDBStructureInterface
 * @author Tsega
 **/


public class CourseDBStructure implements CourseDBStructureInterface {
    
    protected LinkedList<CourseDBElement>[] hashTable;
    protected int tableSize;

    
    @Override
    public void add(CourseDBElement element) {
        CourseDBElement CDE = new CourseDBElement(element.getCourseID(), element.getCRN(), element.getCredits(),
                                    element.getRoomNumber(), element.getInstructorName());
        int hash = Math.abs(element.hashCode()) % tableSize;

        LinkedList<CourseDBElement> List = hashTable[hash];
        if (List==null)
        {
            hashTable[hash] = new LinkedList<>();
        }
        hashTable[hash].add(CDE);
    }
   /**
    * @param crn the CDE to be added
    * @throws IOException
    */
    @Override
    public CourseDBElement get(int CRN) throws IOException {
        for (int i = 0; i < tableSize; i++ ) {
            if (hashTable[i] != null) {
                for (CourseDBElement CDE : hashTable[i]) {
                    if (CDE.getCRN() == CRN) {
                        return CDE;
                    }
                }
            }
        }
        throw new IOException("Course with a CRN number - " + CRN + " is not found");
    }
    /**
     * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
     */
    @Override
    public int getTableSize() {
        return tableSize;
    }
    
    public CourseDBStructure(String testing, int size) {
        tableSize = size;
        hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
    }

    public CourseDBStructure(int size) {
        tableSize = size;
        hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
    }
}
