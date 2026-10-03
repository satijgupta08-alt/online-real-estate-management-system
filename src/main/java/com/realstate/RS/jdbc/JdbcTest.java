package com.realstate.RS.jdbc;

import java.util.List;

public class JdbcTest {

    public static void main(String[] args) {

        JdbcPropertyDAO dao = new JdbcPropertyDAO();

        List<String> properties = dao.getAllProperties();

        System.out.println("===== JDBC PROPERTY DATA =====");

        for (String property : properties) {
            System.out.println(property);
        }

        System.out.println("==============================");
    }
}