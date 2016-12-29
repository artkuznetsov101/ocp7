package ocp7.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OCPFiles {
    public static void main(String[] args) throws Exception {

        //attributes
        Path path = Paths.get("C:\\!\\!.pdf");
        System.out.println("size:" + Files.size(path));
        System.out.println("isDirectory:" + Files.isDirectory(path));
        System.out.println("isExecutable:" + Files.isExecutable(path));
        System.out.println("isHidden:" + Files.isHidden(path));
        System.out.println("isReadable:" + Files.isReadable(path));
        System.out.println("isSameFile:" + Files.isSameFile(path, path));
        System.out.println("isDirectory:" + Files.isDirectory(path));
        System.out.println("isSymbolicLink:" + Files.isSymbolicLink(path));
        System.out.println("isWritable:" + Files.isWritable(path));
        System.out.println("getLastModifiedTime:" + Files.getLastModifiedTime(path));
        System.out.println("getOwner:" + Files.getOwner(path));

        //create dir
        Files.createDirectories(Paths.get("C:\\!\\!\\!"));

        //copy
        Files.copy(path, Paths.get("C:\\!\\!copy.pdf"), StandardCopyOption.REPLACE_EXISTING);

        //move
        Files.move(Paths.get("C:\\!\\!copy.pdf"), Paths.get("C:\\!\\!move.pdf"), StandardCopyOption.ATOMIC_MOVE);
    }
}
