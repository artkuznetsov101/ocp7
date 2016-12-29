package ocp7.io.byte_rw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OCPFileStream {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("c:\\!\\!.pdf"); FileOutputStream out = new FileOutputStream("c:\\!\\!!.pdf");) {
            int data;
            int i = 0;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        }
    }
}
