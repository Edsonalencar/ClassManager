package com.classmanager.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.classmanager.DAO.TeacherDAO;
import com.classmanager.model.Student;
import com.classmanager.model.Teacher;
import com.classmanager.view.Telas;

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

import static java.lang.System.out;

public class Gerente_TelaProfessores implements Initializable {

	public TeacherDAO teaDAO = new TeacherDAO();
	@FXML TextField CampoBuscar;
	@FXML private TableView<Teacher> TableaProfessores;
	@FXML private TableColumn<Teacher, String> ColunaNome;
	@FXML private TableColumn<Teacher, String> ColunaCPF;

	ObservableList<Teacher> lista = FXCollections.observableArrayList();
	ObservableList<Teacher> todos = FXCollections.observableArrayList();
	
	
	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
	}
	public void telaAluno(ActionEvent event) throws Exception {
		Telas.Gerente_TelaAlunos();
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
	public void addProf(ActionEvent event) throws Exception {
		Telas.Gerente_CadastrarProfessor();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			ColunaNome.setCellValueFactory(new PropertyValueFactory<>("name"));
			ColunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		}
		catch(Exception e){
			e.printStackTrace();
			out.println("Erro aqui.");
		}
		try {
			TableaProfessores.setRowFactory(tv -> {
				TableRow<Teacher> row = new TableRow<>();
				row.setOnMouseClicked(event -> {
					if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
							&& event.getClickCount() == 2) {
						Teacher clickedRow = row.getItem();
						try {
							Telas.Gerente_ShowProfessor(clickedRow.getId());
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

		List<Teacher> prof = new ArrayList<>();
		try{
			prof = teaDAO.getAll();
			for(Teacher t : prof ) {
				String nomeAlterar = t.getName();
				String Capitalizado = Arrays.stream(nomeAlterar.split(" "))
						.map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
						.collect(Collectors.joining(" "));
				System.out.println(Capitalizado);
				t.setName(Capitalizado);
			}
		}catch(Exception e){
			e.printStackTrace();
			out.println("Error on Building Data");
		}
		if (prof != null) {
			lista.addAll(prof);
			TableaProfessores.setItems(lista);
			todos.addAll(prof);
		}
		else {
			System.out.println("Erro.");
		}
	}

	@FXML
	public void onSearchKeyReleased(KeyEvent event) throws Exception {
		String busca = CampoBuscar.getText().toLowerCase();
		if (!busca.isEmpty()) {
			List<Teacher> result = new ArrayList<>();

			for (Teacher t : todos) {
				if(t.getName().toLowerCase().contains(busca)) {
					result.add(t);
				}
			}
			ObservableList<Teacher> resultObs = FXCollections.observableArrayList();
			resultObs.addAll(result);

			TableaProfessores.setItems(resultObs);
			out.println(busca);
		}
		else {
			TableaProfessores.setItems(todos);
		}
	}
}
