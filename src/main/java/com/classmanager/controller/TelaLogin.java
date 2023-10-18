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


    public void autenticar(ActionEvent event) throws Exception{
        System.out.println("Chegou na tela de login!");
        System.out.println("Login: " + CampoUsuario.getText());
        System.out.println("Senha: " + CampoSenha.getText());

        UsuarioDAO usuario = new UsuarioDAO();
        List<Usuario> usu;
        usu = usuario.buscar();


        for (Usuario u : usu){
            if(CampoUsuario.getText().equals(u.getLogin()) && CampoSenha.getText().equals(u.getSenha())){
                if(CampoUsuario.getText().equals("Diretor")){
                    Telas.Gerente_TelaInicial();
                } else if (CampoUsuario.getText().equals("0000")) {
                    Telas.Professor_TelaInicial();
                } else if (CampoUsuario.getText().equals("1111")) {
                    Telas.Aluno_TelaInicial();
                }
            }
            else {
                LabelErro.setVisible(true);
            }
        }

    }


}
