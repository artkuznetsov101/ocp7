package ocp7.io.char_rw;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCPFileReader {
    public static void main(String[] args) throws IOException {
        try (FileReader input = new FileReader("c:\\!\\Main.java"); FileWriter output = new FileWriter("c:\\!\\Main2.java");) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        }
    }
}
