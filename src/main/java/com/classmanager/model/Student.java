package com.classmanager.model;

public class Student {
	private Long id;
	private String name;
	private String code;
	private Address address;
	private Historic historic;


	public Student() {
	}

	public Student(Long id, String name, String code, Address address, Historic historic) {
		setId(id);
		setName(name);
		setCode(code);
		setAddress(address);
		setHistoric(historic);
	}
	public Student(String name, String code, Address address, Historic historic) {
		setName(name);
		setCode(code);
		setAddress(address);
		setHistoric(historic);
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
	
	public void setAddress(Address address) {
		if (address != null)
			this.address = address;
	}
	
	public Historic getHistoric() {
		return this.historic;
	}
	
	public void setHistoric (Historic historic){
		if(historic != null)
			this.historic = historic;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id >= 0)
			this.id = id;
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
