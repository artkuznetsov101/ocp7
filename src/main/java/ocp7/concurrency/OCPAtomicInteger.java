package ocp7.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class OCPAtomicInteger {

    public static void main(String args[]) {

        AtomicInteger ai = new AtomicInteger(0);
        //0
        System.out.println(ai.get());

        //0
        System.out.println(ai.getAndIncrement());
        //1
        System.out.println(ai.getAndDecrement());
        //0
        System.out.println(ai.getAndAdd(1));
        //1
        System.out.println(ai.getAndSet(9));

        //10
        System.out.println(ai.incrementAndGet());
        //9
        System.out.println(ai.decrementAndGet());
        //10
        System.out.println(ai.addAndGet(1));
        //11
        System.out.println(ai.compareAndSet(10, 11) + " " + ai.get());
    }
}
