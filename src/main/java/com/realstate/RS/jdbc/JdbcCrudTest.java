package com.realstate.RS.jdbc;

public class JdbcCrudTest {

    public static void main(String[] args) {

        JdbcPropertyDAO dao = new JdbcPropertyDAO();

        System.out.println("===== JDBC CRUD TEST =====");

        // UPDATE test
        // ID 999999 normally exist nahi karegi,
        // isliye existing data change nahi hoga.
        boolean updated =
                dao.updateProperty(999999L, 99999);

        System.out.println(
                "Update result: " + updated
        );

        // DELETE test
        // Same non-existing ID, so existing property delete nahi hogi.
        boolean deleted =
                dao.deleteProperty(999999L);

        System.out.println(
                "Delete result: " + deleted
        );

        System.out.println("==========================");
    }
}