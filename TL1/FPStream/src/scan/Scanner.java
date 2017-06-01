package scan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Scanner {

	// minimum support
	Integer xi;

	File file;

	public Scanner(Integer xi, File file) {
		this.xi = xi;
		this.file = file;
	}

	public ArrayList<String> scanFirstWindow(int numberOfLines) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		TreeMap<String, Integer> sorted = null;
		ArrayList<String> list = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {

			while (numberOfLines > 0) {
				String line = br.readLine();
				String[] items = line.split(" ");

				for (int i = 0; i < items.length; i++) {
					if (map.containsKey(items[i])) {
						Integer count = map.get(items[i]);
						count = count + 1;
						map.put(items[i], count);
					} else {
						map.put(items[i], 1);
					}
				}
				numberOfLines--;
			}

			Iterator<String> iterator = map.keySet().iterator();

			while (iterator.hasNext()) {
				if (map.get(iterator.next()) < xi) {
					iterator.remove();
				}
			}

			sorted = sortMapByValue(map);
			list.addAll(sorted.keySet());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<ArrayList<String>> scanLines(int numberOfLines, int batch, ArrayList<String> fList) {

		ArrayList<ArrayList<String>> listofTransactions = new ArrayList<ArrayList<String>>();

		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			while (batch > 0) {
				int toIgnore = numberOfLines;
				while (toIgnore > 0) {

					if (br.readLine() == null) {
						return null;
					}
					toIgnore--;
				}
				batch--;
			}
			String line;
			while (numberOfLines > 0 && ((line = br.readLine()) != null)) {
				ArrayList<String> items = new ArrayList<String>(Arrays.asList(line.split(" ")));
				ArrayList<String> transaction = new ArrayList<String>();

				for (String f : fList) {
					if (items.contains(f)) {
						transaction.add(f);
					}
				}
				listofTransactions.add(transaction);

				numberOfLines--;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listofTransactions;

	}

	public String[] scan(String db) {
		String[] items = db.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < items.length; i++) {
			if (map.containsKey(items[i])) {
				Integer count = map.get(items[i]);
				count = count + 1;
				map.put(items[i], count);
			} else {
				map.put(items[i], 1);
			}
		}

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			if (map.get(iterator.next()) < xi) {
				iterator.remove();
			}
		}

		TreeMap sorted = sortMapByValue(map);

		String[] ret = (String[]) sorted.keySet().toArray(new String[sorted.keySet().size()]);

		return ret;
	}

	// http://www.programcreek.com/2013/03/java-sort-map-by-value/
	private TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}

	// a comparator that compares Strings
	class ValueComparator implements Comparator<String> {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		public ValueComparator(HashMap<String, Integer> map) {
			this.map.putAll(map);
		}

		@Override
		public int compare(String s1, String s2) {
			if (map.get(s1) >= map.get(s2)) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
