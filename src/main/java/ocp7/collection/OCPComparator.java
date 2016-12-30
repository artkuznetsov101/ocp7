package ocp7.collection;

import java.util.Arrays;
import java.util.Comparator;

public class OCPComparator {

	static String[] sa = { "d", "bbb", "aaaa" };

	public static void main(String[] args) {
		System.out.println(Arrays.binarySearch(sa, "cc", new MyStringComparator()));
		System.out.println(Arrays.binarySearch(sa, "c", new MyStringComparator()));
	}
}

class MyStringComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		int s1 = ((String) o1).length();
		int s2 = ((String) o2).length();
		return s1 - s2;
	}
}
