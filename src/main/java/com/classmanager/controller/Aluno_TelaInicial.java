package com.classmanager.controller;

import com.classmanager.view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class Aluno_TelaInicial {
	
	public void telaTurma(ActionEvent event) throws Exception {
		Telas.Aluno_TelaTurmas();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void perfil(ActionEvent event) throws Exception {
		Telas.Aluno_EditarPerfil();
	}
	
}
