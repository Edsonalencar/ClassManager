package com.classmanager.model;

public class Address {
    private Long id;
	private String city;
	private String state;
	private String district;
	private int number;


    public Address() {}
    public Address(Long id, String city, String state, String district, int number) {
        setId(id);
        setCity(city);
        setDistrict(district);
        setState(state);
        setNumber(number);
    }
    public Address(String city, String state, String district, int number) {
        setCity(city);
        setDistrict(district);
        setState(state);
        setNumber(number);
    }


	public String getCity() {
        return city;
    }
    
	public void setCity(String city) {
        if (!city.isEmpty() && city != null) {
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
        if (!state.isEmpty() && city != null) {
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
        if (!district.isEmpty() && city != null) {
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
        if (number > 0)
            this.number = number;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        if (id != null && id >= 0)
            this.id = id;
    }
}
