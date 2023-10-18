package com.classmanager.model;

import com.classmanager.enums.DisciplineStatus;

public class Discipline {
    private Long id;
    private String name;
    private String code;
    private DisciplineStatus status;


    public Discipline() {
    }

    public Discipline(Long id, String name, String code, DisciplineStatus status) {
        setId(id);
        setName(name);
        setCode(code);
        setStatus(status);
    }
    public Discipline(String name, String code, DisciplineStatus status) {
        setName(name);
        setCode(code);
        setStatus(status);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty() && name != null)
            this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        if (!name.isEmpty() && code != null)
            this.code = code;
    }
    public DisciplineStatus getStatus() {
        return status;
    }
    public void setStatus(DisciplineStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null && id >= 0)
            this.id = id;
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

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
