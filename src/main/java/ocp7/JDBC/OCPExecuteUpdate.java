package ocp7.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class OCPExecuteUpdate {
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

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/testdb", prop); Statement statement = connection.createStatement()) {
            //int result = statement.executeUpdate("CREATE TABLE book " + " (id INT PRIMARY KEY, " + " title VARCHAR(1000), " + " author CHAR(255), " + " publication_year INT, " + " unit_price REAL)");
            //int result = statement.executeUpdate("INSERT INTO book VALUES (1, 'Expert In Java', 'Mantheakis', 2009, 59.9)");
            //int result = statement.executeUpdate("UPDATE book " + "SET unit_price = 99.9 " + "WHERE title = 'Expert In Java'");
            int result = statement.executeUpdate("DELETE FROM book " + "WHERE publication_year < 1900");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
