package ocp7.io;

import java.io.Console;

public class OCPConsole {
    public static void main(String... args) {
        Console console = System.console();
        if (console != null) {
            String file = console.readLine("Enter File to delete:");
            console.format("About to delete %s %n", file);
            console.printf("Sure to delete %s(Y/N)?", file);
            String delete = console.readLine();
            if (delete.toUpperCase().trim().equals("Y")) {
                char[] pwd = console.readPassword("Enter Password:");
                if (pwd.length > 0)
                    console.format("Deleted %s", file);
                else
                    console.format("No password. Cancelling deletion");
            } else
                console.format("Operation cancelled... %nNow exiting.");
        } else
            System.out.println("No console");
    }
}
