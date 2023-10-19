package com.classmanager.controller;

import static java.lang.System.out;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.DAO.TeacherDAO;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Gerente_CadastrarTurma implements Initializable {
	
	public StudentDAO daoAlunos = new StudentDAO();
	public TeacherDAO daoProfessores = new TeacherDAO();
	public DisciplineDAO daoDisciplinas = new DisciplineDAO();
	private String traço = "-";
	private String nomeAluno = "";
	private String nomeDisciplina = "";
	List<Student> Alunos = daoAlunos.getAll();
	ObservableList<String> nomesObs = FXCollections.observableArrayList();{
		nomesObs.add(traço);
		for (Student s : Alunos) {
		String n = s.getName();
		nomesObs.add(n);
	}
	}
	List<Discipline> Disciplinas = daoDisciplinas.getAll();
	ObservableList<String> disciplinasObs = FXCollections.observableArrayList();{
		disciplinasObs.add(traço);
		for (Discipline d : Disciplinas) {
		String x = d.getName();
		disciplinasObs.add(x);
	}
	}
	
	@FXML private TableView<Student> TabelaParticipantes;
	@FXML private TableColumn<Student, String> ColunaNome;
	@FXML private TableColumn<Student, String> ColunaMatricula;
	@FXML private ChoiceBox<String> ChoiceBoxParticipantes;
	@FXML private ChoiceBox<String> ChoiceBoxProfessores;
	@FXML private ChoiceBox<String> ChoiceBoxDisciplina;	
	
	ObservableList<Student> lista = FXCollections.observableArrayList();
	ObservableList<Student> todos = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxDisciplina.getItems().addAll(disciplinasObs);
		ChoiceBoxDisciplina.setOnAction(this::getDiscChoiceBox);
		ChoiceBoxDisciplina.getSelectionModel().selectFirst();
		ChoiceBoxParticipantes.getItems().addAll(nomesObs);
		ChoiceBoxParticipantes.setOnAction(this::getPartChoiceBox);
		ChoiceBoxParticipantes.getSelectionModel().selectFirst();
		
		try{
			ColunaNome.setCellValueFactory(new PropertyValueFactory<>("name"));
			ColunaMatricula.setCellValueFactory(new PropertyValueFactory<>("code"));
		}
		catch(Exception e){
	        e.printStackTrace();
	        out.println("Erro aqui.");
	    }
		
		List<Student> alunos = new ArrayList<>();
	    try{
	    	alunos = daoAlunos.getAll();
			for(Student d : alunos ) {
				String nomeAlterar = d.getName();
				String Capitalizado = Arrays.stream(nomeAlterar.split(" "))
		                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
		                .collect(Collectors.joining(" "));
		        System.out.println(Capitalizado);
		        d.setName(Capitalizado);
			}
	    }catch(Exception e){
	        e.printStackTrace();
	        out.println("Error on Building Data");
	    }
	    if (alunos != null) {
	    	lista.addAll(alunos);
	    	TabelaParticipantes.setItems(lista);
	    	System.out.println("Chegou aqui");
	    	todos.addAll(alunos);
	    }
	    else {
	    	System.out.println("Erro.");
	    }
	    
	}
	
	
	private void getPartChoiceBox(ActionEvent event) {
		String Participante = ChoiceBoxParticipantes.getValue();
		nomeAluno = Participante;
	}
	private void getDiscChoiceBox(ActionEvent event) {
		String Disciplina = ChoiceBoxDisciplina.getValue();
		nomeDisciplina = Disciplina;
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
