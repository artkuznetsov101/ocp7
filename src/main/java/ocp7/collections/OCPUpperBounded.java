package ocp7.collections;

import java.util.ArrayList;
import java.util.List;

public class OCPUpperBounded {
    public static void main(String[] args) {

        class Gift {
        }

        class Book extends Gift {
        }

        List<? extends Gift> sList1 = new ArrayList<Gift>();
        for (Object obj : sList1)
            System.out.println(obj);
        for (Gift obj2 : sList1)
            System.out.println(obj2);

        List<? extends Gift> sList2 = new ArrayList<Book>();
        for (Object obj : sList2)
            System.out.println(obj);
        for (Gift obj2 : sList2)
            System.out.println(obj2);

        List<? extends Book> sList3 = new ArrayList<Book>();
        for (Object obj : sList3)
            System.out.println(obj);
        for (Gift obj2 : sList3)
            System.out.println(obj2);
    }
}
