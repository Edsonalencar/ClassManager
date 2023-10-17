package com.classmanager;

import com.classmanager.DAO.AddressDAO;
import com.classmanager.DAO.BaseDAO;
import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Address;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;

import java.sql.Connection;
import java.util.List;

public class ComandsTester {
    public static void main(String[] args) {
        BaseDAO baseDAO = new BaseDAO();
        Connection con = baseDAO.getConection();

        System.out.println(con);

        DisciplineDAO dsDao = new DisciplineDAO();
        AddressDAO addressDAO = new AddressDAO();
        StudentDAO studentDAO = new StudentDAO();

        Address address = new Address("Mossoró", "RN", "Centro", 89);
        Student student = new Student("João Eduardo", "201710802649", address);
    }
}
