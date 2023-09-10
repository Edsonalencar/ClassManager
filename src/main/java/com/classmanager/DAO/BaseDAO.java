package com.classmanager.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    Connection con = null;
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";


    public  Connection getConection () {
        if (con == null) {
            try {
                this.con = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return  this.con;
    }
}
