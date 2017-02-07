package ocp7.strings;

import java.util.Formatter;

class OCPFormatter {
    public static void main(String args[]) throws Exception {

        String name = "Abcde";
        int integer = 5;

        Formatter formatter = new Formatter(System.out);
        formatter.format("My name is %s", name);

        System.out.printf("My name is %s", name);
        System.out.println();
        System.out.printf("integer as boolean: %b", integer);
        System.out.println();
        System.out.printf("null as boolean: %b", null);

        System.out.println();
        System.out.printf("char as char: %c", '\u0041');
        System.out.println();
        System.out.printf("integer as char: %c", integer);
        System.out.println();
        System.out.printf("null as char: %c", null);
        System.out.println();
        System.out.printf("integer as char: %c", new Integer(999999));

        float floatValue = 100;
        System.out.println();
        System.out.printf("[%f]", floatValue);
        System.out.println();
        System.out.printf("[%(f]", 12.12345);
        System.out.println();
        System.out.printf("[%(f]", -12.12345);
        System.out.println();
        System.out.printf("[%012f]", 12.12345);
        System.out.println();
        System.out.printf("[%-10f]", 12.12345);
        System.out.println();
        System.out.printf("[%10.2f]", 12.98765);
        System.out.println();
        System.out.printf("[%,f]", 123456789.12345);

        System.out.println();
        System.out.printf("%1$s %s %<s", "A", "B", "C");
    }
}
