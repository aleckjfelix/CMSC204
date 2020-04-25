/**
 * Project 5: Morse Code Converter 
 * Prof. Thai CMSC 204
 * TreeNode.java
 * Consists of a reference to the data and a ref to the left AND right child
 * @author Alec Felix
 *
 * @param <T> Generic
 */
public class TreeNode <T>{
	private T data;
	private TreeNode<T> left, right;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode to be set
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = right = null;
		
	}// constructor
	
	/**
	 * Deep copy constructor
	 * @param node to copy
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		left = node.left;
		right = node.right;
	}// constructor
	
	/**
	 * Getter method for data attribute
	 * @return the data within this treenode
	 */
	public T getData() {
		return this.data;
	}//getData
	
	/**
	 * set the left reference
	 * @param data to set node to
	 */
	public void setLeft(T data) {
		left = new TreeNode(data);
	}//setLeft
	
	/**
	 * Setter for right reference
	 * @param data to set reference to
	 */
	public void setRight(T data) {
		right = new TreeNode(data);
	}//setRight
	
	/**
	 * Getter for left reference
	 * @return TreeNode for the left reference
	 */
	public TreeNode<T> getLeft() {
		return left;
	}// getLeft
	
	/**
	 * Getter for the right reference
	 * @return TreeNode for the right reference
	 */
	public TreeNode<T> getRight() {
		return right;
	}// getRight
	
	
}//TreeNode
