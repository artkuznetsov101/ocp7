package ocp7.strings;

import java.util.StringTokenizer;

public class OCPStringTokenizer {
    public static void main(String args[]) throws Exception {

        StringTokenizer st = new StringTokenizer("start your startup");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer("start0your0startup", "0");
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }
    }
}
