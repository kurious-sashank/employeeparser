package com.sashi.input.console.output.file;

import com.sashi.input.console.model.Employee;
import com.sashi.input.console.repository.EmployeeDataRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeDataFileWriter implements IDataWriter {
	private static EmployeeDataFileWriter fileWriter = null;

	private EmployeeDataFileWriter(){

	}

	public static EmployeeDataFileWriter getInstance(){
		synchronized (EmployeeDataFileWriter.class){
			if(fileWriter ==null){
				fileWriter = new EmployeeDataFileWriter();
			}
			return fileWriter;
		}
	}
	public void write(List<Employee> employees, String filePath){
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		try(FileWriter fw = new FileWriter(file,true);)
		{
			for(Employee employee: employees) {
				fw.write(employee.toString()+"\n");//appends the string to the file
			}
		}
		catch(IOException ioe)
		{
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
