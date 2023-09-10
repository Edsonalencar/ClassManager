package com.classmanager.model;

import java.util.ArrayList;

public class Teacher {
	private String name;
	private String cpf;
	private Address address;
	private ArrayList<Class> classes = new ArrayList(1);
	
	Teacher(String name, String cpf, Address address, ArrayList<Class> classes) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.classes = classes;
	}
	
	public String getName() {
        return name;
    }
    
	public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
        else {
        	this.name = "Sem nome";
        }
    }
    
	public String getCPF() {
        return cpf;
    }
    
	public void setCPF(String cpf) {
        if (!cpf.isEmpty()) {
            this.cpf = cpf;
        }
        else {
        	this.cpf = "Sem CPF cadastrado";
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
	
	public ArrayList<Class> getClasses() {
		return this.classes;
	}
	
	public void setClasses(ArrayList<Class> classes){
		if(!classes.isEmpty()) {
			this.classes = classes;
		}
	}
	
	public void register() {
		//Registra professor no banco de dados.
	}
	
	public void update() {
		//Atualiza professor no banco de dados.
	}
	
	public void registerClass() {
		//Registra uma classe no banco de dados.
	}
	
	public void deleteClass() {
		//Deleta uma classe no banco de dados.
	}
	
	public void findTeacherByClass() {
		//Procura professor por sua classe no banco de dados.
	}
	
	public void findTeacherByName() {
		//Procura professor por seu nome no banco de dados.
	}
	
}
