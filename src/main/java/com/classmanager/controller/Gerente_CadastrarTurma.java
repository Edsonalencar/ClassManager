package com.classmanager.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.DAO.TeacherDAO;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Gerente_CadastrarTurma implements Initializable {
	
	StudentDAO daoAlunos = new StudentDAO();
	TeacherDAO daoProfessores = new TeacherDAO();
	DisciplineDAO daoDisciplinas = new DisciplineDAO();
	private String traço = "-";
	private String nome = "";

	@FXML private ChoiceBox<String> ChoiceBoxParticipantes;
	@FXML private ChoiceBox<String> ChoiceBoxProfessores;
	@FXML private ChoiceBox<String> ChoiceBoxDisciplinas;
	
	List<Student> Alunos = daoAlunos.getAll();{
	List<String> nomesParticipantes = new ArrayList<String>();
	nomesParticipantes.add(traço);
	for (Student s : Alunos) {
		nomesParticipantes.add(s.getName());
	}
	
	}
	private void getPartChoiceBox(ActionEvent event) {
		String Participante = ChoiceBoxParticipantes.getValue();
		nome = Participante;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		//ChoiceBoxParticipantes.getItems().addAll(nomesParticipantes);
		ChoiceBoxParticipantes.setOnAction(this::getPartChoiceBox);
		ChoiceBoxParticipantes.getSelectionModel().selectFirst();
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
