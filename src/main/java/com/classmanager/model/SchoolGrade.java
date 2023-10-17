package com.classmanager.model;

public abstract class SchoolGrade {
	private Long id;
	private String period;
	private int grade;


	public SchoolGrade() {
	}

	public SchoolGrade(Long id, String period, int grade) {
		setId(id);
		setPeriod(period);
		setGrade(grade);
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
	
	public void update(SchoolGrade Sg) {
		// Atualiza 
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
