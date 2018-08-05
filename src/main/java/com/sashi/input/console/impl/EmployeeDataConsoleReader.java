package com.sashi.input.console.impl;

import com.sashi.input.IInputReader;
import com.sashi.input.console.exception.EndConsoleInputException;
import com.sashi.input.console.validator.ConsoleInputValidationManager;
import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.parser.DataHandlerManager;
import com.sashi.input.console.domain.HandlerRequest;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDataConsoleReader implements IInputReader {
	private final static Logger LOGGER = Logger.getLogger(EmployeeDataConsoleReader.class.getName());

	private static final Scanner SCANNER = new Scanner(System.in);

	private static EmployeeDataConsoleReader consoleReader = null;
	private EmployeeDataConsoleReader(){

	}

	public static EmployeeDataConsoleReader getInstance(){
		synchronized (EmployeeDataConsoleReader.class){
			if(consoleReader ==null){
				consoleReader = new EmployeeDataConsoleReader();
			}
			return consoleReader;
		}
	}
	public void read() {
		LOGGER.log(Level.INFO,"Input here >>> ");
		String input = SCANNER.nextLine();
		InputValidationResponse response = ConsoleInputValidationManager.getInstance().validate(input);
		if(response.isValid()){
			// push to global queue
			HandlerRequest request = new HandlerRequest();
			request.setInput(input);
			request.setRequestType(response.getRequestType());
			try {
				DataHandlerManager.getInstance().handle(request);
			}catch (EndConsoleInputException ex){
				LOGGER.log(Level.SEVERE,ex.getMessage());
				System.exit(1);
			}catch(Exception ex){
				LOGGER.log(Level.SEVERE,ex.getMessage(), ex);
			}
		}else{
			for (String message :response.getMessages()) {
				LOGGER.log(Level.SEVERE, message);
			}
		}
		read();
	}

}
