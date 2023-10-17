package com.classmanager.model;

import java.util.ArrayList;

import com.classmanager.enums.ClassStatus;

public class Class {
    private Long id;
    private Discipline discipline;
    private Timetable timetable;
    private String local;
    private String period;
    private ClassStatus status;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;


    public Class() {}
    public Class(Long id, Discipline discipline, Timetable timetable, String local, String period, ClassStatus status, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        setDiscipline(discipline);
        setLocal(local);
        setStatus(status);
        setPeriod(period);
        setId(id);
        setTimetable(timetable);
        setTeachers(teachers);
        setStudents(students);
    }
    public Class(Discipline discipline, Timetable timetable, String local, String period, ClassStatus status, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        setDiscipline(discipline);
        setLocal(local);
        setStatus(status);
        setPeriod(period);
        setTimetable(timetable);
        setTeachers(teachers);
        setStudents(students);
    }


    public Discipline getDiscipline() {
        return discipline;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    public Timetable getTimetable() {
        return timetable;
    }
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        if (!local.isEmpty() && local != null)
            this.local = local;
    }
    public ClassStatus getStatus() {
        return status;
    }
    public void setStatus(ClassStatus status) {
        this.status = status;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null && id >= 0)
            this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }



    public void register(Class Cl) {
        //Cadastra no Banco de Dados
    }
    public void update(Class Cl) {
        //Atualiza no Banco de Dados
    }
    public ArrayList<Student> addStudent(Student St){
        students.add(St);

        return  this.students;
    }
    public ArrayList<Student>  deleteStudent(Student St){
        students.remove(St);

        return  this.students;
    }
    public void  findClassBySudent() {
        //Busca classe por estudante no Banco de Dados
    }
    public void  findClassByTeacher(){
        //Busca classe por professor no Banco de Dados
    }
    public void  findClassByDiscipline(){
        //Busca classe por disciplina no Banco de Dados
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", discipline=" + discipline +
                ", timetable=" + timetable +
                ", local='" + local + '\'' +
                ", period='" + period + '\'' +
                ", status=" + status +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
