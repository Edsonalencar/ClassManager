package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Gerente_CadastrarTurma implements Initializable {
	
	@FXML
	private ChoiceBox<String> ChoiceBoxParticipantes;
	private ChoiceBox<String> ChoiceBoxProfessores;
	private ChoiceBox<String> ChoiceBoxDisciplinas;
	private String[] alunos = {"-"}; //ATUALIZAR O VETOR COM OS ALUNOS NO BANCO DE DADOS
	private String[] professores = {"-"}; //ATUALIZAR O VETOR COM OS PROFESSORES NO BANCO DE DADOS
	private String[] disciplinas = {"-"}; //ATUALIZAR O VETOR COM AS DISCIPLINAS NO BANCO DE DADOS
	
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxParticipantes.getItems().addAll(alunos);
		ChoiceBoxParticipantes.setOnAction(this::getAluno);
		ChoiceBoxParticipantes.getSelectionModel().selectFirst();
		
		//ChoiceBoxProfessores.getItems().addAll(professores);
		//ChoiceBoxProfessores.setOnAction(this::getProfessor);
		//ChoiceBoxProfessores.getSelectionModel().selectFirst();
		
		//ChoiceBoxDisciplinas.getItems().addAll(disciplinas);
		//ChoiceBoxDisciplinas.setOnAction(this::getDisciplina);
		//ChoiceBoxDisciplinas.getSelectionModel().selectFirst();
	}
	
	private void getAluno(ActionEvent event) {
		String al = ChoiceBoxParticipantes.getValue();
		//IMPLEMENTAR NO BANCO DE DADOS: Valor no banco = al
	}
	
	private void getProfessor(ActionEvent event) {
		String prof = ChoiceBoxProfessores.getValue();
		//IMPLEMENTAR NO BANCO DE DADOS: Valor no banco = prof
	}
	
	private void getDisciplina(ActionEvent event) {
		String disc = ChoiceBoxDisciplinas.getValue();
		//IMPLEMENTAR NO BANCO DE DADOS: Valor no banco = disc
	}
	
	public void telaProfessor(ActionEvent event) throws Exception {
		Telas.Gerente_TelaProfessores();
	}
	public void telaTurma(ActionEvent event) throws Exception {
		Telas.Gerente_TelaTurmas();
	}
	public void telaAluno(ActionEvent event) throws Exception {
		Telas.Gerente_TelaAlunos();
	}
	public void telaInicio(ActionEvent event) throws Exception {
		Telas.Gerente_TelaInicial();
	}
	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
	}
	public void logout(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	public void autenticar(ActionEvent event) throws Exception {
		Telas.Gerente_TelaInicial();
	}

}
