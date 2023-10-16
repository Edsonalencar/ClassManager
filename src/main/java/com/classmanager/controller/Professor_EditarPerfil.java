package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class Professor_EditarPerfil implements Initializable {
	
	@FXML
	private ChoiceBox<String> ChoiceBoxUF;
	private String[] dados = {"-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxUF.getItems().addAll(dados);
		ChoiceBoxUF.setOnAction(this::getUF);
		ChoiceBoxUF.getSelectionModel().selectFirst();
	}
	
	private void getUF(ActionEvent event) {
		String Estado = ChoiceBoxUF.getValue();
		//IMPLEMENTAR NO BANCO DE DADOS: Valor no banco = Estado
	}
	
	public void telaInicio(ActionEvent event) throws Exception {
		Telas.Professor_TelaInicial();
	}
	public void telaTurma(ActionEvent event) throws Exception {
		Telas.Professor_TelaTurmas();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void perfil(ActionEvent event) throws Exception {
		Telas.Professor_EditarPerfil();
	}
	public void autenticar(ActionEvent event) throws Exception {
		Telas.Professor_TelaInicial();
	}
}
