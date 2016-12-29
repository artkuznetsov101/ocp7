package ocp7.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class OCPCommit {
    public static void main(String[] args) {

        Properties prop = new Properties();
        FileInputStream stream;
        try {
            stream = new FileInputStream("dbpass.properties");
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/testdb", prop); Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            int insert = statement.executeUpdate("INSERT INTO book VALUES (2, 'Expert In C++', 'Kookoo', 2005, 44.9)");
            int update = statement.executeUpdate("UPDATE book " + "SET unit_price = 88.8 " + "WHERE title = 'Expert In Java'");
            //connection.commit();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
