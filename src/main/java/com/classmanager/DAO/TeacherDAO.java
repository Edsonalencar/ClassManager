package com.classmanager.DAO;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.enums.RoleType;
import com.classmanager.model.Address;
import com.classmanager.model.Class;
import com.classmanager.model.Discipline;
import com.classmanager.model.Teacher;
import com.classmanager.model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO extends BaseDAO {
    private Connection con = getConection();
    private AddressDAO addressDAO = new AddressDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ClassDAO classDAO = new ClassDAO();

    public Teacher register(Teacher teacher) {
        String sql = "INSERT INTO teacher (name, cpf, address_id, usuario_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getCPF());

            Address studentAddres = teacher.getAddress();
            int addresId = addressDAO.getAddressIdIfExists(studentAddres);

            if (addresId >=0) {
                studentAddres.setId((long) addresId);
                teacher.setAddress(studentAddres);
            }
            else teacher.setAddress(addressDAO.create(teacher.getAddress()));

            Usuario user = new Usuario(teacher.getUser().getLogin(), teacher.getUser().getSenha(), RoleType.TEACHER);
            Usuario newUser = usuarioDAO.register(user);

            pstmt.setLong(3, teacher.getAddress().getId());
            pstmt.setLong(4, newUser.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    teacher.setId((long) generatedId);
                    teacher.setUser(newUser);
                }

                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Teacher teacher) {
        String sql = "UPDATE teacher SET name = ?, cpf = ?  WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getCPF());
            pstmt.setLong(3, teacher.getId());

            addressDAO.update(teacher.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Teacher getById(long id) {
        String sql = "SELECT * FROM teacher WHERE id = ?;";
        Teacher teacher = new Teacher();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1,  id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                teacher.setId(rs.getLong("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCPF(rs.getString("cpf"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                Usuario user = usuarioDAO.getById(rs.getLong("usuario_id"));

                teacher.setAddress(address);
                teacher.setUser(user);

                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Teacher> getAll() {
        String sql = "SELECT * FROM teacher;";
        List<Teacher> teachers = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher();

                teacher.setId(rs.getLong("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCPF(rs.getString("cpf"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                Usuario user = usuarioDAO.getById(rs.getLong("usuario_id"));

                teacher.setAddress(address);
                teacher.setUser(user);

                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public List<Teacher> findTeacherByName(String name) {
        String sql = "SELECT * FROM teacher WHERE name LIKE ?";
        List<Teacher> teachers = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCPF(rs.getString("cpf"));

                Address address = addressDAO.getById(rs.getLong("address_id"));
                Usuario user = usuarioDAO.getById(rs.getLong("usuario_id"));

                teacher.setAddress(address);
                teacher.setUser(user);

                teachers.add(teacher);
            }

            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

