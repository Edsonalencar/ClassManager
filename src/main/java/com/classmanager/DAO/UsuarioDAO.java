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

    public List<Usuario> buscar (String login, String senha) {
        String sql = "SELECT senha FROM usuario WHERE login=?";
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if(!rs.isBeforeFirst()){
                System.out.println("Usuario nao encontrado!");
            }
            else {
                while (rs.next()) {
                    String senhaD = rs.getString("senha");
                    if(senhaD.equals(senha)) {
                        System.out.println("Senha correta!");
                        Usuario usuario = new Usuario();
                        usuario.setLogin(rs.getString("login"));
                        usuario.setSenha(rs.getString("senha"));

                        usuarios.add(usuario);
                    }
                    else {
                        System.out.println("Senha inválida!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
