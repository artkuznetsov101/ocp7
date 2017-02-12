package ocp7.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

public class OCPNavigableSet {

    public static void main(String[] args) {
        NavigableSet<String> mymap1 = new TreeSet<String>();
        mymap1.add("a");
        mymap1.add("b");
        mymap1.add("c");
        mymap1.add("aa");
        mymap1.add("bb");
        mymap1.add("cc");
        System.out.println(mymap1);
        System.out.println(mymap1.floor("a"));
        System.out.println(mymap1.ceiling("aaa"));
        System.out.println(mymap1.lower("a"));
        System.out.println(mymap1.higher("bb"));
    }

}
