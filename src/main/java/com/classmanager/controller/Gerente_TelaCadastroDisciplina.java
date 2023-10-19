package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Discipline;
import com.classmanager.view.Telas;
import com.classmanager.DAO.DisciplineDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Gerente_TelaCadastroDisciplina implements Initializable {

	@FXML
	private TextField CampoNomeDisciplina;
	@FXML private ChoiceBox<String> ChoiceBoxStatus;
	private String[] estados = {"-", "Ativa", "Inativa"};
	private Stage parentStage;
	private String Status;

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxStatus.getItems().addAll(estados);
		ChoiceBoxStatus.setOnAction(this::getUF);
		ChoiceBoxStatus.getSelectionModel().selectFirst();
	}

	private void getUF(ActionEvent event) {Status = ChoiceBoxStatus.getValue();}

	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
	}
	public void autenticar(ActionEvent event) throws Exception {
		if (!CampoNomeDisciplina.getText().isEmpty() && !Status.equals("-")) {
			DisciplineDAO disciplineDAO = new DisciplineDAO();
			DisciplineStatus s;
			if (Status.equals("Ativa")){
				s = DisciplineStatus.ACTIVE;
			}
			else{
				s = DisciplineStatus.DESABLED;
			}

			String nome = CampoNomeDisciplina.getText();
			Discipline discipline = new Discipline(nome,s);
			disciplineDAO.register(discipline);

			Telas.Gerente_TelaInicial();
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setContentText("Campos Obrigatórios (*) devem ser preenchidos");
			alert.show();
		}
	}
	public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}

}