package com.sashi.input.console.validator.field;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

public class AgeValidator implements IInputFieldValidator {
	private static AgeValidator validator = null;

	private AgeValidator() {

	}

	public static AgeValidator getInstance() {
		synchronized (AgeValidator.class) {
			if (validator == null) {
				validator = new AgeValidator();
			}
			return validator;
		}
	}
	@Override
	public InputValidationResponse validate(String input, InputValidationResponse response) {
		if(isFieldEmpty(input)){
			addFailureMessage(response, ValidationState.MISSING_AGE);
		}else if(!isInteger(input)){
			addFailureMessage(response, ValidationState.NOT_A_NUMBER);
		}else if(Integer.parseInt(input)<=0){
			addFailureMessage(response, ValidationState.INVALID_AGE);
		}
		return response;
	}

	@Override
	public void addFailureMessage(InputValidationResponse response, ValidationState state) {
		response.addMessage(state.getMessage());
		response.setValid(false);
	}
}
