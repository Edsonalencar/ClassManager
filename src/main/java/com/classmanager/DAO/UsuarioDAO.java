package com.classmanager.DAO;

import com.classmanager.enums.RoleType;
import com.classmanager.exceptions.UserExistsException;
import com.classmanager.model.Address;
import com.classmanager.model.Student;
import com.classmanager.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
public class UsuarioDAO extends BaseDAO{
    private Connection con = getConection();
    public Usuario register(Usuario usuario) {
        String sql = "INSERT INTO usuario (login, senha, role) VALUES (?, ?, ?);";

        if (getUserByLogin(usuario.getLogin()) != null)
            throw new UserExistsException("Usuário existente!.");

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getRole().toString());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    usuario.setUserId((long) generatedId);

                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }
    public void update(Usuario usuario) {
        String sql = "UPDATE usuario SET login = ?, senha = ?, role = ? WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getRole().toString());
            pstmt.setLong(4, usuario.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(Long id) {
        String sql = "DELETE FROM usuario WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAll () {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setUserId(rs.getLong("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setRole(RoleType.valueOf(rs.getString("role")));

                usuarios.add(u);
            }

            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario getById(Long id) {
        String sql = "SELECT * FROM usuario WHERE id = ?;";
        Usuario user = new Usuario();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setRole(RoleType.valueOf(rs.getString("role")));

               return  user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario getUserByLogin(String login) {
        String sql = "SELECT * FROM usuario WHERE login = ?;";
        Usuario user = new Usuario();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setRole(RoleType.valueOf(rs.getString("role")));

                return  user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario loginUser(String login, String senha) {
        Usuario user = getUserByLogin(login);

        if (user != null && user.getSenha().equals(senha))
            return user;

        return null;
    }
}
