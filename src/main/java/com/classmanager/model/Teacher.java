package com.classmanager.model;

import java.util.ArrayList;

public class Teacher {
	private Long id;
	private Usuario user;
	private String name;
	private String cpf;
	private Address address;
	private ArrayList<Class> classes;


	public Teacher() {
	}

	public Teacher(Long id, Usuario user, String name, String cpf, Address address, ArrayList<Class> classes) {
		setId(id);
		setUser(user);
		setName(name);
		setCPF(cpf);
		setAddress(address);
		setClasses(classes);
	}
	public Teacher(String name, String cpf, Address address, ArrayList<Class> classes) {
		setName(name);
		setCPF(cpf);
		setAddress(address);
		setClasses(classes);
	}


	public String getName() {
        return name;
    }
	public void setName(String name) {
        if (!name.isEmpty() && name != null) {
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
        if (!cpf.isEmpty() && cpf != null) {
            this.cpf = cpf;
        }
        else {
        	this.cpf = "Sem CPF cadastrado";
        }
    }
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		if (address != null)
			this.address = address;
	}
	public ArrayList<Class> getClasses() {
		return this.classes;
	}
	public void setClasses(ArrayList<Class> classes){
		if(!classes.isEmpty() && classes != null)
			this.classes = classes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if (id != null && id >= 0)
			this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				"usuario=" + user +
				", name='" + name + '\'' +
				", cpf='" + cpf + '\'' +
				", address=" + address +
				", classes=" + classes +
				'}';
	}
}
