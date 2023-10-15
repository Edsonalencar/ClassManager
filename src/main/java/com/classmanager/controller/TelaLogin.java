package com.classmanager.controller;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLogin {
    @FXML private Label erro;
    @FXML private TextField login;
    @FXML private PasswordField senha;
    @FXML private String url;

    public void autenticar(ActionEvent event) throws Exception{
        System.out.println("Chegou na tela de login!");
        System.out.println("Login: " + login.getText());
        System.out.println("Senha: " + senha.getText());

        if(login.getText().equals("1")){
            Telas.Gerente_TelaInicial();
        } else if (login.getText().equals("2")) {
            Telas.Professor_TelaInicial();
        }
        else {
            Telas.Aluno_TelaInicial();
        }
    }
}
