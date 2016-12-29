package ocp7.io.byte_rw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OPCBufferedStream {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("c:\\!\\!.pdf");
                FileOutputStream out = new FileOutputStream("c:\\!\\!!.pdf");
                BufferedInputStream bis = new BufferedInputStream(in);
                BufferedOutputStream bos = new BufferedOutputStream(out);) {
            int data;
            long start = System.currentTimeMillis();
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            long end = System.currentTimeMillis();
            System.out.println("MilliSeconds elapsed : " + (end - start));
        }
    }
}
