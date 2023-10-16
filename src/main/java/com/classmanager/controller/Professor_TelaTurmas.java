package com.classmanager.controller;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Professor_TelaTurmas {
	
	public void telaInicio(ActionEvent event) throws Exception {
		Telas.Professor_TelaInicial();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void perfil(ActionEvent event) throws Exception {
		Telas.Professor_EditarPerfil();
	}

}
