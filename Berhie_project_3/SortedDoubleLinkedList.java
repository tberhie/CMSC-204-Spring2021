
/**
 * This Implements a generic sorted double list from the Comparator.
 * It extends the BasicDoubleLinkedList class.
 * @author Tsega
 *
 **/

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> com;

	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		com = comparator2;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param T
	 * @return SortedDoubleLinkedList<T>
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		if (data == null) {
			return this;
		}

		Node newNode = new Node(data, null, null);
		if (head == null) {
			head = tail = new Node(data, null, null);
		} else {
			if (com.compare(data, head.data) <= 0) {
				newNode.next = head;
				head = newNode;
			} else if (com.compare(data, tail.data) >= 0) {
				tail.next = newNode;
				tail = newNode;
			} else {
				Node next = head.next;
				Node prev = head;
				while (com.compare(data, next.data) > 0) {
					prev = next;
					next = next.next;
				}
				prev.next = newNode;
				newNode.next = next;
			}
		}
		size++;
		return this;
	}

	/**
	 * An UnsupportedOperationException will be generated using the message "Invalid
	 * operation for sorted list."
	 * 
	 * @parm data
	 * @return reference to the current object
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("It is Invalid operation for sorted list");
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data
	 * @return reference to the current object
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("It is Invalid operation for sorted list");
	}

	/**
	 * Implements the iterator by calling the super class iterator method
	 * 
	 * @param
	 * @return an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator() {
		return new iter();
	}

	/**
	 * Implements the remove operation by calling the super class remove method.
	 * 
	 * @param targetData, comparator
	 * @return data element or null
	 *
	 */
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node next = head;
		Node prev = null;
		while (next != null) {
			if (comparator.compare(next.data, targetData) == 0) {
				size--;
				if (prev != null) {
					prev.next = next.next;
				} else {
					head = next.next;
				}
				if (next == tail) {
					tail = prev;
				}
			}
			prev = next;
			next = next.next;
		}
		return this;
	}
}