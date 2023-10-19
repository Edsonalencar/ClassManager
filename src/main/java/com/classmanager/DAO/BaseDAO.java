package com.classmanager.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    Connection con = null;
    private  String url = "jdbc:postgresql://localhost:5432/classmanager";
    private String user = "postgres";
    private String password = "postgres";

    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    public  Connection getConection () {
        if (con == null) {
            try {
                this.con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return  this.con;
    }
}
