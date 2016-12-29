package ocp7.concurent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class OCPCopyOnWriteArrayList {
    public static void main(String args[]) {
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.add(4);
        cowList.add(2);
        cowList.add(6);
        Iterator<Integer> it = cowList.iterator();
        cowList.remove(2);
        cowList.add(5);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
