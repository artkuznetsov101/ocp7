package ocp7.assertions;

public class OCPAssertion2 {
    public static void main(String args[]) {
        String s = "assert";
        //assert(s == null : s = new String());
        assert s == null : s = new String();
        assert(s == null) : s = new String();
        assert(s.equals("assert"));
        assert s.equals("assert");
        assert s == "assert";
        s.replace('a', 'z');
        //assert s = new String("Assert") : s.toString();
        //assert s == new String("Assert") : System.out.println(s);
        //assert(s = new String("Assert") : System.out.println(s));

    }
}