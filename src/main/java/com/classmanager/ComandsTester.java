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

        Address address = new Address("Mossoró", "RN", "Centro", 89);
        Usuario user = new Usuario("Professor_28", "123456");
        Teacher teacher = new Teacher("Edson Alencar Professor", "13046133480", address, user);

        Teacher newTeacher = teacherDAO.register(teacher);

        System.out.println(newTeacher);
    }
}
