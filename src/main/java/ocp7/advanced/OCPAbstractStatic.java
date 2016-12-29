package ocp7.advanced;

abstract class Satellite {
    static {
        ctr = (int) Math.random();
    }

    static final int ctr;
}

class OCPAbstractStatic extends Satellite {
    public static void main(String args[]) {
        System.out.println(OCPAbstractStatic.ctr);
    }
}