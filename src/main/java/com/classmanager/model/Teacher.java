package com.classmanager.model;

import java.util.ArrayList;

public class Teacher {
	private Long id;
	private Long usuario_id;
	private String name;
	private String cpf;
	private Address address;
	private ArrayList<Class> classes;


	public Teacher() {
	}

	public Teacher(Long id, Long usuario_id, String name, String cpf, Address address, ArrayList<Class> classes) {
		setId(id);
		setUsuario_id(usuario_id);
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

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		if(usuario_id != null && usuario_id >= 0) {
			this.usuario_id = usuario_id;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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


	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				"usuario_id=" + usuario_id +
				", name='" + name + '\'' +
				", cpf='" + cpf + '\'' +
				", address=" + address +
				", classes=" + classes +
				'}';
	}
}
