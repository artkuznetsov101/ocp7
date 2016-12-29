package ocp7.assertion;

class Person {
    public String toString() {
        return "Pirates of the Caribbean";
    }
}

public class OCPAssertion {
    public static void main(String args[]) {
        String s = "assert";
        //assert(s == null : s = new String());
        assert s == null : s = new String();
        assert(s == null) : s = new String();

        boolean b = false;
        assert(b = true) : new Person();
        assert(b == false) : new Person();
    }
}
