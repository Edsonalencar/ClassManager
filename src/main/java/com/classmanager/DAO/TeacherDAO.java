package com.classmanager.DAO;

import com.classmanager.model.Teacher;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Teacher teacher) {
        String sql = "INSERT INTO teacher (name, cpf, address_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getCPF());
            pstmt.setInt(3, teacher.getAddress().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Teacher teacher) {
        String sql = "UPDATE teacher SET name = ?, cpf = ?, address_id = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getCPF());
            pstmt.setInt(3, teacher.getAddress().getId());
            pstmt.setInt(4, teacher.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerClass(int teacherId, int classId) {
        String sql = "INSERT INTO teacher_class (teacher_id, class_id) VALUES (?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, teacherId);
            pstmt.setInt(2, classId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClass(int teacherId, int classId) {
        String sql = "DELETE FROM teacher_class WHERE teacher_id = ? AND class_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, teacherId);
            pstmt.setInt(2, classId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Teacher findTeacherByClass(int classId) {
        String sql = "SELECT t.* FROM teacher t " +
                "INNER JOIN teacher_class tc ON t.id = tc.teacher_id " +
                "WHERE tc.class_id = ?";
        Teacher teacher = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCPF(rs.getString("cpf"));
                // Preencher o objeto Teacher com od outros atributos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }

    public Teacher findTeacherByName(String teacherName) {
        String sql = "SELECT * FROM teacher WHERE name = ?";
        Teacher teacher = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacherName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCPF(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }
}

