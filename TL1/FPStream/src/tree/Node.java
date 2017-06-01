package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {

	private String id;
	private int count;
	private List<Node> children;

	public Node() {
		this.id = "";
		this.children = new ArrayList<Node>();
		count = Integer.MIN_VALUE;
	}

	public Node(List<String> ids) {
		// init this tree
		this.id = ids.get(0);
		this.children = new ArrayList<Node>();
		this.count = 0;
		// this.addEntry(ids);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void incrementCount() {
		this.count++;
	}

	public void addChildren(Node n) {
		this.children.add(n);
	}

	public List<Node> getChildren() {
		return this.children;
	}

	public void addTransaction(List<String> ids, List<Node> path) {
		String firstId = ids.get(0);
		// this node has id
		if (this.id.equals(firstId)) {
			this.count++;
			ids.remove(0);
			path.add(this);
		}
		// stop, if empty
		if (ids.isEmpty()) {
			return;
		}
		// there are children
		if (!children.isEmpty()) {
			// search for id in children
			for (Node n : children) {
				if (n.isId(ids)) {
					n.addTransaction(ids, path);
					return;
				}
			}
		}
		// no children or id is not in children
		Node node = new Node(ids);
		children.add(node);
		node.addTransaction(ids, path);

	}

	public boolean isId(List<String> ids) {
		return this.id.equals(ids.get(0));
	}

	public void print(int layer) {
		String indent = String.join("", Collections.nCopies(layer, "  "));
		System.out.println(indent + "[" + id + ", " + count + "]");
		for (Node node : children) {
			node.print(layer + 1);
		}
		// System.out.println(indent + "]");
	}

	@Override
	public String toString() {
		return "(" + id + ", " + count + ")";
	}

}
