package ocp7.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Drop {
    Lock theLock = new ReentrantLock();
    Condition canRead = theLock.newCondition();
    Condition canWrite = theLock.newCondition();
    int value;

    public int read() {
        theLock.lock();
        int res = 0;
        try {
            canRead.await();
            res = value;
            canWrite.signalAll();
        } catch (InterruptedException e) {
        } finally {
            theLock.unlock();
        }
        return res;
    }

    public void write(int value) {
        theLock.lock();
        try {
            canWrite.await();
            this.value = value;
            canRead.signalAll();
        } catch (InterruptedException e) {
        } finally {
            theLock.unlock();
        }
    }
}

class Reader extends Thread {
    Drop drop;

    public Reader(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        while (true) {
            System.out.println("Reader: waiting");
            int i = drop.read();
            System.out.println("Reader: read " + i);
        }
    }
}

class Writer extends Thread {
    Drop drop;

    public Writer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Writer: waiting");
            drop.write(i);
            System.out.println("Writer: written " + i);
        }
    }
}

public class OCPLock {
    public static void main(String[] args) {
        Drop drop = new Drop();
        Reader reader = new Reader(drop);
        Writer writer = new Writer(drop);
        reader.start();
        writer.start();
        try {
            writer.join();
        } catch (InterruptedException e) {
        }
        reader.interrupt();
    }
}
