package ocp7.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

class GoodStudentsFilter implements Predicate {
    double level;

    public GoodStudentsFilter(double gpa) {
        level = gpa;
    }

    public boolean evaluate(RowSet rs) {
        System.out.println("GSF.evaluate called ");
        try {
            if (!rs.isAfterLast()) {
                double gpa = rs.getDouble(3);
                System.out.println(" gpa = " + gpa);
                return gpa > this.level;
            } else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean evaluate(Object value, int column) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean evaluate(Object value, String columnName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}

public class OCPFilteredRowSet {

    public static void main(String[] args) throws Exception {

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
        FilteredRowSet studentRS = rsf.createFilteredRowSet();
        studentRS.setCommand("select * from \"STUDENT\"");
        studentRS.execute(c);
        studentRS.setFilter(new GoodStudentsFilter(4));
        dumpRS(studentRS);
    }

    public static void dumpRS(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = rs.getMetaData();
        int cc = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= cc; i++) {
                System.out.print(rsmd.getColumnLabel(i) + " = " + rs.getObject(i) + " ");
            }
            System.out.println("");
        }

    }
}
