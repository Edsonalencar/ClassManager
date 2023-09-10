package com.classmanager.model;

import java.time.LocalDate;

public abstract class Frequency {
	private LocalDate day;
	private boolean present;
	
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
	
	public void update(Frequency Fr) {
		// Atualiza
	}
	
}