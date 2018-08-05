package com.sashi.input.console.validator.field;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface IInputFieldValidator {
	final static Logger LOGGER = Logger.getLogger(IInputFieldValidator.class.getName());
	default InputValidationResponse validate(String input,InputValidationResponse response){
		if(isFieldEmpty(input)){
			addFailureMessage(response);
		}
		return response;
	}

	default void addFailureMessage(InputValidationResponse response, ValidationState validationState){
		response.setValid(false);
		response.addMessage(validationState.getMessage());
	}

	default void addFailureMessage(InputValidationResponse response){
		response.setValid(false);
		response.addMessage(ValidationState.MISSING_FIELD.getMessage());
	}

	default boolean isFieldEmpty(String input){
		return input == null || input.isEmpty();
	}

	default boolean isInteger(String str) {
		boolean isNumber = false;
		try {
			Integer.parseInt(str);
			isNumber = true;
		} catch (NumberFormatException ex) {
			LOGGER.log(Level.INFO, str + " : is not an integer");
		}
		return isNumber;
	}

}
