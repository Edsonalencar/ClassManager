package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Gerente_TelaInicial implements Initializable {
	@FXML private TextField CampoBuscar;
	@FXML private TextField CampoSelecionarProfessor;
	
	@FXML
    private TableView TabelaItens;
    @FXML
    private TableColumn ColunaTurma;
    @FXML
    private TableColumn ColunaDisciplina;
    @FXML
    private TableColumn ColunaProfessor;
    @FXML
    private TableColumn ColunaAulas;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaTurma.setCellValueFactory(
                new PropertyValueFactory<>("ID Turma"));
        ColunaDisciplina.setCellValueFactory(
                new PropertyValueFactory<>("Disciplina"));
        ColunaProfessor.setCellValueFactory(
                new PropertyValueFactory<>("Professor"));
        ColunaAulas.setCellValueFactory(
                new PropertyValueFactory<>("Aulas"));
        
        TabelaItens.setItems(null); //ADICIONAR DE UM VETOR CONTENDO OBJETOS COM (IDTURMA(LONG),DISCIPLINA,PROFESSOR(1º DO ARRAY,TIMETABLE)
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
