package com.classmanager.controller;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaLogin {
    @FXML private Label LabelErro;
    @FXML private TextField CampoUsuario;
    @FXML private TextField CampoSenha;


    public void autenticar(ActionEvent event) throws Exception{
        System.out.println("Chegou na tela de login!");
        System.out.println("Login: " + CampoUsuario.getText());
        System.out.println("Senha: " + CampoSenha.getText());

        if(CampoUsuario.getText().equals("1")){
            Telas.Gerente_TelaInicial();
        } else if (CampoUsuario.getText().equals("2")) {
            Telas.Professor_TelaInicial();
        }
        else {
            Telas.Aluno_TelaInicial();
        }
    }
}
