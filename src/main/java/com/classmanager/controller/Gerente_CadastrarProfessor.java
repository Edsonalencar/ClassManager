package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.DAO.StudentDAO;
import com.classmanager.DAO.TeacherDAO;
import com.classmanager.DAO.UsuarioDAO;
import com.classmanager.model.Address;
import com.classmanager.model.Student;
import com.classmanager.model.Teacher;
import com.classmanager.model.Usuario;
import com.classmanager.view.Telas;

import com.sun.javafx.text.TextRun;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Gerente_CadastrarProfessor implements Initializable {
	@FXML TextField CampoNome;
	@FXML TextField CampoBairro;
	@FXML TextField ProfLogin;
	@FXML TextField ProfSenha;
	@FXML TextField CampoCPF;
	@FXML TextField CampoCEP;
	@FXML TextField CampoNomeSocial;
	@FXML TextField CampoLogradouro;
	@FXML TextField CampoCidade;
	@FXML TextField CampoNumero;
	@FXML TextField CampoComplemento;
	private String estado;

	@FXML
	private ChoiceBox<String> ChoiceBoxUF;
	private String[] dados = {"-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};



	public void getUF(ActionEvent event) {
		estado = ChoiceBoxUF.getValue();
		//IMPLEMENTAR NO BANCO DE DADOS: Valor no banco = Estado
	}
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxUF.getItems().addAll(dados);
		ChoiceBoxUF.setOnAction(this::getUF);
		ChoiceBoxUF.getSelectionModel().selectFirst();
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
	private void handle(){
		String nome = CampoNome.getText();
		String cidade = CampoCidade.getText();
		String bairro = CampoBairro.getText();
		String cpf = CampoCPF.getText();
		String cep = CampoCEP.getText();
		String nomeS = CampoNomeSocial.getText();
		String logradouro = CampoLogradouro.getText();
		int numero = Integer.parseInt(CampoNumero.getText());
		String login = ProfLogin.getText();
		String senha = ProfSenha.getText();
		String complemento = CampoComplemento.getText();

		Address end = new Address(cidade, estado, bairro, numero);

		Usuario u = new Usuario(login, senha);
		Teacher teacher = new Teacher(nome, cpf, end, u);
		TeacherDAO daoDados = new TeacherDAO();
		daoDados.register(teacher);
	}
	public void autenticar(ActionEvent event) throws Exception {
		try{
			if (ProfLogin.getText().isEmpty() || ProfSenha.getText().isEmpty() || CampoNome.getText().isEmpty() ||
					CampoCEP.getText().isEmpty() || CampoCPF.getText().isEmpty() || CampoCidade.getText().isEmpty() ||
					CampoLogradouro.getText().isEmpty() || CampoNumero.getText().isEmpty() ||
					CampoBairro.getText().isEmpty() || CampoComplemento.getText().isEmpty()){

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setContentText("Campos Obrigatórios (*) devem ser preenchidos");
				alert.show();
			}
			else {
				handle();
				Telas.Gerente_TelaInicial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
