package com.classmanager.model;

import java.util.ArrayList;
import java.util.List;

import com.classmanager.enums.ClassStatus;

public class Class {
    private Long id;
    private Discipline discipline;
    private Timetable timetable;
    private String local;
    private String period;
    private ClassStatus status;
    private List<Student> students;
    private Teacher teacher;

    public Class() {}
    public Class(Long id, Discipline discipline, Timetable timetable, String local, String period, ClassStatus status,Teacher teacher, ArrayList<Student> students) {
        setDiscipline(discipline);
        setLocal(local);
        setStatus(status);
        setPeriod(period);
        setId(id);
        setTimetable(timetable);
        setTeacher(teacher);
        setStudents(students);
    }
    public Class(Discipline discipline, Timetable timetable, String local, String period, ClassStatus status, Teacher teacher, ArrayList<Student> students) {
        setDiscipline(discipline);
        setLocal(local);
        setStatus(status);
        setPeriod(period);
        setTimetable(timetable);
        setTeacher(teacher);
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
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
                ", teacher=" + teacher +
                '}';
    }
}
