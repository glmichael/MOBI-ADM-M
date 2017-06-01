package main;

import java.io.File;
import java.util.ArrayList;

import scan.ScanManager;
import tree.TreeManager;

public class Main {

	public static void main(String[] args) {
		int windowsize = 100;
		int xi = 3;

		ScanManager scanManager = new ScanManager(windowsize, new File("market_data.csv"), xi);
		ArrayList<ArrayList<String>> transactions;

		int counter = 0;
		while ((transactions = scanManager.scanNextWindow()) != null) {
			TreeManager treeManager = new TreeManager();
			for (ArrayList<String> transaction : transactions) {
				if (!transaction.isEmpty()) {
					treeManager.addTransaction(transaction);
				}
			}
			treeManager.printTree();

			System.out.println(counter);
			counter += windowsize;
		}

	}

}
