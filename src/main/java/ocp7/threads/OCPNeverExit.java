package ocp7.threads;

public class OCPNeverExit extends Thread {
    public void run() {
        for (;;)
            ;
    }

    public static void main(String args[]) {
        System.out.println("Starting Main");
        new OCPNeverExit().start();
        System.out.println("Main returns");
    }
}
