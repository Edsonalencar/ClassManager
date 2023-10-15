package com.classmanager.controller;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Gerente_TelaDisciplinas {
	public void telaProfessor(ActionEvent event) throws Exception {
		Telas.Gerente_TelaProfessores();
	}
	public void telaAluno(ActionEvent event) throws Exception {
		Telas.Gerente_TelaAlunos();
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
}
 