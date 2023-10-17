package com.classmanager;

import com.classmanager.DAO.BaseDAO;
import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.model.Discipline;

import java.sql.Connection;
import java.util.List;

public class ComandsTester {
    public static void main(String[] args) {
        BaseDAO baseDAO = new BaseDAO();
        Connection con = baseDAO.getConection();

        System.out.println(con);

        DisciplineDAO dsDao = new DisciplineDAO();

        List<Discipline> listDs = dsDao.getAll();
        System.out.println(listDs);
    }
}
