package dao;

import java.sql.*;

public class DataBase {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc_test";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "admin";

    private static Connection connection;

    public static void init() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    public static Connection get() throws SQLException {
        if (connection == null)
            init();

        return connection;
    }

}
