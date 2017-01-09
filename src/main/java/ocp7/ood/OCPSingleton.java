package ocp7.ood;

class Singleton {
    private static Singleton instance;
    private int x;

    private Singleton(int x) {
        this.x = x;
    }

    public String toString() {
        return "Singleton " + this.x;
    }

    public synchronized static Singleton getSingleton() {
        if (instance == null) {
            instance = new Singleton(5);
        }
        return instance;
    }
}

public class OCPSingleton {
    public static void main(String[] args) {
        Singleton s = Singleton.getSingleton();
        Singleton t = Singleton.getSingleton();
        System.out.println("s " + s + ", " + "t " + t);
        System.out.println(s.equals(t));
    }
}
