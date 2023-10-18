package com.classmanager.controller;

import static java.lang.System.out;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;
import com.classmanager.model.Student;
import com.classmanager.model.Usuario;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.DAO.UsuarioDAO;
import com.classmanager.model.Address;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class Gerente_CadastrarAluno implements Initializable {
	
	public StudentDAO daoAluno = new StudentDAO();
	public UsuarioDAO daoUsuario = new UsuarioDAO();

	
	private String[] dados = {"-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	
	@FXML private ChoiceBox<String> ChoiceBoxUF;
	@FXML private TextField CampoNome;
	@FXML private TextField CampoCEP;
	@FXML private TextField CampoLogradouro;
	@FXML private TextField CampoCidade;
	@FXML private TextField CampoNumero;
	@FXML private TextField CampoComplemento;
	@FXML private TextField CampoBairro;
	@FXML private Button BotãoSalvar;
	@FXML private TextField AlunoLogin;
	@FXML private TextField AlunoSenha;
	
	
	private String nome;
	private String cidade; 
	private String estado; 
	private String bairro; 
	private String login;
	private String senha;
	private int numero; 
	long mat = 0;
	long mat1 = 1;
	
	List<Student> alunos = daoAluno.getAll();{
	for(Student s : alunos ) {
		mat = s.getId();
		mat = mat + 1 + 20231000;}
	}
	
	private void getUF(ActionEvent event) {
		String Estado = ChoiceBoxUF.getValue();
		estado = Estado;
	}
	
	private void handle(ActionEvent event) throws Exception {
		login = AlunoLogin.getText();
		senha = AlunoSenha.getText();
		
		nome = CampoNome.getText().toLowerCase();
		
		cidade = CampoCidade.getText();
		bairro = CampoBairro.getText();	
		String teste = CampoNumero.getText();
		if (teste.isEmpty()) {
			numero = 0;
		}
		else{
			numero = Integer.parseInt(CampoNumero.getText());
		}
		Address end = new Address(null, cidade, estado, bairro, numero);
		
		if (!login.isEmpty() && !senha.isEmpty() && !nome.isEmpty() && !cidade.isEmpty() && !bairro.isEmpty() && !estado.isEmpty()
				&& numero != 0) {
			Student aluno = new Student(nome, ""+mat, end);
			Usuario user = new Usuario(login, senha);
			
			daoAluno.register(aluno);
			daoUsuario.register(user);
			Telas.Gerente_TelaAlunos();
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erro");
	        alert.setContentText("Campos Obrigatórios (*) devem ser preenchidos");
	        alert.show();
		}
		
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxUF.getItems().addAll(dados);
		ChoiceBoxUF.setOnAction(this::getUF);
		ChoiceBoxUF.getSelectionModel().selectFirst();
		
		BotãoSalvar.setOnAction(event -> {
			try {
				handle(event);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
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
	public void autenticar(ActionEvent event) throws Exception {
		Telas.Gerente_TelaInicial();
	}

}
