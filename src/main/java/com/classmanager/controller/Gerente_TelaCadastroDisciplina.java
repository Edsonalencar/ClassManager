package com.classmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.classmanager.view.Telas;
import com.classmanager.DAO.DisciplineDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Gerente_TelaCadastroDisciplina implements Initializable {
	
	@FXML
	private TextField CampoNomeDisciplina;
	private ChoiceBox<String> ChoiceBoxStatus;
	private String[] estados = {"-", "Ativa", "Inativa"};
	private Stage parentStage;

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		ChoiceBoxStatus.getItems().addAll(estados);
		ChoiceBoxStatus.setOnAction(this::getUF);
		ChoiceBoxStatus.getSelectionModel().selectFirst();
	}
	
	private void getUF(ActionEvent event) {
		String Status = ChoiceBoxStatus.getValue();
	}
	
	public void telaDisciplina(ActionEvent event) throws Exception {
		Telas.Gerente_TelaDisciplina();
	}
	public void autenticar(ActionEvent event) throws Exception {
		if (parentStage != null) {
			parentStage.close();
			Telas.Gerente_TelaInicial();
		}
	}
	public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}

}
