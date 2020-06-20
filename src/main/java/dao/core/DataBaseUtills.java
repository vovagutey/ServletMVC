package dao.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtills {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://devohost.mysql.tools:3306/devohost_hutey";
    private static String login = "devohost_hutey";
    private static String password = "^j89L5z;yB";


    public static Connection createConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        return DriverManager.getConnection(url, login, password);
    }
}
