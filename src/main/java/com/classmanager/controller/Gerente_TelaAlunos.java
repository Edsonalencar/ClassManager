package com.classmanager.controller;

import static java.lang.System.out;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.DAO.StudentDAO;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Gerente_TelaAlunos implements Initializable {
	
	public StudentDAO daoDados = new StudentDAO();

	@FXML 
	private TableView<Student> TabelaAlunos;
	@FXML 
	private TableColumn<Student, String> ColunaNome;
	@FXML 
	private TableColumn<Student, String> ColunaMatricula;
    
	ObservableList<Student> lista = FXCollections.observableArrayList();
	ObservableList<Student> todos = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		try{
			ColunaNome.setCellValueFactory(new PropertyValueFactory<>("name"));
			ColunaMatricula.setCellValueFactory(new PropertyValueFactory<>("code"));
		}
		catch(Exception e){
	        e.printStackTrace();
	        out.println("Error nessa porraa");
	    }
		
		List<Student> alunos = new ArrayList<>();
	    try{
	    	alunos = daoDados.getAll();
			for(Student d : lista ) {
				out.println(d.getId());
				out.println(d.getName());
				out.println(d.getCode());
			}
	    }catch(Exception e){
	        e.printStackTrace();
	        out.println("Error on Building Data");
	    }
	    if (alunos != null) {
	    	lista.addAll(alunos);
	    	TabelaAlunos.setItems(lista);
	    	todos.addAll(alunos);
	    }
	    else {
	    	System.out.println("Erro.");
	    }
	    
	}
	
	public void telaProfessor(ActionEvent event) throws Exception {
		Telas.Gerente_TelaProfessores();
	}
	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
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
	public void addAluno(ActionEvent event) throws Exception {
		Telas.Gerente_CadastrarAluno();
	}

}
