package ocp7.io.byte_rw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OCPFileStream2 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream(new File("c:\\!\\!.pdf")); FileOutputStream out = new FileOutputStream("c:\\!\\!!.pdf");) {
            int data;
            byte[] byteArr = new byte[1024];
            long start = System.currentTimeMillis();
            while ((data = in.read(byteArr)) != -1) {
                out.write(byteArr, 0, data);
            }
            long end = System.currentTimeMillis();
            System.out.println("MilliSeconds elapsed : " + (end - start));
        }
    }
}
