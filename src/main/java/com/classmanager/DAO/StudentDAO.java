package com.classmanager.DAO;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Address;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO {
    private Connection con = getConection();
    private AddressDAO addressDAO = new AddressDAO();

    public Student register(Student student) {
        String sql = "INSERT INTO student (name, code, address_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCode());

            Address studentAddres = student.getAddress();
            int addresId = addressDAO.getAddressIdIfExists(studentAddres);

            if (addresId >=0) {
                studentAddres.setId((long) addresId);
                student.setAddress(studentAddres);
            }
            else student.setAddress(addressDAO.create(student.getAddress()));

            pstmt.setLong(3, student.getAddress().getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    student.setId((long) generatedId);
                    return student;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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

    public List<Student>  getAll() {
        String sql = "SELECT * FROM student;";
        List<Student> students = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                student.setAddress(address);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student>  getByCode(String code) {
        String sql = "SELECT * FROM student WHERE code LIKE ?;";
        List<Student> students = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + code + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                student.setAddress(address);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> findStudentsByClass(Long classId) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.* FROM student s " +
                "INNER JOIN student_class sc ON s.id = sc.student_id " +
                "WHERE sc.class_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, classId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                student.setAddress(address);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> findStudentsByName(String studentName) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + studentName + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                student.setAddress(address);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}

