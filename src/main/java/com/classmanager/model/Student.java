package com.classmanager.model;

public class Student {
	private Long id;
	private String name;
	private String code;
	private Address address;
	private Usuario user;

	public Student() {
	}

	public Student(Long id, String name, String code, Address address, Usuario user) {
		setId(id);
		setName(name);
		setCode(code);
		setAddress(address);
		setUser(user);
	}
	public Student(String name, String code, Address address, Usuario user) {
		setName(name);
		setCode(code);
		setUser(user);
		setAddress(address);
	}

	public Student(String name, String code, Address address) {
		setName(name);
		setCode(code);
		setUser(user);
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

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				"usuario=" + user +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				", address=" + address +
				'}' + "\n";
	}
}
