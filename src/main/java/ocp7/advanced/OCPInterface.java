package ocp7.advanced;

interface Admissible {
}

public class OCPInterface {
    static void admit(Admissible adm) {
        System.out.println("admission complete");
    }

    public static void main(String args[]) {
        admit(new Admissible() {
        });
    }
}
