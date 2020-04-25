import java.util.ArrayList;

/**
 * Project 5: Morse Code Converter
 * Prof. Thai CMSC 204
 * MorseCodeTree.java
 * A Tree that Represents the Conversions of MorseCode into English characters.
 * @author Alec Felix
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;

	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}// constructor

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}// getRoot

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}// setRoot

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		if (root == null) {
			setRoot(new TreeNode<String>(""));
		} else {
			addNode(root, code, result);
		}
		return this;
	}// LinkedConverterTreeInterface

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.setLeft(letter);
			} else if (code.charAt(0) == '-') {
				root.setRight(letter);
			}
			return;
		}

		if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				addNode(root.getLeft(), code.substring(1), letter);
			} else if (code.charAt(0) == '-') {
				addNode(root.getRight(), code.substring(1), letter);
			}
		}

	}// addNode

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}// fetch

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (root == null) {
			return "NULL";
		}

		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				return root.getLeft().getData();
			} else if (code.charAt(0) == '-') {
				return root.getRight().getData();
			}
			return "";
		} else if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				return fetchNode(root.getLeft(), code.substring(1));
			} else if (code.charAt(0) == '-') {
				return fetchNode(root.getRight(), code.substring(1));
			}
		}
		return "null";
	}// fetchNode

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}// delete

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}// update

	@Override
	public void buildTree() {
		root = new TreeNode<String>("");

		insert(".", "e");
		insert("-", "t");


		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}//buildTree

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root,list);
		
		return list;
	}// toArrayList

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null)
			return;
		
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
		return;
	}//LNRoutputTraversal

}// MorseCodeTree
