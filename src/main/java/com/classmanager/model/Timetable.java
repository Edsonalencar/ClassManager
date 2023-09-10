package com.classmanager.model;

import java.time.LocalDate;

public class Timetable {
    private LocalDate start_time;
    private LocalDate end_time;


    public LocalDate getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalDate start_time) {
        this.start_time = start_time;
    }
    public LocalDate getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalDate end_time) {
        this.end_time = end_time;
    }



    public  void register(Timetable Tb) {
        //Cadastro no Banco de Dados
    }
    public  void update(Timetable Tb) {
        //Atualiza no Banco de Dados
    }
    public  void delete(Timetable Tb) {
        //Delete no Banco de Dados
    }
}
