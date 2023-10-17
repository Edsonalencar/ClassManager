package com.classmanager.model;

public class Historic {
	private Long id;
	private Class classe;
	private Student student;
	private Frequency frequency;
	private SchoolGrade schoolGrade;


	public Historic() {
	}
	public Historic(Long id, Class classe, Student student, Frequency frequency, SchoolGrade schoolGrade) {
		setId(id);
		setClasse(classe);
		setStudent(student);
		setFrequency(frequency);
		setSchoolGrade(schoolGrade);
	}
	public Historic(Class classe, Student student, Frequency frequency, SchoolGrade schoolGrade) {
		setClasse(classe);
		setStudent(student);
		setFrequency(frequency);
		setSchoolGrade(schoolGrade);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id >= 0)
			this.id = id;
	}

	public Class getClasse() {
		return classe;
	}

	public void setClasse(Class classe) {
		if (classe == null) return;
		this.classe = classe;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		if (student == null) return;
		this.student = student;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		if (frequency == null) return;
		this.frequency = frequency;
	}

	public SchoolGrade getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(SchoolGrade schoolGrade) {
		if (schoolGrade == null) return;
		this.schoolGrade = schoolGrade;
	}



	public void addFrequency(Frequency Fr) {
		// Adiciona a frequência 
	}
	public void deleteFrequency(Frequency Fr) {
		// Deleta a frequência
	}
	public void addSchoolGrade(SchoolGrade Sg) {
		// Adiciona 
	}
	public void deleteSchoolGrade(SchoolGrade Sg) {
		// Deleta 
	}

	@Override
	public String toString() {
		return "Historic{" +
				"id=" + id +
				", classe=" + classe +
				", student=" + student +
				", frequency=" + frequency +
				", schoolGrade=" + schoolGrade +
				'}';
	}
}
