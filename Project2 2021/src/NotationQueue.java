import java.util.ArrayList;
/** notationQueue implementation 
 *
 * @author Tsegazeab Berhie
 *
 */
public class NotationQueue<T> implements QueueInterface {

	
	private ArrayList<T>myQueue ;
	private int full=200;
	
/**
 * Determines if Stack is empty
 * @return true if Stack is empty, false if not
 * 
 */
	@Override
	public boolean isEmpty() {
		if (myQueue.size()==0) 
			return true;
		else 
			return false; 
	}
/**
* Determines if Stack is full
* @return true if Stack is full, false if not
*/
	@Override
	public boolean isFull() {
		if(myQueue.size()==full)
			return true;
		else 
			return false;
	}
/**
 * @return object that is dequeued
 */
	@Override
	public Object dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) 
			throw new QueueUnderflowException("Flow");
		
		T result =myQueue.get(0);
		myQueue.remove(0);
		return result;
	}
/**
 * Number of elements in the Stack
 * @return the number of elements in the Stack
 */
	@Override
	public int size() {
		int result=myQueue.size();
		return result;
	}
/**
 * adds to queue
 * @return true if enqueue is done successfully
 */
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (isFull()) 
			throw new QueueOverflowException("Flow");
		
		myQueue.add((T) e);
		return true;
		
		
	}
/**
  * @return String separated by delimiter of the queue
 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T ele:myQueue) {
			if(myQueue.indexOf(ele)==myQueue.size()-1)
				result+=ele;
			else
			result += ele + delimiter; // add elements separated by delimiter
			 
		}
		return result;
	}
	/**
	 *  @return String representation of queue
	 */
	@Override
	public String toString() {
		String result = "";
		for (T ele:myQueue) {
				result+=ele;
		}
		return result;
	}
	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * size Constructor
	 * @param size 
	 */
	public NotationQueue(int size){
		this.full=size;
	
		myQueue = new ArrayList<T>(size);
		
	}
	/**
	 * Default constructor
	 */
	public NotationQueue() {
		this(200);
	}
	
/**
 * Copies an ArrayList for queue
 * @param aList
 */
	public NotationQueue(ArrayList<T> list) {
		this.myQueue=(ArrayList<T>) list;
		
	}
	/** 
	 * @return true if array is empty, false if array is not empty
	 */
}
