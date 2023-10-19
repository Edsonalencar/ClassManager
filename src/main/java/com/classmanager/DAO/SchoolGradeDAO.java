package com.classmanager.DAO;

import com.classmanager.model.Class;
import com.classmanager.model.Frequency;
import com.classmanager.model.SchoolGrade;
import com.classmanager.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolGradeDAO extends BaseDAO {
    private Connection con = getConection();
    private StudentDAO studentDAO = new StudentDAO();
    private ClassDAO classDAO = new ClassDAO();

    public SchoolGrade register(SchoolGrade schoolGrade) {
        String sql = "INSERT INTO school_grade (grade, period, student_id, class_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, schoolGrade.getGrade());
            pstmt.setString(2, schoolGrade.getPeriod());
            pstmt.setLong(3, schoolGrade.getStudent().getId());
            pstmt.setLong(4, schoolGrade.getaClass().getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    schoolGrade.setId((long) generatedId);
                }

                return schoolGrade;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(SchoolGrade schoolGrade) {
        String sql = "UPDATE school_grade SET grade = ?, period = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, schoolGrade.getGrade());
            pstmt.setString(2, schoolGrade.getPeriod());
            pstmt.setLong(3, schoolGrade.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM school_grade WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SchoolGrade getById(Long id) {
        String sql = "SELECT * FROM school_grade WHERE id = ?";
        SchoolGrade schoolGrade = new SchoolGrade();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                schoolGrade.setId(rs.getLong("id"));
                schoolGrade.setGrade(rs.getInt("grade"));
                schoolGrade.setPeriod(rs.getString("period"));

                Student student = studentDAO.getById(rs.getLong("student_id"));
                Class aclass = classDAO.getById(rs.getLong("class_id"));

                schoolGrade.setStudent(student);
                schoolGrade.setaClass(aclass);

                return schoolGrade;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SchoolGrade> getByStudentId(Long id) {
        String sql = "SELECT * FROM school_grade WHERE student_id = ?";
        List<SchoolGrade>  schoolGrades = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                SchoolGrade schoolGrade = new SchoolGrade();

                schoolGrade.setId(rs.getLong("id"));
                schoolGrade.setGrade(rs.getInt("grade"));
                schoolGrade.setPeriod(rs.getString("period"));


                Student student = studentDAO.getById(rs.getLong("student_id"));
                Class aclass = classDAO.getById(rs.getLong("class_id"));

                schoolGrade.setStudent(student);
                schoolGrade.setaClass(aclass);

                schoolGrades.add(schoolGrade);
            }
            return schoolGrades;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SchoolGrade> getByClassId(Long id) {
        String sql = "SELECT * FROM school_grade WHERE class_id = ?";
        List<SchoolGrade>  schoolGrades = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                SchoolGrade schoolGrade = new SchoolGrade();

                schoolGrade.setId(rs.getLong("id"));
                schoolGrade.setGrade(rs.getInt("grade"));
                schoolGrade.setPeriod(rs.getString("period"));


                Student student = studentDAO.getById(rs.getLong("student_id"));
                Class aclass = classDAO.getById(rs.getLong("class_id"));

                schoolGrade.setStudent(student);
                schoolGrade.setaClass(aclass);

                schoolGrades.add(schoolGrade);
            }
            return schoolGrades;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
