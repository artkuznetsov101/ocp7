package ocp7.collections;

import java.util.NavigableMap;
import java.util.TreeMap;

public class OCPNavigableMap {

    public static void main(String[] args) {

        NavigableMap<String, String> mymap = new TreeMap<String, String>();
        mymap.put("a", "apple");
        mymap.put("b", "boy");
        mymap.put("c", "cat");
        mymap.put("aa", "apple1");
        mymap.put("bb", "boy1");
        mymap.put("cc", "cat1");
        System.out.println(mymap);

        mymap.pollLastEntry();
        mymap.pollFirstEntry();
        System.out.println(mymap);

        NavigableMap<String, String> tailmap = mymap.tailMap("bb", false);
        System.out.println(tailmap);

        System.out.println(tailmap.pollFirstEntry());
        System.out.println(mymap.size());
    }
}