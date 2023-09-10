package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

public class Class {
    private int id;
    private Discipline discipline;
    private Timetable timetable;
    private String local;
    private String semestre;
    private ClassStatus status;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;



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
        this.local = local;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
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

package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

    public class Class {
        private Discipline discipline;
        private Timetable timetable;
        private String local;
        private String semestre;
        private ClassStatus status;
        private ArrayList<Student> students;
        private ArrayList<Teacher> teachers;



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
            this.local = local;
        }
        public String getSemestre() {
            return semestre;
        }
        public void setSemestre(String semestre) {
            this.semestre = semestre;
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



        public void register(com.classmanager.model.Class Cl) {
            //Cadastra no Banco de Dados
        }
        public void update(com.classmanager.model.Class Cl) {
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
    }
package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

    public class Class {
        private Discipline discipline;
        private Timetable timetable;
        private String local;
        private String semestre;
        private ClassStatus status;
        private ArrayList<Student> students;
        private ArrayList<Teacher> teachers;



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
            this.local = local;
        }
        public String getSemestre() {
            return semestre;
        }
        public void setSemestre(String semestre) {
            this.semestre = semestre;
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



        public void register(com.classmanager.model.Class Cl) {
            //Cadastra no Banco de Dados
        }
        public void update(com.classmanager.model.Class Cl) {
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
    }
package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

    public class Class {
        private Discipline discipline;
        private Timetable timetable;
        private String local;
        private String semestre;
        private ClassStatus status;
        private ArrayList<Student> students;
        private ArrayList<Teacher> teachers;



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
            this.local = local;
        }
        public String getSemestre() {
            return semestre;
        }
        public void setSemestre(String semestre) {
            this.semestre = semestre;
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



        public void register(com.classmanager.model.Class Cl) {
            //Cadastra no Banco de Dados
        }
        public void update(com.classmanager.model.Class Cl) {
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
    }
package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

    public class Class {
        private Discipline discipline;
        private Timetable timetable;
        private String local;
        private String semestre;
        private ClassStatus status;
        private ArrayList<Student> students;
        private ArrayList<Teacher> teachers;



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
            this.local = local;
        }
        public String getSemestre() {
            return semestre;
        }
        public void setSemestre(String semestre) {
            this.semestre = semestre;
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



        public void register(com.classmanager.model.Class Cl) {
            //Cadastra no Banco de Dados
        }
        public void update(com.classmanager.model.Class Cl) {
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
    }
package com.classmanager.model;

import enums.ClassStatus;
import java.util.ArrayList;

    public class Class {
        private Discipline discipline;
        private Timetable timetable;
        private String local;
        private String semestre;
        private ClassStatus status;
        private ArrayList<Student> students;
        private ArrayList<Teacher> teachers;



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
            this.local = local;
        }
        public String getSemestre() {
            return semestre;
        }
        public void setSemestre(String semestre) {
            this.semestre = semestre;
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



        public void register(com.classmanager.model.Class Cl) {
            //Cadastra no Banco de Dados
        }
        public void update(com.classmanager.model.Class Cl) {
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
}
