package ocp7.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OCPConcurrentHashMap {
    public static void main(String args[]) {

        ConcurrentMap<String, String> d = new ConcurrentHashMap<>();

        d.putIfAbsent("key1", "data");
        System.out.println(d);

        d.replace("key1", "data", "newdata");
        System.out.println(d);

        d.remove("key1", "newdata");
        System.out.println(d);
    }
}
