package ocp7.advanced;

public class OCPStaticNestedClass {
    static int outerStatic = 10;
    int outerInstance = 20;

    static class StaticNested {
        static int innerStatic = 10;
        int innerInstance = 20;
    }

    public static void main(String args[]) {
        StaticNested nested1 = new StaticNested();
        OCPStaticNestedClass.StaticNested nested2 = new OCPStaticNestedClass.StaticNested();
        nested1.innerStatic = 99;
        nested1.innerInstance = 999;
        System.out.println(nested1.innerStatic + ":" + nested1.innerInstance);
        System.out.println(nested2.innerStatic + ":" + nested2.innerInstance);
    }
}