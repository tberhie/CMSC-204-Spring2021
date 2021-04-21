/**
 * 
 * @author tsega
 *
 * @param <T>
 */
public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> left, right;

	/**
	 * Create a new TreeNode with left and right child set to null data set to the dataNode
	 * 
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = right = null;
	}

	/**
	 * used for making deep copies
	 * 
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;

	}

	/**
	 * gets the data returns it
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}
}