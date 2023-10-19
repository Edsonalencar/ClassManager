package com.classmanager.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.model.Discipline;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Gerente_TelaInicial implements Initializable {
	
	public StudentDAO daoAlunos = new StudentDAO();
	public DisciplineDAO daoDisciplinas = new DisciplineDAO();
	Long nAlunos = (long) 0;
	Long nDisciplinas = (long) 0;
	
	@FXML private Label NumeroAlunos;
	@FXML private Label NumeroProfessores;
	@FXML private Label NumeroTurmas;
	@FXML private Label NumeroDisciplinas;	
	@FXML private TableView TabelaTurmas;
    @FXML private TableColumn ColunaTurma;
    @FXML private TableColumn ColunaDisciplina;
    @FXML private TableColumn ColunaProfessor;
    @FXML private TableColumn ColunaAulas;
    
    List<Student> alunos = daoAlunos.getAll();{
    	for(Student s : alunos ) {
    		nAlunos++;
    	}
	}
    
    List<Discipline> disciplinas = daoDisciplinas.getAll();{
    	for(Discipline s : disciplinas ) {
    		nDisciplinas++;
    	}
	}
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        NumeroAlunos.setText(""+nAlunos);
//        NumeroDisciplinas.setText(""+nDisciplinas);

    }
	
	public void autenticar(ActionEvent event) throws Exception {
		
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
	public void addAluno(ActionEvent event) throws Exception {
		Telas.Gerente_CadastrarAluno();
	}
	
}
