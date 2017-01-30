package ocp7.collections;

import java.util.ArrayList;
import java.util.List;

public class OCPLowerBounded {
    public static void main(String[] args) {

        class Gift {
        }

        class Book extends Gift {
        }

        class Phone extends Gift {
        }

        List<? super Gift> sList1 = new ArrayList<Gift>();
        sList1.add(new Gift());
        sList1.add(new Book());
        sList1.add(new Phone());
        for (Object obj : sList1)
            System.out.println(obj);

        List<? super Gift> sList2 = new ArrayList<Object>();
        sList2.add(new Gift());
        sList2.add(new Book());
        sList2.add(new Phone());
        for (Object obj : sList2)
            System.out.println(obj);

        List<? super Phone> sList3 = new ArrayList<Gift>();
        sList3.add(new Phone());
        for (Object obj : sList3)
            System.out.println(obj);

        List<? super Phone> sList4 = new ArrayList<Object>();
        sList4.add(new Phone());
        for (Object obj : sList4)
            System.out.println(obj);

        //List<? super Gift> sList5 = new ArrayList<Phone>();
    }
}
