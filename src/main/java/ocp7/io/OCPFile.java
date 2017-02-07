package ocp7.io;

import java.io.File;
import java.io.IOException;

public class OCPFile {
    public static void main(String... args) throws IOException {

        File dirs = new File("C:\\usr\\code\\java");
        System.out.println(dirs.mkdirs());

        File file = new File(dirs, "MyText.txt");
        if (!file.exists())
            System.out.println(file.createNewFile());

        System.out.println("getAbsolutePath()-> " + file.getAbsolutePath());
        System.out.println("getAbsoluteFile()-> " + file.getAbsoluteFile());
        System.out.println("getCanonicalPath()-> " + file.getCanonicalPath());
        System.out.println("getCanonicalFile()-> " + file.getCanonicalFile());
        System.out.println("getParentFile()-> " + file.getParentFile());
        System.out.println("getName()-> " + file.getName());
        System.out.println("getParent()-> " + file.getParent());
        System.out.println("isAbsolute()-> " + file.isAbsolute());
        System.out.println("toPath()-> " + file.toPath());
        System.out.println("toString()-> " + file.toString());
        System.out.println("toURI()-> " + file.toURI());
        System.out.println("canExecute()-> " + file.canExecute());
    }
}
