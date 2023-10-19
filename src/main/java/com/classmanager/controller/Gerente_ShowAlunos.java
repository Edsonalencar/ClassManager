package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Gerente_ShowAlunos implements Initializable {
	
	@FXML private Label LabelNome;
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
		LabelNome.setText("2");
		
	}
		
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
}
