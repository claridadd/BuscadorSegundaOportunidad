package com.example.buscadorsegundaoportunidad.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD
{
    public static Connection connection = null;
    public static Connection getConnection()
    {
        String dbName = "odoo";
        String dbPort = "5432";
        String username = "odoo";
        String password = "odoo";

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:" + dbPort + "/" + dbName + "?user=" + username + "&password=" + password;
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return connection;
    }
}
