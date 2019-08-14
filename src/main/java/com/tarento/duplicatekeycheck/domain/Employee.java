package com.tarento.duplicatekeycheck.domain;

import java.util.Optional;

public class Employee {

	String id;
	String firstName;
	String lastName;
	String department;
	long salary;

	public Employee(String id, String firstName, String lastName, String department,long salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override 
	public String toString() {
		return this.getId()+"|"+
				this.getFirstName()+"|"+
				this.getLastName()+"|"+
				this.getDepartment()+"|"+
				this.getSalary();
	}

	@Override
	public boolean equals(Object obj) {
		Optional<Object> e = Optional.ofNullable(obj);
		if(!e.isPresent()) {
			return false;
		}
		else {
			Employee emp = (Employee)e.get();
			return emp.getId()==this.getId();
		}
	}


}
