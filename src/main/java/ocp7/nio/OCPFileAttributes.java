package ocp7.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Map;
import java.util.Set;

class OCPFileAttributes {
    public static void main(String[] args) throws IOException {

        Path file = Paths.get("C:\\!\\!.pdf");

        //getAttribute
        Object size = Files.getAttribute(file, "size");
        Object creationTime = Files.getAttribute(file, "creationTime");

        //setAttribute
        Object hide = Files.getAttribute(file, "dos:hidden");
        Files.setAttribute(file, "dos:hidden", true);
        hide = Files.getAttribute(file, "dos:hidden");

        //readAttributes
        Map<String, Object> values = Files.readAttributes(file, "*");
        for (String attribute : values.keySet()) {
            System.out.println(attribute + " : " + values.get(attribute));
        }

        //BasicFileAttributes
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime fileCreationTime = attr.creationTime();
        FileTime fileLastAccessTime = attr.lastAccessTime();
        FileTime fileLastModifiedTime = attr.lastModifiedTime();

        //DosFileAttributes
        DosFileAttributes attr2 = Files.readAttributes(file, DosFileAttributes.class);
        boolean archive = attr2.isArchive();
        boolean hidden = attr2.isHidden();
        boolean system = attr2.isSystem();

        //PosixFileAttributes
        try {
            PosixFileAttributes attr3 = Files.readAttributes(file, PosixFileAttributes.class);
            UserPrincipal user = attr3.owner();
            GroupPrincipal group = attr3.group();
            Set<PosixFilePermission> set = attr3.permissions();
        } catch (Exception ex) {
        }

        //BasicFileAttributeView
        BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
        basicView.setTimes(fileCreationTime, fileCreationTime, fileCreationTime);

        //DosFileAttributeView
        DosFileAttributeView dosView = Files.getFileAttributeView(file, DosFileAttributeView.class);
        dosView.setHidden(true);

        //PosixFileAttributeView
        try {
            PosixFileAttributeView posixView = Files.getFileAttributeView(file, PosixFileAttributeView.class);
        } catch (Exception ex) {
        }

        //UserDefinedFileAttributeView
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
        userView.write("delete", Charset.defaultCharset().encode("true"));
        ByteBuffer buf = ByteBuffer.allocate(userView.size("delete"));
        userView.read("delete", buf);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();

        //AclFileAttributeView
        AclFileAttributeView AclView = Files.getFileAttributeView(file, AclFileAttributeView.class);
        List<AclEntry> acl = AclView.getAcl();
        for (AclEntry attribute : acl) {
            System.out.println(acl + " : " + attribute);
        }

        //FileOwnerAttributeView
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
        ownerView.getOwner();
    }
}
