package scan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Scanner {

	// minimum support
	Integer xi;

	public Scanner(Integer xi) {
		this.xi = xi;
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
		
		while(iterator.hasNext()){
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
