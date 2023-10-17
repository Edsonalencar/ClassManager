package com.classmanager.model;

import java.time.LocalDate;

public abstract class Frequency {
	private Long id;
	private LocalDate day;
	private boolean present;


	public Frequency() {
	}

	public Frequency(Long id, LocalDate day, boolean present) {
		setId(id);
		setDay(day);
		setPresent(present);
	}
	public Frequency(LocalDate day, boolean present) {
		setDay(day);
		setPresent(present);
	}

	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		if (day != null) this.day = day;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if (id != null && id >= 0)
			this.id = id;
	}
	
	public void update(Frequency Fr) {
		// Atualiza
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