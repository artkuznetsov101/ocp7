package ocp7.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class OCPExecuteQuery {
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
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM book " + "WHERE unit_price > 47.7");) {

            ResultSetMetaData resultMetaData = result.getMetaData();
            for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
                System.out.println(resultMetaData.getColumnLabel(i));
            }

            while (result.next()) {
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("title"));
                System.out.println(result.getString("author"));
                System.out.println(result.getInt("publication_year"));
                System.out.println(result.getDouble("unit_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}