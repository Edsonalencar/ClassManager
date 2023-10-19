package com.classmanager.model;

import java.time.LocalDate;

public class Frequency {
	private Long id;
	private LocalDate day;
	private boolean present;
	private Student student;
	private Class aClass;

	public Frequency() {}

	public Frequency(Long id, LocalDate day, boolean present, Student student, Class aClass) {
		setId(id);
		setDay(day);
		setPresent(present);
		setaClass(aClass);
		setStudent(student);
	}
	public Frequency(LocalDate day, boolean present, Student student, Class aClass) {
		setDay(day);
		setPresent(present);
		setaClass(aClass);
		setStudent(student);
	}
	public Frequency(LocalDate day, boolean present) {
		setDay(day);
		setPresent(present);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
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
		return "Frequency{" +
				"id=" + id +
				", day=" + day +
				", present=" + present +
				'}';
	}
}