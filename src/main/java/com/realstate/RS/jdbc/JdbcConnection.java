package com.realstate.RS.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/real_estate_db";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "sujata03";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    public static void closeConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(
                        "Error closing database connection: "
                        + e.getMessage()
                );
            }
        }
    }
}