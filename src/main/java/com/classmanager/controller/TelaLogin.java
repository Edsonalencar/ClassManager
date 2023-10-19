package com.classmanager.controller;

import com.classmanager.enums.RoleType;
import com.classmanager.model.Student;
import com.classmanager.model.Teacher;
import com.classmanager.model.Usuario;
import com.classmanager.view.Telas;
import com.classmanager.DAO.UsuarioDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaLogin {
    @FXML private Label LabelErro;
    @FXML private TextField CampoUsuario;
    @FXML private TextField CampoSenha;


    public void autenticar(ActionEvent event) throws Exception{
        System.out.println("Chegou na tela de login!");
        System.out.println("Login: " + CampoUsuario.getText());
        System.out.println("Senha: " + CampoSenha.getText());

        UsuarioDAO usu = new UsuarioDAO();
        Usuario user = usu.loginUser(CampoUsuario.getText(), CampoSenha.getText());

        if (user == null) {
            LabelErro.setVisible(true);
        }
        else {
            if(user.getRole() == RoleType.ADMIN){
                Telas.Gerente_TelaInicial();
            }
            else if (user.getRole() == RoleType.TEACHER) {
                Telas.Professor_TelaInicial();
            }
            else {
                Telas.Aluno_TelaInicial();
            }
        }
    }
}
