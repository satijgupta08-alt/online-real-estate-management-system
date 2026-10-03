package com.realstate.RS.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcPropertyDAO {

    // CREATE - Add a property using JDBC
    public boolean addProperty(
            String title,
            String address,
            String city,
            double price) {

        String sql = """
                INSERT INTO properties
                (title, address, city, price, available)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, address);
            statement.setString(3, city);
            statement.setDouble(4, price);
            statement.setBoolean(5, true);

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(
                    "JDBC Insert Error: " + e.getMessage()
            );

            return false;
        }
    }

    // READ - Get all properties using JDBC
    public List<String> getAllProperties() {

        List<String> properties = new ArrayList<>();

        String sql = """
                SELECT id, title, address, city, price
                FROM properties
                """;

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String property =
                        "ID: " + resultSet.getLong("id")
                        + " | Title: " + resultSet.getString("title")
                        + " | Address: " + resultSet.getString("address")
                        + " | City: " + resultSet.getString("city")
                        + " | Price: " + resultSet.getDouble("price");

                properties.add(property);
            }

        } catch (Exception e) {

            System.out.println(
                    "JDBC Read Error: " + e.getMessage()
            );
        }

        return properties;
    }

    // UPDATE - Update property price using JDBC
    public boolean updateProperty(
            long id,
            double newPrice) {

        String sql = """
                UPDATE properties
                SET price = ?
                WHERE id = ?
                """;

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setDouble(1, newPrice);
            statement.setLong(2, id);

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(
                    "JDBC Update Error: " + e.getMessage()
            );

            return false;
        }
    }

    // DELETE - Delete a property using JDBC
    public boolean deleteProperty(long id) {

        String sql = """
                DELETE FROM properties
                WHERE id = ?
                """;

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(
                    "JDBC Delete Error: " + e.getMessage()
            );

            return false;
        }
    }
}