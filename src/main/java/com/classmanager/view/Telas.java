package com.classmanager.view;

import com.classmanager.model.Student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class Telas extends Application{

    //Comentário commit
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("Sequence");
        primaryStage.setResizable(false);
        primaryStage.show();
        telaLogin();
    }

    public static void telaLogin() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLogin.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Aluno_EditarPerfil() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Aluno_EditarPerfil.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Aluno_ShowTurma() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Aluno_ShowTurma.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Aluno_TelaInicial() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Aluno_TelaInicial.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Aluno_TelaTurmas() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Aluno_TelaTurmas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_CadastrarAluno() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_CadastrarAluno.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_CadastrarProfessor() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_CadastrarProfessor.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_CadastrarTurma() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_CadastrarTurma.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_ShowAlunos(long id) throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_ShowAlunos.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_ShowProfessor() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_ShowProfessor.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_ShowTurma() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_ShowTurma.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaAlunos() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaAlunos.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaCadastroDisciplina() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaCadastroDisciplina.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaDisciplina() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaDisciplinas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaInicial() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaInicial.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaProfessores() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaProfessores.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Gerente_TelaTurmas() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Gerente_TelaTurmas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Professor_EditarPerfil() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Professor_EditarPerfil.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Professor_ShowTurma() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Professor_ShowTurma.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Professor_TelaInicial() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Professor_TelaInicial.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void Professor_TelaTurmas() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Professor_TelaTurmas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
    }
    public static void main (String ... args){
        launch();
    }

}
