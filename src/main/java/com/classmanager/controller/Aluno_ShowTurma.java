package com.classmanager.controller;

import com.classmanager.view.Telas;
import javafx.event.ActionEvent;

public class Aluno_ShowTurma {
    public void telaTurma(ActionEvent event) throws Exception {
        Telas.Aluno_TelaTurmas();
    }
    public void telaInicio(ActionEvent event) throws Exception {
        Telas.Aluno_TelaInicial();
    }
    public void logout(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
    public void perfil(ActionEvent event) throws Exception {
        Telas.Aluno_EditarPerfil();
    }
}
