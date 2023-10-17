package com.classmanager.DAO;

import com.classmanager.model.Student;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Student student) {
        String sql = "INSERT INTO student (name, code, address_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCode());
            pstmt.setLong(3, student.getAddress().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, code = ?, address_id = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCode());
            pstmt.setLong(3, student.getAddress().getId());
            pstmt.setLong(4, student.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student findStudentByClass(Long classId) {
        String sql = "SELECT s.* FROM student s " +
                "INNER JOIN student_class sc ON s.id = sc.student_id " +
                "WHERE sc.class_id = ?";
        Student student = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, classId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));
                // Preencher o objeto Student com od outros atributos

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public Student findStudentByName(String studentName) {
        String sql = "SELECT * FROM student WHERE name = ?";
        Student student = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, studentName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));
                // Preencher o objeto Student com od outros atributos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<Class> findClassByDiscipline(Long disciplineId) {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT c.* FROM class c WHERE c.discipline_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, disciplineId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //Class aClass = new Class();
                //aClass.setId(rs.getLong("id"));
                //aClass.setDisciplineId(rs.getInt("discipline_id"));
                // Preencher o objeto Student com od outros atributos

                //classes.add(aClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }
}

