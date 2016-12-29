package ocp7.io;

import java.io.File;
import java.io.IOException;

public class OCPFile2 {
    public static void main(String... args) throws IOException {
        File dirs = new File("C:\\usr\\code\\java");
        System.out.println(dirs.mkdirs());
        File file = new File(dirs, "MyText.txt");
        if (!file.exists())
            System.out.println(file.createNewFile());
    }
}