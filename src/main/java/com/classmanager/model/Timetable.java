package com.classmanager.model;

import java.time.LocalDate;

public class Timetable {
    private Long id;
    private LocalDate start_time;
    private LocalDate end_time;


    public Timetable() {
    }
    public Timetable(Long id, LocalDate start_time, LocalDate end_time) {
        setId(id);
        setStart_time(start_time);
        setEnd_time(end_time);
    }
    public Timetable(LocalDate start_time, LocalDate end_time) {
        setStart_time(start_time);
        setEnd_time(end_time);
    }



    public LocalDate getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalDate start_time) {
        if (start_time != null)
            this.start_time = start_time;
    }
    public LocalDate getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalDate end_time) {
        if (end_time != null)
            this.end_time = end_time;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null && id >= 0)
            this.id = id;
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
