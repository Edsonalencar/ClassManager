package com.classmanager;

import com.classmanager.DAO.BaseDAO;
import java.sql.Connection;

public class ComandsTester {
    public static void main(String[] args) {
        BaseDAO baseDAO = new BaseDAO();
        Connection con = baseDAO.getConection();

        System.out.println(con);
    }
}
