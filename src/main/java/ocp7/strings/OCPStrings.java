package ocp7.strings;

public class OCPStrings {
    public static void main(String[] args) {
        String s = "hello world";
        String t = "hello world";
        System.out.println("substring: " + s.substring(0, 5));
        System.out.println("contains: " + s.contains("hello"));
        System.out.println("equal: " + (s == t));
        System.out.println("indexOf: " + s.indexOf("world"));
        System.out.println("matches: " + s.matches("\\w+\\s\\w+"));
    }
}
