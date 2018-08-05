package com.sashi.parser;

import com.sashi.input.console.exception.EndConsoleInputException;

public interface IRequestHandler {
	public void handle(String input) throws EndConsoleInputException;
}
