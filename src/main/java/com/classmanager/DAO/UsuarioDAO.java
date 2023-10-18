package com.classmanager.DAO;

import com.classmanager.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDAO{
    private Connection con = getConection();
    public void register(Usuario usuario) {
        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?);";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Usuario usuario) {
        String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setLong(3, usuario.getId());

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

    public List<Usuario> buscar () {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                usuarios.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
