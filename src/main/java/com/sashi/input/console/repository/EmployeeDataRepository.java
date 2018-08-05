package com.sashi.input.console.repository;

import com.sashi.input.console.domain.EmployeeAllDataComparator;
import com.sashi.input.console.domain.EmployeeExperienceAgeRatioComparator;
import com.sashi.input.console.domain.FileType;
import com.sashi.input.console.model.Employee;
import com.sashi.input.console.output.file.EmployeeDataFileWriter;
import com.sashi.input.console.validator.ConsoleInputValidationManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDataRepository {
	private final static Logger LOGGER = Logger.getLogger(EmployeeDataRepository.class.getName());

	private static EmployeeDataRepository repository = null;
	private static final List<Employee> EMPLOYEES = new ArrayList<>();
	private static final String SAVE_PATH="C:/employeedata/output/%s";
	private EmployeeDataRepository(){

	}

	public static EmployeeDataRepository getInstance(){
		synchronized (EmployeeDataRepository.class){
			if(repository ==null){
				repository = new EmployeeDataRepository();
			}
			return repository;
		}
	}

	public synchronized void  sort(){
		//save the original;
		String filePath = getFilePath(FileType.UNSORTED.getFileName());
		EmployeeDataFileWriter.getInstance().write(EMPLOYEES,filePath);
		LOGGER.log(Level.INFO, "Saving  unsorted data to the path : "+filePath);
		//save the fully sorted
		filePath = getFilePath(FileType.ALL_DATA_SORTED.getFileName());
		EMPLOYEES.sort(EmployeeAllDataComparator.getInstance());
		EmployeeDataFileWriter.getInstance().write(EMPLOYEES,filePath);
		LOGGER.log(Level.INFO, "Saving fully sorted data to the path : "+filePath);

		//save the ratio sorted
		filePath = getFilePath(FileType.EXPERIENCE_RATIO.getFileName());
		EMPLOYEES.sort(EmployeeExperienceAgeRatioComparator.getInstance());
		EmployeeDataFileWriter.getInstance().write(EMPLOYEES,filePath);
		LOGGER.log(Level.INFO, "Saving experience sorted data to the path : "+filePath);
		clearEmployees();
	}

	private String getFilePath(String fileName) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String suffix = fileName+"-"+now.format(formatter);
		return String.format(SAVE_PATH, suffix);
	}

	public synchronized void addEmployee(Employee employee) {
		EMPLOYEES.add(employee);
	}

	public synchronized void clearEmployees(){
		EMPLOYEES.clear();
	}
}
