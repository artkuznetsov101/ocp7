package ocp7.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

class OCPCallableStatement {
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
                PreparedStatement statement = connection
                        .prepareStatement("CREATE OR REPLACE FUNCTION my_insert(id INT, title VARCHAR(70)) RETURNS void AS $$ BEGIN INSERT INTO book VALUES (id, title); END; $$ LANGUAGE plpgsql;")) {

            int result = statement.executeUpdate();
            System.out.println(result);

            CallableStatement cs = connection.prepareCall("{call my_insert(3, 'test')}");
            int rs = cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
