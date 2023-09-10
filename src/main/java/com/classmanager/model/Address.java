package com.classmanager.model;

public class Address {
	private String city;
	private String state;
	private String district;
	private int number;
	
	public String getCity() {
        return city;
    }
    
	public void setCity(String city) {
        if (!city.isEmpty()) {
            this.city = city;
        }
        else {
        	this.city = "Cidade desconhecida";
        }
    }
	
	public String getState() {
        return state;
    }
    
	public void setState(String state) {
        if (!state.isEmpty()) {
            this.state = state;
        }
        else {
        	this.state = "Estado desconhecido";
        }
    }
	
	public String getDistrict() {
        return district;
    }
    
	public void setDistrict(String district) {
        if (!district.isEmpty()) {
            this.district = district;
        }
        else {
        	this.district = "Sem Distrito";
        }
    }
	
	public int getNumber() {
        return number;
    }
    
	public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
    }
	
	public String getAddress() {
		return (city + state + district + number);
	}

	
}
