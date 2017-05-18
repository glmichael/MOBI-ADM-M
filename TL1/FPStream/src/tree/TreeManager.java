package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeManager {

	private Node root;

	private Map<String, List<Node>> headMap;

	public TreeManager() {
		headMap = new HashMap<String, List<Node>>();
		root = new Node();
	}

	public void addTransaction(List<String> ids) {

		if (root == null) {
			root = new Node(ids);
		}
		List<Node> path = new ArrayList<Node>();
		root.addTransaction(ids, path);

		adjustHeadMap(path);

	}

	private void adjustHeadMap(List<Node> path) {
		for (Node node : path) {
			String id = node.getId();
			List<Node> heads;
			if ((heads = headMap.get(id)) != null) {
				if (!heads.contains(node)) {
					heads.add(node);
				}
			} else {
				heads = new ArrayList<Node>();
				heads.add(node);
				headMap.put(id, heads);

			}
		}
	}

	public void printTree() {
		root.print(0);
		System.out.print("\n\n");
	}

	public Map<String, List<Node>> getHeadMap() {
		return headMap;
	}

}
