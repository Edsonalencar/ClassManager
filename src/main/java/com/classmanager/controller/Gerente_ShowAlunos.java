package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.DAO.StudentDAO;
import com.classmanager.model.Student;
import com.classmanager.view.ArrayShow;
import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Gerente_ShowAlunos implements Initializable {
	
	private long id = ArrayShow.getid();
	StudentDAO alunos = new StudentDAO();
	Student aluno = alunos.getById(id);
	
	@FXML private Label LabelNome;
	@FXML private Label LabelEndereço;
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
		LabelNome.setText(aluno.getName());
		LabelEndereço.setText("  "+aluno.getAddress().getState()+"\n"+aluno.getAddress().getCity()+"\n"+aluno.getAddress().getDistrict());
		
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
    public void telaAluno(ActionEvent event) throws Exception {
        Telas.Gerente_TelaAlunos();
    }
}
