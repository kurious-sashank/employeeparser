package com.sashi.input.console.model;

public class Employee {
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer experience;
	private String organization;

	public Employee(String firstName, String lastName, int age, int experience, String organization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.experience = experience;
		this.organization = organization;
	}

	public Employee(String[] employeeData) {
		this.firstName = employeeData[0];
		this.lastName = employeeData[1];
		this.age = Integer.parseInt(employeeData[2]);
		this.experience = Integer.parseInt(employeeData[3]);
		this.organization = employeeData[4];
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getExperience() + ", " + getOrganization();
	}
}
