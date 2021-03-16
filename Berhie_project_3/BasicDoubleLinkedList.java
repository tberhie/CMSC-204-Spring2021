
/**
 * This double linked list would rely on its head and tail
 * This class defines inner class node, inner class implementing the list iterator such as hasNext(), next(), hasPrevious(), and previous()
 * @author Tsega
 *
**/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	protected class Node {

		protected T data;
		protected Node next;
		protected Node prev;

		protected Node(T item, Node next, Node previous) {
			this.data = item;
			this.next = next;
			this.prev = previous;
		}
	}

	protected int size;
	protected Node head;
	protected Node tail;
	

	public BasicDoubleLinkedList() {

		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * returns the value of the instance variable we want to track
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds an element to the front of the list and reference to the current object
	 */

	public BasicDoubleLinkedList<T> addToFront(T data) {

		Node temp2 = new Node(data, head, null);
		if (head != null) {
			head.prev = temp2;
		}
		head = temp2;
		if (tail == null) {
			tail = temp2;
		}
		size++;
		return this;

	}

	/**
	 * reference the current object and add elements to the end of the list
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {

		Node temp1 = new Node(data, null, tail);
		if (tail != null) {
			tail.next = temp1;
		}
		tail = temp1;
		if (head == null) {
			head = temp1;
		}
		size++;
		return this;
	}

	/**
	 * Returns but does not remove the first element from the list. If there are no
	 * elements the method returns null
	 * 
	 * @return data element or null
	 */
	public T getFirst() {
		return head.data;

	}

	/**
	 * Returns but does not remove the first element from the list. If there are no
	 * elements the method returns null
	 * 
	 * @return data element or null
	 */
	public T getLast() {
		return tail.data;
	}

	/**
	 * This method must be implemented using an inner class that implements
	 * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and
	 * previous().
	 **/
	public ListIterator<T> iterator() {
		return new iter();
	}
	
	public class iter implements ListIterator<T> {
		private Node curr;
		private Node last;

		public iter() {
			curr = head;
			last = null;
		}

		public T next() {
			if (curr != null) {
				T returnData = curr.data;
				last = curr;
				curr = curr.next;
				if (curr != null) {
					curr.prev = last;
				}
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		public boolean hasNext() {
			return curr != null;
		}

		public T previous() {
			if (last != null) {
				curr = last;
				last = curr.prev;
				T returnData = curr.data;
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		public boolean hasPrevious() {
			return last != null;
		}

		public void set(T data) {
			curr.data = data;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();

		}
	}

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param comparator,targetData
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node prev = null, curr = head;

		while (curr != null) {
			if (comparator.compare(curr.data, targetData) == 0) {
				if (curr == head) {
					head = head.next;
					curr = head;

				} else if (curr == tail) {
					curr = null;
					tail = prev;
					prev.next = null;

				} else {
					prev.next = curr.next;
					curr = curr.next;
				}
				size--;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return this;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null
	 * 
	 * @return a data element or null
	 *
	 */
	public T retrieveFirstElement() {
		if (size == 0) {
			throw new NoSuchElementException("The Linked list is empty");
		}
		Node temp = head;
		head = head.next;
		head.prev = null;
		size--;
		return temp.data;
	}

	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null. Do not implement implement this method using
	 * iterators.
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement() {

		if (head == null) {
			throw new NoSuchElementException("Linked list is empty");

		}
		Node currNode = head;
		Node prevNode = null;

		while (currNode != null) {
			if (currNode.equals(tail)) {
				tail = prevNode;
				break;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		size--;
		return currNode.data;
	}

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return an arrylist of items in the list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> temp = new ArrayList<T>();
		ListIterator<T> iterr = new iter();

		while (iterr.hasNext()) {
			temp.add(iterr.next());
		}
		return temp;
	}

}