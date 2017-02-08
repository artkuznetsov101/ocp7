package ocp7.nio;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class ListFileNames extends SimpleFileVisitor<Path> {

    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) {
        System.out.println("Directory name :" + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        System.out.println("File name :" + file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

public class OCPSimpleFileVisitor {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("c:\\work");
        ListFileNames listFileNames = new ListFileNames();
        Files.walkFileTree(path, listFileNames);
    }
}
