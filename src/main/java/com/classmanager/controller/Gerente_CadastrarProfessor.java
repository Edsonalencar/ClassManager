package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Gerente_CadastrarProfessor implements Initializable {
	
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
		Telas.Gerente_TelaInicial();
	}
	public void telaProfessor(ActionEvent event) throws Exception {
		Telas.Gerente_TelaProfessores();
	}
	public void telaAluno(ActionEvent event) throws Exception {
		Telas.Gerente_TelaAlunos();
	}
	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
	}
	public void telaTurma(ActionEvent event) throws Exception {
		Telas.Gerente_TelaTurmas();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void autenticar(ActionEvent event) throws Exception {
		Telas.Gerente_TelaInicial();
	}
}
