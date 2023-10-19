package com.classmanager.DAO;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.enums.RoleType;
import com.classmanager.model.Address;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;
import com.classmanager.model.Usuario;

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
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Student register(Student student) {
        String sql = "INSERT INTO student (name, code, address_id, usuario_id) VALUES (?, ?, ?, ?)";

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

            Usuario user = new Usuario(student.getUser().getLogin(),student.getUser().getSenha() ,RoleType.STUDENT);
            Usuario newUser = usuarioDAO.register(user);

            pstmt.setLong(3, student.getAddress().getId());
            pstmt.setLong(4, newUser.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    student.setId((long) generatedId);
                    student.setUser(newUser);
                }

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, code = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCode());
            pstmt.setLong(3, student.getId());

            addressDAO.update(student.getAddress());
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

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getById(Long id) {
        Student student = new Student();
        String sql = "SELECT * FROM student WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                Usuario user = usuarioDAO.getById(rs.getLong("usuario_id"));

                student.setAddress(address);
                student.setUser(user);

                return  student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student findStudentsByUser(Usuario user) {
        Student student = new Student();
        String sql = "SELECT * FROM student WHERE usuario_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, user.getUserId());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                student.setAddress(address);
                student.setUser(user);

                return  student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Student> findStudentsByClass(long id) {
        ArrayList<Student>  students = new ArrayList<>();
        String sql = "SELECT student_id FROM student_class WHERE class_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = getById(rs.getLong("student_id"));
                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Student> findStudentsByNameOrCode(String name, String code) {
        ArrayList<Student>  students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE name LIKE ? OR code LIKE ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, "%" + code + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getString("code"));

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}

