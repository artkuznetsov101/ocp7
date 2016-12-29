package ocp7.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

class OCPPaths {
    public static void main(String args[]) {

        //toAbsolutePath
        Path file3 = Paths.get("8-1.txt");
        System.out.println(file3.toAbsolutePath());
        Path file4 = Paths.get("..\\8-1.txt");
        System.out.println(file4.toAbsolutePath());

        //normalize
        Path path5 = Paths.get("..\\8-1.txt").toAbsolutePath();
        path5 = path5.normalize();
        System.out.println(path5);

        //relativize
        Path dir = Paths.get("code");
        Path file = Paths.get("code/java/IO.java");
        System.out.println(file.relativize(dir));
        System.out.println(dir.relativize(file));
        dir = Paths.get("/code");
        file = Paths.get("/java/IO.java");
        System.out.println(file.relativize(dir));
        System.out.println(dir.relativize(file));

        //resolve
        Path path = Paths.get("/mydir/code");
        System.out.println(path.resolve(Paths.get("world/Hello.java")));
        System.out.println(path.resolve("/world/Hello.java"));
        Path absolutePath = Paths.get("E:/OCPJavaSE7/");
        System.out.println(absolutePath.resolve(path));
        System.out.println(path.resolve(absolutePath));

        //resolveSibling
        Path path2 = Paths.get("/mydir/eWorld.java");
        Path renamePath2 = path2.resolveSibling(Paths.get("newWorld.java"));
        Path copyPath2 = path2.resolveSibling("backup/eWorld.java");
        Path absolutePath2 = Paths.get("E:/OCPJavaSE7/");
        System.out.println(renamePath2);
        System.out.println(copyPath2);
        System.out.println(path2.resolveSibling(""));
        System.out.println(absolutePath2.resolveSibling(path2));
        System.out.println(path2.resolveSibling(absolutePath2));
    }
}
