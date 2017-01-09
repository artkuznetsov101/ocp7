package ocp7.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

class OCPPreparedStatement {
    public static void main(String[] args) {

        //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream is = classloader.getResourceAsStream("dbpass.properties");

        Properties prop = new Properties();
        FileInputStream stream;
        try {
            stream = new FileInputStream("dbpass.properties");
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/testdb", prop);
                PreparedStatement bookUpdStmt = connection.prepareStatement("UPDATE book SET " + "unit_price = ? WHERE id = ?");
                PreparedStatement bookNewPrStmt = connection.prepareStatement("SELECT id, unit_price FROM new_book_price")) {

            ResultSet bookNewPrRs = bookNewPrStmt.executeQuery();
            while (bookNewPrRs.next()) {
                bookUpdStmt.setDouble(1, bookNewPrRs.getDouble("unit_price"));
                bookUpdStmt.setString(2, bookNewPrRs.getString("id"));
                bookUpdStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
