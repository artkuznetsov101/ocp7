package ocp7.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class OCPArrayDeque {
    public static void main(String args[]) {

        Deque<Integer> d = new ArrayDeque<>();

        d.push(1);
        System.out.println(d);

        d.offerLast(2);
        System.out.println(d);

        d.push(3);
        System.out.println(d);

        //no remove
        d.peek();
        System.out.println(d);

        //no remove
        d.peekFirst();
        System.out.println(d);

        //no remove
        d.peekLast();
        System.out.println(d);

        //no remove
        d.getFirst();
        System.out.println(d);

        //no remove
        d.getLast();
        System.out.println(d);

        d.removeLast();
        System.out.println(d);

        d.pop();
        System.out.println(d);
    }
}
