package com.classmanager.controller;

import com.classmanager.view.Telas;
import com.classmanager.model.Discipline;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.enums.DisciplineStatus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static java.lang.System.out;

public class Gerente_TelaDisciplinas implements Initializable {
	
	public DisciplineDAO daoDados = new DisciplineDAO();

	
	@FXML 
	private RadioButton BotãoRadioAtiva, BotãoRadioInativa;
	@FXML 
	private TableView<Discipline> TabelaDisciplinas;
	@FXML 
	private TableColumn<Discipline, Long> ColunaCodigoDisciplina;
	@FXML 
	private TableColumn<Discipline, String> ColunaTítulo;
	@FXML 
	private TableColumn<Discipline, DisciplineStatus> ColunaStatus;
    
	ObservableList<Discipline> lista = FXCollections.observableArrayList();
	ObservableList<Discipline> todos = FXCollections.observableArrayList();
	
	@Override
	public  void initialize(URL url, ResourceBundle resourcebundle) {
		try{
			ColunaCodigoDisciplina.setCellValueFactory(new PropertyValueFactory<>("id"));
			ColunaTítulo.setCellValueFactory(new PropertyValueFactory<>("name"));
			ColunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		}
		catch(Exception e){
	        e.printStackTrace();
	        out.println("Error nessa porraa");
	    }
		
		List<Discipline> disciplinas = new ArrayList<>();
	    try{
			disciplinas = daoDados.getAll();
			for(Discipline d : lista ) {
				out.println(d.getId());
				out.println(d.getName());
				out.println(d.getCode());
			}
	    }catch(Exception e){
	        e.printStackTrace();
	        out.println("Error on Building Data");
	    }
	    if (disciplinas != null) {
	    	lista.addAll(disciplinas);
	    	TabelaDisciplinas.setItems(lista);
	    	todos.addAll(disciplinas);
	    }
	    else {
	    	System.out.println("Erro.");
	    }
	    
	}
	
	private void getStatus(ActionEvent event) {
		if (BotãoRadioAtiva.isSelected()) {
			//PREENCHE O CAMPO DE STATUS DA DISCIPLINA NO BANCO DE DADOS COMO "ATIVA"
		}
		else if (BotãoRadioInativa.isSelected()) {
			//PREENCHE O CAMPO DE STATUS DA DISCIPLINA NO BANCO DE DADOS COMO "INATIVA"
		}
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
	public void addDisc(ActionEvent event) throws Exception {
		Telas.Gerente_TelaCadastroDisciplina();
	}
}
 