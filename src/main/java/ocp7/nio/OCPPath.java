package ocp7.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

class OCPPath {
    public static void main(String args[]) throws IOException {
        Path path = FileSystems.getDefault().getPath("c:\\!\\obj8\\8-1.txt");
        System.out.println("toString()-> " + path.toString());
        System.out.println("getRoot()-> " + path.getRoot());
        System.out.println("getName(0)-> " + path.getName(0));
        System.out.println("getName(1)-> " + path.getName(1));
        System.out.println("getFileName()-> " + path.getFileName());
        System.out.println("getNameCount()-> " + path.getNameCount());
        System.out.println("getParent()-> " + path.getParent());
        System.out.println("subpath(0,2)-> " + path.subpath(0, 2));
        System.out.println("toRealPath()-> " + path.toAbsolutePath());
        System.out.println("toAbsolutePath()-> " + path.toAbsolutePath());
        System.out.println("relativize()-> " + path.relativize(Paths.get("c:\\!\\new")));

    }
}
