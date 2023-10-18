package com.classmanager.controller;

import com.classmanager.view.Telas;
import com.classmanager.model.Discipline;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.DAO.DisciplineDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static java.lang.System.out;

public class Gerente_TelaDisciplinas implements Initializable {
	
	@FXML
	private RadioButton BotãoRadioAtiva, BotãoRadioInativa;
	private List<Discipline> dados = null;
    private TableView<Discipline> TabelaDisciplinas;
	
    
    
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		DisciplineDAO daoDados = new DisciplineDAO();
	    dados = daoDados.getAll();
		for(Discipline d : dados ) {
			out.println(d.getName());
			out.println(d.getCode());

		}
	    try{
	    	TabelaDisciplinas.setItems((ObservableList<Discipline>) dados);
	    }catch(Exception e){
	        e.printStackTrace();
	        out.println("Error on Building Data");
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
 