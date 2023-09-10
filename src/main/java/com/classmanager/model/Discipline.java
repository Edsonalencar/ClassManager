package com.classmanager.model;

import enums.DisciplineStatus;

public class Discipline {
    private  String name;
    private  String code;
    private DisciplineStatus status;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        if (!name.isEmpty()) {
            this.code = code;
        }
    }
    public DisciplineStatus getStatus() {
        return status;
    }
    public void setStatus(DisciplineStatus status) {
        this.status = status;
    }



    public  void register(Discipline Ds) {
        //Cadastro no Banco de Dados
    }
    public  void update(Discipline Ds) {
        //Atualiza no Banco de Dados
    }
    public  void delete(Discipline Ds) {
        //Delete no Banco de Dados
    }
    public  void findDisciplineByName(String name) {
        //Busca disciplina por nome no Banco de Dados
    }
}
