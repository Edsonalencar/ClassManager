package com.classmanager.controller;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Professor_TelaInicial {

	public void telaTurma(ActionEvent event) throws Exception {
		Telas.Professor_TelaTurmas();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void perfil(ActionEvent event) throws Exception {
		Telas.Professor_EditarPerfil();
	}
	
}
