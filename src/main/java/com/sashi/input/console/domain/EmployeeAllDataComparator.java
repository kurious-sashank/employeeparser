package com.sashi.input.console.domain;

import com.sashi.input.console.model.Employee;

import java.util.Comparator;

public class EmployeeAllDataComparator implements Comparator<Employee> {
	private static EmployeeAllDataComparator comparator = null;

	private EmployeeAllDataComparator(){

	}

	public static EmployeeAllDataComparator getInstance(){
		synchronized (EmployeeAllDataComparator.class){
			if(comparator ==null){
				comparator = new EmployeeAllDataComparator();
			}
			return comparator;
		}
	}
	@Override
	public int compare(Employee e1, Employee e2) {
		int result = e1.getOrganization().compareTo(e2.getOrganization());
		if(result==0){
			result = e1.getExperience().compareTo(e2.getExperience());
		}
		if(result==0){
			result = e1.getFirstName().compareTo(e2.getFirstName());
		}
		if(result==0){
			result = e1.getLastName().compareTo(e2.getLastName());
		}
		return result;
	}
}
