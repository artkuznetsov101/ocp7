package ocp7.io;

import java.io.File;

public class OCPFile {
    public static void main(String... args) {
        countDirFiles(new File("c:\\work2"));
    }

    public static void countDirFiles(File dir) {
        if (dir.isDirectory()) {
            int fileCount = 0;
            int dirCount = 0;
            String[] list = dir.list();
            File item = null;
            for (String listItem : list) {
                item = new File(dir, listItem);
                if (item.isFile())
                    ++fileCount;
                else if (item.isDirectory())
                    ++dirCount;
            }
            System.out.println("File(s):" + fileCount);
            System.out.println("Dir(s):" + dirCount);
        } else {
            throw new IllegalArgumentException("Not a directory");
        }
    }
}
