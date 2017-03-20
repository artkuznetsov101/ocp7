package ocp7.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OCPCollections {
    static String[] sa = { "aaaa", "a", "aaa", "aa", "0", "00", "A", "AA", " " };
    static ArrayList<String> list = new ArrayList<String>(Arrays.asList(sa));

    static {
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main(String[] args) {

    }
}
