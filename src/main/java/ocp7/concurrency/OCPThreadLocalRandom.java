package ocp7.concurrency;

import java.util.concurrent.ThreadLocalRandom;

public class OCPThreadLocalRandom {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++)
            System.out.println("Random int is: " + ThreadLocalRandom.current().nextInt());

        for (int i = 0; i < 10; i++)
            System.out.println("Random int 0-9 is: " + ThreadLocalRandom.current().nextInt(10));

        for (int i = 0; i < 10; i++)
            System.out.println("Random int 100-109 is: " + ThreadLocalRandom.current().nextInt(100, 110));

        for (int i = 0; i < 10; i++)
            System.out.println("Random boolean is: " + ThreadLocalRandom.current().nextBoolean());

        for (int i = 0; i < 10; i++)
            System.out.println("Random long 0-MAX_VALUE is: " + ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));

        for (int i = 0; i < 10; i++)
            System.out.println("Random long MIN_VALUE-MAX_VALUE is: " + ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
