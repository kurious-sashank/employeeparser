package com.sashi.parser;

import com.sashi.input.console.domain.Command;
import com.sashi.input.console.exception.EndConsoleInputException;
import com.sashi.input.console.repository.EmployeeDataRepository;

public class CommandHandler implements IRequestHandler {

	private static CommandHandler handler = null;
	private CommandHandler(){

	}

	public static CommandHandler getInstance(){
		synchronized (CommandHandler.class){
			if(handler ==null){
				handler = new CommandHandler();
			}
			return handler;
		}
	}
	@Override
	public void handle(String input) throws EndConsoleInputException{
		Command command = Command.valueOf(input);
      switch (command){
	      case EXIT:
	      	throw new EndConsoleInputException("Recieved 'EXIT' command");
	      case SORT:
		      EmployeeDataRepository.getInstance().sort();
      }
	}
}
