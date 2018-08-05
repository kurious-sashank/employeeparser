package com.sashi.input.console.validator;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputValidationManager {
	private static final List<IInputValidator> VALIDATORS = Arrays.asList(new CommandInputValidator(), new EmployeeInputValidator());
	private static ConsoleInputValidationManager validationManager = null;

	private ConsoleInputValidationManager() {

	}

	public static ConsoleInputValidationManager getInstance() {
		synchronized (ConsoleInputValidationManager.class) {
			if (validationManager == null) {
				validationManager = new ConsoleInputValidationManager();
			}
			return validationManager;
		}
	}

	public InputValidationResponse validate(String input) {
		InputValidationResponse response = new InputValidationResponse(input, false);
		if (input == null || input.isEmpty()) {
			response.addMessage(ValidationState.EMPTY_INPUT.getMessage());
			response.setValid(false);
		} else {
			VALIDATORS.stream().forEach(validator -> validator.validate(input, response));
		}
		return response;
	}
}
