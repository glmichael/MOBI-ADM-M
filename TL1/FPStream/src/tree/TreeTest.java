package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

	public static void main(String[] args) {
		// myTest();
		lectureTest();

	}

	private static void myTest() {
		TreeManager tm = new TreeManager();
		List<String> t1 = new ArrayList<String>();
		t1.add("f");
		t1.add("b");
		t1.add("c");
		t1.add("d");
		System.out.println(t1);
		tm.addTransaction(t1);
		tm.printTree();

		List<String> t2 = new ArrayList<String>();
		t2.add("a");
		t2.add("x");
		t2.add("c");
		t2.add("d");
		tm.addTransaction(t2);
		tm.printTree();
	}

	private static void lectureTest() {
		TreeManager tm = new TreeManager();
		List<String> t1 = new ArrayList<String>();
		t1.add("f");
		t1.add("c");
		t1.add("a");
		t1.add("m");
		t1.add("p");
		System.out.println(t1);
		tm.addTransaction(t1);
		tm.printTree();
		System.out.println(tm.getHeadMap());

		List<String> t2 = new ArrayList<String>();
		t2.add("f");
		t2.add("c");
		t2.add("a");
		t2.add("b");
		t2.add("m");
		tm.addTransaction(t2);
		tm.printTree();

		List<String> t3 = new ArrayList<String>();
		t3.add("f");
		t3.add("b");
		tm.addTransaction(t3);
		tm.printTree();

		List<String> t4 = new ArrayList<String>();
		t4.add("c");
		t4.add("b");
		t4.add("p");
		tm.addTransaction(t4);
		tm.printTree();

		List<String> t5 = new ArrayList<String>();
		t5.add("f");
		t5.add("c");
		t5.add("a");
		t5.add("m");
		t5.add("p");
		tm.addTransaction(t5);
		tm.printTree();
		System.out.println(tm.getHeadMap());
	}
}
