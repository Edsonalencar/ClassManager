package com.classmanager.controller;

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
    @FXML private PasswordField CampoSenha;
    private List<Usuario> usu;

    

    public void autenticar(ActionEvent event) throws Exception{
        System.out.println("Chegou na tela de login!");
        System.out.println("Login: " + CampoUsuario.getText());
        System.out.println("Senha: " + CampoSenha.getText());

        UsuarioDAO usuario = new UsuarioDAO();
        usu = usuario.buscar(CampoUsuario.getText(), CampoSenha.getText());

        for (Usuario u : usu){
            if(u.getLogin().equals("1")){
                Telas.Gerente_TelaInicial();
            } else if (u.getLogin().equals("2")) {
                Telas.Professor_TelaInicial();
            } else if (u.getLogin().equals("3")) {
                Telas.Aluno_TelaInicial();
            }
            else {
                LabelErro.setVisible(true);
            }
        }

    }


}
