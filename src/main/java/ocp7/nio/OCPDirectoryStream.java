package ocp7.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class OCPDirectoryStream {
    public static void main(String args[]) throws IOException {
        Path dir = Paths.get("c:\\!");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path value : stream) {
                System.out.println("> " + value + ":" + Files.isDirectory(value));
            }
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{txt,java}")) {
            Iterator<Path> iterator = stream.iterator();
            while (iterator.hasNext()) {
                System.out.println(">> " + iterator.next());
            }
        }
    }
}