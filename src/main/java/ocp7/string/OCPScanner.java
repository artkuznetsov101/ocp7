package ocp7.string;

import java.util.Scanner;

public class OCPScanner {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner("The \tnew \nProgrammer exam");
        while (scanner.hasNext())
            System.out.println(scanner.next());

        Scanner scanner1 = new Scanner("The1new22Programmer exam6");
        scanner1.useDelimiter("[\\d]+");
        while (scanner1.hasNext())
            System.out.println(scanner1.next());

        Scanner scanner2 = new Scanner("The1new22Programmer exam6");
        scanner2.useDelimiter("[\\sA-Za-z]+");
        while (scanner2.hasNext())
            System.out.println(scanner2.next());

        Scanner scanner3 = new Scanner("Shreya,20,true");
        scanner3.useDelimiter(",");
        System.out.println(scanner3.next());
        System.out.println(scanner3.nextInt());
        System.out.println(scanner3.nextBoolean());

    }
}
