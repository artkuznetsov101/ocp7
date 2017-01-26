package ocp7.collections;

import java.util.Arrays;

public class OCPArrays {
    static String[] sa = { "aaaa", "a", "aaa", "aa" };

    static {
        Arrays.sort(sa);
        System.out.println(Arrays.toString(sa));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(sa, "aaaa"));
        System.out.println(Arrays.binarySearch(sa, ""));
    }
}
