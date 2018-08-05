package com.sashi.parser;


import com.sashi.input.console.model.Employee;
import com.sashi.input.console.repository.EmployeeDataRepository;

public class EmployeeDataHandler implements IRequestHandler {

	private static EmployeeDataHandler handler = null;

	private EmployeeDataHandler() {

	}

	public static EmployeeDataHandler getInstance() {
		synchronized (EmployeeDataHandler.class) {
			if (handler == null) {
				handler = new EmployeeDataHandler();
			}
			return handler;
		}
	}

	@Override
	public void handle(String input) {
		String[] employeeData = input.split(", ");
		Employee employee = new Employee(employeeData);
		EmployeeDataRepository.getInstance().addEmployee(employee);
	}
}
