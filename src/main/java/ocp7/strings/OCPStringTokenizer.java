package ocp7.strings;

import java.util.StringTokenizer;

public class OCPStringTokenizer {
    public static void main(String args[]) throws Exception {

        System.out.println();
        StringTokenizer st = new StringTokenizer("start your startup");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println();
        StringTokenizer st1 = new StringTokenizer("start0your0startup", "0");
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }

        System.out.println();
        StringTokenizer st2 = new StringTokenizer("abcde", "db");
        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }

        System.out.println();
        StringTokenizer st3 = new StringTokenizer("abcde", "db", true);
        while (st3.hasMoreTokens()) {
            System.out.println(st3.nextToken());
        }

        System.out.println();
        StringTokenizer st4 = new StringTokenizer("a aa aaa", "x");
        while (st4.hasMoreTokens()) {
            System.out.println(st4.nextToken());
        }
    }
}
