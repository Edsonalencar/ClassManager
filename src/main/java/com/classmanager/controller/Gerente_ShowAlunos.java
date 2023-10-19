package com.classmanager.controller;

import com.classmanager.DAO.DisciplineDAO;
import com.classmanager.DAO.StudentDAO;
import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Discipline;
import com.classmanager.model.Frequency;
import com.classmanager.model.Student;
import com.classmanager.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class Gerente_ShowAlunos implements Initializable {
    public StudentDAO daoDados = new StudentDAO();

    @FXML
    private TableView<Student> TabelaTurmasHistóricoAluno;
    @FXML
    private TableColumn<Student, String> ColunaDisciplina;
    @FXML
    private TableColumn<Frequency, String> ColunaFrequencia;
    @FXML
    private TableColumn<Student, DisciplineStatus> ColunaNota1;
	
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
    public void del(ActionEvent event) throws Exception {
        Telas.Gerente_CadastrarAluno();
    }
    public void edit(ActionEvent event) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try{
//            ColunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("id"));
//            ColunaFrequencia.setCellValueFactory(new PropertyValueFactory<>("name"));
//           // ColunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            out.println("Error nessa porraa");
//        }
//
//        List<Discipline> disciplinas = new ArrayList<>();
//        try{
//            disciplinas = daoDados.getAll();
//            for(Discipline d : lista ) {
//                out.println(d.getId());
//                out.println(d.getName());
//                out.println(d.getCode());
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            out.println("Error on Building Data");
//        }
//        if (disciplinas != null) {
//            lista.addAll(disciplinas);
//            TabelaDisciplinas.setItems(lista);
//            todos.addAll(disciplinas);
//        }
//        else {
//            System.out.println("Erro.");
//        }
    }
}
