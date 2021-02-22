import java.util.ArrayList;

/** notationStack implementation 
 * 
 * @author Tsegazeab Berhie
 *
 */

public class NotationStack<T> implements StackInterface{
private ArrayList<T> stack;
private int full;

	public NotationStack(){
		full = 100;
		stack = new ArrayList<T>();
	}

	public NotationStack(int size){
		full = size;
		stack = new ArrayList<T>();
	}

	public NotationStack(ArrayList<T> z){
		full = 200;
		stack= new ArrayList<T>();

		for(int i = z.size()-1; i>=0;i--) {
			stack.add(z.get(i));
		}
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(stack.size()==0)
			return true;
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(stack.size()==full)
			return true;
		return false;
	}

	/**
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException {
		if(stack.size()==0)
			throw new StackUnderflowException("The Stack is full");
		T toReturn = stack.remove(0);
		return toReturn;
	}

	/**
	 * @return the element at the top of the Stack
	 */
	public T top() throws StackUnderflowException {
		if(stack.size()==0)
			throw new StackUnderflowException("The stack is underflow");
		return stack.get(0);
	}

	/**
	 * @return the number of elements in the Stack
	 */
	public int size() {

		return stack.size();
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(Object e) throws StackOverflowException {
		if(stack.size()==full)
			throw new StackOverflowException("The Stack is full");
		stack.add(0, (T) e);
		return true;
	}

	/**
	 * @return a string which represent a Stack 
	 */
	public String toString() {
		String toReturn = "";
		for(int i = stack.size()-1; i>=0;i--) 
			toReturn+=stack.get(i)+"";

		return toReturn;
	}


	/**
	 * 
	 * @return string representation of the Stack with the delimiter distance
	 */
	public String toString(String delimiter) {
		String toReturn = "";
		for(int i = stack.size()-1; i>=0;i--) 
			toReturn+=stack.get(i)+""+delimiter;
		toReturn = toReturn.substring(0,toReturn.length()-1);
		return toReturn;


	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		
	}

	
}