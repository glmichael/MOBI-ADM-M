package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String id;
	private int count;
	private List<Node> children;

	public Node(List<String> ids) {
		System.out.println("Creating " + ids);
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

	public List<Node> addEntry(List<String> ids) {
		System.out.println("Adding" + ids);
		String firstId = ids.get(0);
		// this node has id
		if (this.id.equals(firstId)) {
			this.count++;
			ids.remove(0);
		}
		// stop, if empty
		if (ids.isEmpty()) {
			return null;
		}
		// there are children
		if (!children.isEmpty()) {
			// search for id in children
			for (Node n : children) {
				if (n.isId(ids)) {
					return n.addEntry(ids);
				}
			}
		}
		// no children or id is not in children
		Node node = new Node(ids);
		children.add(node);
		return node.addEntry(ids);

	}

	public boolean isId(List<String> ids) {
		return this.id.equals(ids.get(0));
	}

	public void print() {
		System.out.print("(" + id + ", " + count + ")[");
		for (Node node : children) {
			node.print();
		}
		System.out.print("]");
	}

	@Override
	public String toString() {
		return id.toString();
	}

}
