package com.classmanager;

import com.classmanager.DAO.*;
import com.classmanager.enums.DisciplineStatus;
import com.classmanager.enums.RoleType;
import com.classmanager.model.*;

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
        UsuarioDAO userDAO = new UsuarioDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

        Address address = new Address("Mossoró", "RN", "Alto de são manoel", 141);
        Usuario user = new Usuario("Umberto85", "123");

        Student student = new Student("Karoline", "2022010599", address, user);
        Student registerStudent = studentDAO.register(student);

        System.out.println(registerStudent);
        System.out.println(studentDAO.getAll());
    }
}
