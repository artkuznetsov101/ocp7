package ocp7.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class OCPDirectoryStream {
    public static void main(String args[]) throws IOException {

        listFiles(Paths.get("c:\\work"));
    }

    static void listFiles(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    System.out.println("> " + entry);
                    listFiles(entry);
                } else {
                    System.out.println("\t> " + entry);
                }
            }
        }
    }

    static List<Path> listFiles2(Path path) throws IOException {
        Deque<Path> stack = new ArrayDeque<Path>();
        final List<Path> files = new LinkedList<>();

        stack.push(path);

        while (!stack.isEmpty()) {
            DirectoryStream<Path> stream = Files.newDirectoryStream(stack.pop());
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    stack.push(entry);
                } else {
                    files.add(entry);
                }
            }
            stream.close();
        }
        return files;
    }
}