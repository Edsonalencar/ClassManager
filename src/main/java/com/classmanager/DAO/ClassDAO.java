package com.classmanager.DAO;

import com.classmanager.model.Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends BaseDAO {
    private Connection con = getConection();

    public List<Class> findClassByStudent(String studentName) {
        List<Class> classes = new ArrayList<>();

        String sql = "SELECT c.* FROM class c " +
                "INNER JOIN student s ON c.id = s.class_id " +
                "WHERE s.name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, studentName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();

                classes.add(aClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public List<Class> findClassByTeacher(String teacherName) {
        List<Class> classes = new ArrayList<>();

        String sql = "SELECT c.* FROM class c " +
                "INNER JOIN teacher t ON c.teacher_id = t.id " +
                "WHERE t.name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacherName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();
                // Preencher o objeto 'aClass' com os dados da consulta


                classes.add(aClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public List<Class> findClassByDiscipline(String disciplineName) {
        List<Class> classes = new ArrayList<>();

        String sql = "SELECT c.* FROM class c " +
                "INNER JOIN discipline d ON c.discipline_id = d.id " +
                "WHERE d.name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, disciplineName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();
                // Preencher o objeto 'aClass' com os dados da consulta

                classes.add(aClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }
}
