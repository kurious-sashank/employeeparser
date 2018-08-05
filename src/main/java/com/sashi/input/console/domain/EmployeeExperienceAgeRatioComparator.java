package com.sashi.input.console.domain;

import com.sashi.input.console.model.Employee;

import java.util.Comparator;

public class EmployeeExperienceAgeRatioComparator implements Comparator<Employee> {
	private static EmployeeExperienceAgeRatioComparator comparator = null;

	private EmployeeExperienceAgeRatioComparator(){

	}

	public static EmployeeExperienceAgeRatioComparator getInstance(){
		synchronized (EmployeeExperienceAgeRatioComparator.class){
			if(comparator ==null){
				comparator = new EmployeeExperienceAgeRatioComparator();
			}
			return comparator;
		}
	}
	@Override
	public int compare(Employee e1, Employee e2) {
		Double ratio1 = (Double)((e1.getExperience()/(e1.getAge()*12))*1.0);
		Double ratio2 = (Double)((e2.getExperience()/(e2.getAge()*12))*1.0);

		int result = ratio1.compareTo(ratio2);
		if(result==0){
			result = e1.getOrganization().compareTo(e2.getOrganization());
		}

		return result;
	}
}
