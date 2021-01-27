/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ezgih
 */
public class Dao {

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String password = "1234";
                String user = "postgres";
                String url = "jdbc:postgresql://localhost/school";
                this.connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
        return connection;
    }

}
