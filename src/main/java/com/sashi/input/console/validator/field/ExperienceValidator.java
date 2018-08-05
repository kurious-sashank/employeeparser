package com.sashi.input.console.validator.field;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

public class ExperienceValidator implements IInputFieldValidator {
	private static ExperienceValidator validator = null;

	private ExperienceValidator() {

	}

	public static ExperienceValidator getInstance() {
		synchronized (ExperienceValidator.class) {
			if (validator == null) {
				validator = new ExperienceValidator();
			}
			return validator;
		}
	}
	@Override
	public InputValidationResponse validate(String input, InputValidationResponse response) {
		if(isFieldEmpty(input)){
			addFailureMessage(response, ValidationState.MISSING_EXPERIENCE);
		}else if(!isInteger(input)){
			addFailureMessage(response, ValidationState.NOT_A_NUMBER);
		}else if(Integer.parseInt(input)<0){
			addFailureMessage(response, ValidationState.INVALID_EXPERIENCE);
		}
		return response;
	}

	@Override
	public void addFailureMessage(InputValidationResponse response, ValidationState state) {
		response.addMessage(state.getMessage());
		response.setValid(false);
	}
}
