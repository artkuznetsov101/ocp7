package ocp7.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class OCPTreeMap {
    public static void main(String[] args) {
        TreeMap<String, String> myMap = new TreeMap<String, String>();
        myMap.put("a", "apple");
        myMap.put("d", "date");
        myMap.put("f", "fig");
        myMap.put("p", "pear");
        System.out.println("1st after mango: " + myMap.higherKey("f"));
        System.out.println("1st after mango: " + myMap.ceilingKey("f"));
        System.out.println("1st after mango: " + myMap.floorKey("f"));
        SortedMap<String, String> sub = new TreeMap<String, String>();
        sub = myMap.tailMap("f");
        System.out.println("1st after mango: " + sub.firstKey());
    }
}
