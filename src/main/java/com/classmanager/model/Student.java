package com.classmanager.model;

public class Student {
	private Long id;
	private String name;
	private String code;
	private Address address;


	public Student() {
	}

	public Student(Long id, String name, String code, Address address) {
		setId(id);
		setName(name);
		setCode(code);
		setAddress(address);
	}
	public Student(String name, String code, Address address) {
		setName(name);
		setCode(code);
		setAddress(address);
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

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				", address=" + address +
				'}';
	}
}
