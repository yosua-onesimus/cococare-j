package model.dao;

import java.sql.*;

public class Database {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "test", "root", "1234");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static boolean executeUpdate(String sql) {
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeUpdate(sql) > -1;
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return false;
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return null;
        }
    }
}