package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

	public static void main(String[] args) {
		TreeManager tm = new TreeManager();
		List<String> t1 = new ArrayList<String>();
		t1.add("a");
		t1.add("b");
		t1.add("c");
		t1.add("d");
		System.out.println(t1);
		tm.addEntry(t1);
		tm.printTree();

		List<String> t2 = new ArrayList<String>();
		t2.add("a");
		t2.add("x");
		t2.add("c");
		t2.add("d");
		tm.addEntry(t2);
		tm.printTree();
	}
}
