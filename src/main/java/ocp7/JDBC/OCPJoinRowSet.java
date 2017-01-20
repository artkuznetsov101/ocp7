package ocp7.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class OCPJoinRowSet {

    public static void main(String[] args) throws SQLException {

        Properties prop = new Properties();
        FileInputStream stream;
        try {
            stream = new FileInputStream("dbpass.properties");
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/testdb", prop);
        RowSetFactory rsf = RowSetProvider.newFactory();
        CachedRowSet studentRS = rsf.createCachedRowSet();
        studentRS.setCommand("select SID, NAME from STUDENT");
        CachedRowSet enrollmentRS = rsf.createCachedRowSet();
        enrollmentRS.setCommand("select SID, SUBJECT from ENROLLMENT");
        CachedRowSet teacherRS = rsf.createCachedRowSet();
        teacherRS.setCommand("select TID, SUBJECT from TEACHER");

        studentRS.execute(c);
        enrollmentRS.execute(c);
        teacherRS.execute(c);

        JoinRowSet jrs = rsf.createJoinRowSet();
        jrs.addRowSet(studentRS, "SID");
        jrs.addRowSet(enrollmentRS, "SID");
        jrs.addRowSet(teacherRS, "SUBJECT");
    }
}
