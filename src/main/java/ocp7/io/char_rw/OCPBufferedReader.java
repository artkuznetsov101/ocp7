package ocp7.io.char_rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCPBufferedReader {
    public static void main(String... args) {
        try (FileReader fr = new FileReader("c:\\!\\Main.java"); BufferedReader br = new BufferedReader(fr); FileWriter fw = new FileWriter("c:\\!\\Main2.java"); BufferedWriter bw = new BufferedWriter(fw);) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
