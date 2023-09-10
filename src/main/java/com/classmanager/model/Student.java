package com.classmanager.model;

import java.util.ArrayList;

public class Student {
	private String name;
	private String code;
	private Address address;
	private ArrayList<Historic> historic = new ArrayList(1);
	
	Student(String name, String code, Address address, ArrayList<Historic> historic) {
		this.name = name;
		this.code = code;
		this.address = address;
		this.historic = historic;
	}
	
	public String getName() {
        return name;
    }
    
	public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
        else {
        	this.name = "Sem nome cadastrado";
        }
    }
    
	public String getCode() {
        return code;
    }
    
	public void setCode(String code) {
        if (!code.isEmpty()) {
            this.code = code;
        }
        else {
        	this.code = "Sem código cadastrado";
        }
    }
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(String city, String state, String district, int number) {
		if ((!city.isEmpty()) && (!state.isEmpty()) && (!district.isEmpty()) && (number > 0)){
			this.address.setCity(city);
			this.address.setState(state);
			this.address.setDistrict(district);
			this.address.setNumber(number);
		}
	}
	
	public ArrayList<Historic> getHistoric() {
		return this.historic;
	}
	
	public void setHistoric (ArrayList<Historic> historic){
		if(!historic.isEmpty()) {
			this.historic = historic;
		}
	}
	
	
	public void register() {
		//Registra estudante no banco de dados.
	}
	
	public void update() {
		//Atualiza estudante no banco de dados.
	}
	
	public void addHistoric() {
		//Adiciona histórido do estudante no banco de dados.
	}
	
	public void updateHistoric() {
		//Atualiza histórico do estudante no banco de dados.
	}
	
	public void findStudentByClass() {
		//Procura estudante por sua classe no banco de dados.
	}
	
	public void findStudentByName() {
		//Procura estudante por seu nome no banco de dados.
	}
	
	public void findClassByDiscipline() {
		//Procura classe por disciplina no banco de dados.
	}
}
