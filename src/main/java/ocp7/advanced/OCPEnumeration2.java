package ocp7.advanced;

public enum OCPEnumeration2 {
                             ASSERT(1.4), // line1
                             DO,
                             IF,
                             WHILE; // line2
    double version = 1.0; // line3

    OCPEnumeration2() { // constructor 1
        this.version = 1.0; // constructor 1
    } // constructor 1

    OCPEnumeration2(double version) { // constructor 2
        this.version = version; // constructor 2
    } // constructor 2

    public static void main(String args[]) {
        OCPEnumeration2[] keywords = OCPEnumeration2.values();
        for (OCPEnumeration2 val : keywords)
            System.out.println(val);
    }
}
