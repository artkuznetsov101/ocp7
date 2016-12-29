package ocp7.advanced;

public class OCPInnerClass {

    public static void main(String args[]) {

        Outer outer = new Outer();
        Outer.Inner inner1 = outer.new Inner();
        Outer.Inner inner2 = new Outer().new Inner();

        System.out.println(inner1);
        System.out.println(inner2);
    }
}

class Outer {

    Inner in1 = new Inner();
    Inner in2 = this.new Inner();
    Inner in3 = new Outer().new Inner();

    class Inner {

    }
}
