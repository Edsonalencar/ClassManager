package com.classmanager.controller;

import com.classmanager.model.Student;
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
import javafx.scene.input.KeyEvent;

import javax.swing.*;

import static java.lang.System.out;

public class Gerente_TelaDisciplinas implements Initializable {
	
	public DisciplineDAO daoDados = new DisciplineDAO();
	private String searchField = "";
	private String searchCode = "";
	private DisciplineStatus disciplineStatus = DisciplineStatus.ACTIVE;

	List<Discipline> disciplineList = new ArrayList<>();

	@FXML TextField CampoBuscar;
	@FXML TextField CampoCodigo;
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
				out.println(d.getStatus());
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
	
	@FXML
	private void getStatus(ActionEvent event) {
		List<Discipline> result = new ArrayList<>();

		if (BotãoRadioAtiva.isSelected())
			result = daoDados.getByStatus(DisciplineStatus.ACTIVE);
		 else
			 result = daoDados.getByStatus(DisciplineStatus.DESABLED);

		out.println(result);

		ObservableList<Discipline> resultObs = FXCollections.observableArrayList();
		resultObs.addAll(result);

		TabelaDisciplinas.setItems(resultObs);
	}

	@FXML
	public void onSearchKeyReleased2(KeyEvent event) throws Exception {
		String busca = CampoBuscar.getText().toLowerCase();
		if (!busca.isEmpty()) {
			List<Discipline> result = new ArrayList<>();

			for (Discipline d : todos) {
				if(d.getName().toLowerCase().contains(busca)) {
					result.add(d);
				}
			}
			ObservableList<Discipline> resultObs = FXCollections.observableArrayList();
			resultObs.addAll(result);

			TabelaDisciplinas.setItems(resultObs);
			out.println(busca);
		}
		else {
			TabelaDisciplinas.setItems(todos);
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
 