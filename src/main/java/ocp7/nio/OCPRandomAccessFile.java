package ocp7.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class OCPRandomAccessFile {

    public static void main(String args[]) {
        RandomAccessFile file;
        try {
            file = new RandomAccessFile("c:\\!\\file.txt", "rw");
            file.seek(200);
            long pointer = file.getFilePointer();
            FileChannel channel = file.getChannel();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
