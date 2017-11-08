package com.tecsup.labspring.model;

public class Department {
	
	/*`department_id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(45) DEFAULT NULL,
	`desc` varchar(90) DEFAULT NULL,
	`city` varchar(45) DEFAULT NULL,
	*/
	
	int departmentId;
	String name;
	String description;
	String city;
	
	public Department() {
		super();
	}

	public Department(int departmentId, String name, String description, String city) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.description = description;
		this.city = city;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", description=" + description
				+ ", city=" + city + "]";
	}

	
	
}


