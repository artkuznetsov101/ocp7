package ocp7.threads;

class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("MyThread");
    }
}

class AnotherThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("AnotherThread");
    }
}

public class OCPJoin {
    public static void main(String[] args) {
        Thread a = new MyThread();
        Thread b = new Thread(new AnotherThread());
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
        }
    }
}
