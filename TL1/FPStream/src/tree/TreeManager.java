package tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeManager {

	private Node root;

	private Map<String, Node> headMap;

	public TreeManager() {
		headMap = new HashMap<String, Node>();
	}

	public void addEntry(List<String> ids) {

		if (root == null) {
			root = new Node(ids);
		}
		List<Node> path = root.addEntry(ids);
	}

	public void printTree() {
		root.print();
	}
}
