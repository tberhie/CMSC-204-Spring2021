

/**
 * The interface comparable imposes a total ordering on the objects of each 
 * class that implements it. 
 * @param element a CourseDBElement
 * @return a negative integer if x.compareTo(y) < 0, 
 *         zero if x.compareTo(y) == 0,
 * 	   and a positive integer if x.compareTo(y) > 0.
 */

public interface Comparable <T> {

    int compareTo(CourseDBElement element);

}