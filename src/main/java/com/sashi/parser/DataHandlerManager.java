package com.sashi.parser;

import com.sashi.input.console.domain.HandlerRequest;
import com.sashi.input.console.domain.RequestType;
import com.sashi.input.console.exception.EndConsoleInputException;

import java.util.HashMap;
import java.util.Map;

public class DataHandlerManager {

	private static final Map<RequestType, IRequestHandler> PARSER_BY_REQUEST_TYPE = new HashMap<>();
	private static DataHandlerManager handlerManager = null;
	private DataHandlerManager(){

	}

	public static DataHandlerManager getInstance(){
		synchronized (DataHandlerManager.class){
			if(handlerManager ==null){
				handlerManager = new DataHandlerManager();
			}
			return handlerManager;
		}
	}
	static {

		PARSER_BY_REQUEST_TYPE.put(RequestType.EMPLOYEE_DATA,EmployeeDataHandler.getInstance());
		PARSER_BY_REQUEST_TYPE.put(RequestType.COMMAND_DATA,CommandHandler.getInstance());
	}
	public  void handle(HandlerRequest handlerRequest) throws EndConsoleInputException {
		PARSER_BY_REQUEST_TYPE.get(handlerRequest.getRequestType()).handle(handlerRequest.getInput());
	}
}
