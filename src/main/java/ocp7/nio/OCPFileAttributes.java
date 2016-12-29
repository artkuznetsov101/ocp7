package ocp7.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Map;

class OCPFileAttributes {
    public static void main(String[] args) throws IOException {

        Path file = Paths.get("C:\\!\\!.pdf");

        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime fileCreationTime = attr.creationTime();
        FileTime fileLastAccessTime = attr.lastAccessTime();
        FileTime fileLastModifiedTime = attr.lastModifiedTime();

        BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
        basicView.setTimes(fileCreationTime, fileCreationTime, fileCreationTime);

        Map<String, Object> values = Files.readAttributes(file, "*");
        for (String attribute : values.keySet()) {
            System.out.println(attribute + " : " + values.get(attribute));
        }

        DosFileAttributeView dosView = Files.getFileAttributeView(file, DosFileAttributeView.class);
        dosView.setHidden(true);

        DosFileAttributes dosAttrs = dosView.readAttributes();
        System.out.println("Hidden? " + dosAttrs.isHidden());

        Files.setAttribute(file, "dos:hidden", false);
        dosAttrs = dosView.readAttributes();
        System.out.println("Hidden? " + dosAttrs.isHidden());

        UserDefinedFileAttributeView userView = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
        userView.write("delete", Charset.defaultCharset().encode("true"));
        ByteBuffer buf = ByteBuffer.allocate(userView.size("delete"));
        userView.read("delete", buf);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();

    }
}
