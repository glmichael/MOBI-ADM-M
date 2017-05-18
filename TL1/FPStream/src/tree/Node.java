package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String id;
	private int count;
	private List<Node> children;

	public Node(String id) {
		this.id = id;
		this.children = new ArrayList<Node>();
		this.count = 1;
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

	public Node addEntry(String id) {
		if (this.id.equals(id)) {
			this.count++;
			return this;
		} else {
			if (children.isEmpty()) {
				Node n = new Node(id);
				children.add(n);
				return n;
			}
		}
		return null;
	}

}
