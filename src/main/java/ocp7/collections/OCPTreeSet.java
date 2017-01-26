package ocp7.collections;

import java.util.TreeSet;

class Dog implements Comparable<Dog> {
    int size;

    Dog(int s) {
        size = s;
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    @Override
    public String toString() {
        return "Dog " + size;
    }

}

public class OCPTreeSet {
    public static void main(String args[]) {
        TreeSet<String> s = new TreeSet<String>();
        s.add("e");
        s.add("d");
        s.add("c");
        s.add("b");
        s.add("a");
        System.out.println(s);

        TreeSet<String> subs = new TreeSet<String>();
        subs = (TreeSet) s.subSet("b", true, "d", true);
        System.out.println(subs);

        s.add("g");
        s.pollFirst();
        s.pollFirst();
        s.add("c2");
        System.out.println(subs);

        TreeSet<Integer> i = new TreeSet<Integer>();
        TreeSet<Dog> d = new TreeSet<Dog>();
        i.add(1);
        i.add(2);
        i.add(1);
        System.out.println(i);

        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(1));
        d.add(new Dog(0));
        System.out.println(d);
    }
}
