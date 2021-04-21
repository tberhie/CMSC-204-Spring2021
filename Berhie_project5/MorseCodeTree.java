/** 
 * MorseCodeTree
 * @author tsega
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> 
{

	private TreeNode<String> root;
	
	/**
	 * 
	 * @return refrence to the root
	 *
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * 
	 * @param newNode
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code This
	 * method will call the recursive method addNode
	 * 
	 * @param code,letter
	 * @return the MorseCodeTree with the new node added
	 */
	public MorseCodeTree insert(String code, String letter) {

		addNode(root, code, letter);

		return this;
	} 
	
	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code
	 * 
	 * @param root,code,letter
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.left = new TreeNode<String>(letter);
			} else if (code.charAt(0) == '-') {
				root.right = new TreeNode<String>(letter);
			}
			return;
		} else {
			if (code.charAt(0) == '.')
				addNode(root.left, code.substring(1), letter);
			else if (code.charAt(0) == '-')
				addNode(root.right, code.substring(1), letter);

		}

	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code
	 * @return the string letter that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);

	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left.
	 * 
	 * @param root,code
	 * @return the string letter corresponds to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {

		String letter;

		if (code.length() <= 1) {
			if (code.equals("."))
				return root.left.data;
			else
				return root.right.data;
		} else {
			if (code.charAt(0) == '.')
				letter = fetchNode(root.left, code.substring(1));
			else
				letter = fetchNode(root.right, code.substring(1));
		}
		return letter;

	}
	
	/**
	 * @param data
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();

	}
	
	/**
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 *
	 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * constructor calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code.
	 *
	 */
	public void buildTree() {
		root = new TreeNode<>("");

		insert(".", "e"); // level 1 on the tree
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a"); // level 2 on the tree
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w"); // level 3 on the tree
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l"); // level 4 on the tree
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 *
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {

		ArrayList<String> aList = new ArrayList<>();
		LNRoutputTraversal(root, aList);

		return aList;
	}
	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * 
	 * @param root,list
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root.left != null)
			LNRoutputTraversal(root.left, list);
		list.add(root.data);

		if (root.right != null)
			LNRoutputTraversal(root.right, list);

	}
}
