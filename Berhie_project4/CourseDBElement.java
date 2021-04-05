
/**
 * This program creates a database of courses
 * It will read from a file of courses,
 * or allow the user to add a course
 * @author Tsega
 *
 * */

/**
 * CourseDBElement implements Comparable
 * @param <T>
 * */
public class CourseDBElement<T> implements Comparable <T> {
    private String id = "";
    private int	crn = 0;
    private int numOfCredits = 0;
    private String roomNumber = "";
    private String instructorName = "";

    /**
     * A constructor with the five attributes of CDE
     * @param id
     * @param crn
     * @param credits
     * @param room
     * @param instructor
     */
    public CourseDBElement(String id, int crn, int credits, String room, String instructor) {
        this.id = id;
        this.crn = crn;
        this.numOfCredits = credits;
        this.roomNumber = room;
        this.instructorName = instructor;
    }

    /**
     * @return id String of the course
     */
    public String getCourseID() {
        return id;
    }
    /**
     * @return id int of the course
     */
    public int getCRN() {
        return crn;
    }
    /**
     * @return credits for the course
     */
    public int getCredits() {
        return numOfCredits;
    }

    /**
     * @return room of the course
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return instructor of the course
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * Sets the crn value
     * @param crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }
    
    /**
     * Method that compares two elements based on the crn
     */
    @Override
    public int compareTo(CourseDBElement element) {

        return this.crn - element.crn;
    }
    /**
     * a constructor class
     */
    public CourseDBElement() {

    }

     /**
      *  ToString method to convert
      */
    public String toString() {
        String course = "\nCourse:" + id + " CRN:" + crn + " Credits:" +
                                numOfCredits + " Instructor:" + instructorName + " Room:"+roomNumber;
        return course;
    }
    /**
     * compares two elements based on their representation
     */

    @Override
    public boolean equals(Object element) {

        if (this.toString().equals(element.toString())){
            return true;
        } else return false;
    }

    /**
     * This method casts the crn as a string and returns the hash code
     */
    public int hashCode() {
        return (""+crn).hashCode();
    }
}