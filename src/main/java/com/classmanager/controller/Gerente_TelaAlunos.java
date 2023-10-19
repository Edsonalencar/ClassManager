package com.classmanager.controller;

import static java.lang.System.out;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.classmanager.DAO.StudentDAO;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;
import com.classmanager.view.ArrayShow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;

public class Gerente_TelaAlunos implements Initializable {
	
	public StudentDAO daoDados = new StudentDAO();
	public long idGuardar;
	
	@FXML private TableView<Student> TabelaAlunos;
	@FXML private TableColumn<Student, String> ColunaNome;
	@FXML private TableColumn<Student, String> ColunaMatricula;
	@FXML private TextField CampoBuscar;
    
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
	        out.println("Erro aqui.");
	    }
		try {
			TabelaAlunos.setRowFactory(tv -> {
			    TableRow<Student> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
			             && event.getClickCount() == 2) {
			            Student clickedRow = row.getItem();
			            try {
			            	idGuardar = clickedRow.getId();
			            	ArrayShow.Guardar(idGuardar);
			            	Telas.Gerente_ShowAlunos();
						} catch (Exception e) {
							out.println("Erro aqui");
							e.printStackTrace();
						};
			        }
			    });
			    return row ;
			});
		}catch(Exception e){
	        e.printStackTrace();
	        out.println("Error on Building Data");
	    }
		
		List<Student> alunos = new ArrayList<>();
	    try{
	    	alunos = daoDados.getAll();
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
	    	TabelaAlunos.setItems(lista);
	    	todos.addAll(alunos);
	    }
	    else {
	    	System.out.println("Erro.");
	    }
	    
	}
	
	@FXML
	public void onSearchKeyReleased(KeyEvent event) throws Exception {
		String busca = CampoBuscar.getText().toLowerCase();
		if (!busca.isEmpty()) {
			List<Student> result = new ArrayList<>();
			
			for (Student s : todos) {
				if(s.getName().toLowerCase().contains(busca)) {
					result.add(s);
				}
			}
			ObservableList<Student> resultObs = FXCollections.observableArrayList();
			resultObs.addAll(result);
			
	    	TabelaAlunos.setItems(resultObs);
			out.println(busca);
		}
		else {
			TabelaAlunos.setItems(todos);
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
