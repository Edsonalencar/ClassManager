package com.classmanager.model;

public abstract class SchoolGrade {
	private String period;
	private int grade;
	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void update(SchoolGrade Sg) {
		// Atualiza 
	}
}
