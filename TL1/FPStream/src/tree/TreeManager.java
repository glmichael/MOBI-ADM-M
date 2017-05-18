package tree;

public class TreeManager {

	private Node root;

	public TreeManager() {

	}

	public Node addEntry(String id) {
		if (root == null) {
			root = new Node(id);
		} else {
			root.addEntry(id);
		}
		return null;
	}
}
