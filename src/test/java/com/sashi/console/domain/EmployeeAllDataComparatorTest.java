package com.sashi.console.domain;

import com.sashi.input.console.domain.EmployeeAllDataComparator;
import com.sashi.input.console.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class EmployeeAllDataComparatorTest {
	@Test
	public void compareTo_isEmpty_returnsEmptyList(){
		List<Employee> employees = new ArrayList<>();
		employees.sort(EmployeeAllDataComparator.getInstance());
		assertTrue(employees.isEmpty());
	}

	@Test
	public void compareTo_hasEmployeeData_sortsAllFields(){
		List<Employee> employees = new ArrayList<>();
		Employee e1= new Employee("Ravi", "Ashwin", 77, 35, "Cricket");
		Employee e2 = new Employee("Virat", "Kohli", 74, 55, "HCL");
		Employee e3= new Employee("Naveen", "Ramesh", 27, 25, "Fission"
		);
		Employee e4= new Employee("Naveen", "Chandra", 50, 25, "Fission"
		);
		Employee e5 = new Employee("Virat", "Kohli", 14, 22, "HCL"
		);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.sort(EmployeeAllDataComparator.getInstance());
		assertTrue(employees.size()==5);
		assertTrue(employees.get(0).getOrganization().equals("Cricket"));
		assertTrue(employees.get(4).getOrganization().equals("HCL"));
		assertTrue(employees.get(3).getExperience() <employees.get(4).getExperience());
	}
}

