package com.classmanager.model;

public class SchoolGrade {
	private Long id;
	private String period;
	private int grade;
	private Student student;
	private Class aClass;

	public SchoolGrade() {
	}

	public SchoolGrade(Long id, String period, int grade) {
		setId(id);
		setPeriod(period);
		setGrade(grade);
	}

	public SchoolGrade(String period, int grade, Student student, Class aClass) {
		setPeriod(period);
		setGrade(grade);
		setStudent(student);
		setaClass(aClass);
	}
	public SchoolGrade(String period, int grade) {
		setPeriod(period);
		setGrade(grade);
	}

	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		if (period != null && !period.isEmpty())
			this.period = period;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if (grade >= 0 )
			this.grade = grade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if (id != null && id >= 0)
			this.id = id;
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Class getaClass() {
		return aClass;
	}

	public void setaClass(Class aClass) {
		this.aClass = aClass;
	}

	@Override
	public String toString() {
		return "SchoolGrade{" +
				"id=" + id +
				", period='" + period + '\'' +
				", grade=" + grade +
				'}';
	}
}
