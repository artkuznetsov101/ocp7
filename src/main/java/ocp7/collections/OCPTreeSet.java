package ocp7.collections;

import java.util.TreeSet;

class Dog {
    int size;

    Dog(int s) {
        size = s;
    }
}

public class OCPTreeSet {
    public static void main(String args[]) {
        TreeSet<String> s = new TreeSet<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");

        TreeSet<String> subs = new TreeSet<String>();
        subs = (TreeSet) s.subSet("b", true, "d", true);
        s.add("g");
        s.pollFirst();
        s.pollFirst();
        s.add("c2");

        System.out.println(s.size() + " " + subs.size());

        TreeSet<Integer> i = new TreeSet<Integer>();
        TreeSet<Dog> d = new TreeSet<Dog>();
        i.add(1);
        i.add(2);
        i.add(1);
        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(1));
        System.out.println(d.size() + " " + i.size());

    }
}
