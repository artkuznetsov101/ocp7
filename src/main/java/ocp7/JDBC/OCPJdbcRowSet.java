package ocp7.JDBC;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

class OCPJdbcRowSet {
    public static void main(String[] args) {
        JdbcRowSet jdbcRS = null;
        try {
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            jdbcRS = rowSetFactory.createJdbcRowSet();
            jdbcRS.setUrl("jdbc:postgresql://localhost/testdb");
            jdbcRS.setUsername("postgres");
            jdbcRS.setPassword("12736");
            jdbcRS.setCommand("SELECT * FROM book");
            jdbcRS.execute();
            while (jdbcRS.next()) {
                System.out.print(jdbcRS.getString("id") + "-");
                System.out.print(jdbcRS.getString("title") + "-");
                System.out.print(jdbcRS.getString("unit_price"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                jdbcRS.close();
            } catch (SQLException e) {
            }
        }
    }
}
