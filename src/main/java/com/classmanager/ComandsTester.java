package com.classmanager;

import com.classmanager.DAO.*;
import com.classmanager.enums.DisciplineStatus;
import com.classmanager.enums.RoleType;
import com.classmanager.model.Address;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;
import com.classmanager.model.Usuario;

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

        Address address = new Address("Mossoró", "RN", "Centro", 89);
        Usuario user = new Usuario("edson", "pedro789");
        Student student = new Student("Edson Alencar", "201710802660", address, user);

        Usuario login = userDAO.loginUser(user.getLogin(), user.getSenha());
        System.out.println(studentDAO.findStudentsByUser(login));
    }
}
