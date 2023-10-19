package com.classmanager.controller;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Gerente_ShowTurma implements Initializable {
    public void telaProfessor(ActionEvent event) throws Exception {
        Telas.Gerente_TelaProfessores();
    }
    public void telaDisciplina(ActionEvent event) throws Exception {
        Telas.Gerente_TelaDisciplina();
    }
    public void telaInicio(ActionEvent event) throws Exception {
        Telas.Gerente_TelaInicial();
    }
    public void telaTurma(ActionEvent event) throws Exception {
        Telas.Gerente_TelaTurmas();
    }
    public void logout(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
    public void telaAluno(ActionEvent event) throws Exception {
        Telas.Gerente_TelaAlunos();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
