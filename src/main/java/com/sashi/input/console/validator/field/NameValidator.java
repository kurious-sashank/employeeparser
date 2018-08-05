package com.sashi.input.console.validator.field;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

public class NameValidator implements IInputFieldValidator {

	private static NameValidator validator = null;

	private NameValidator() {

	}

	public static NameValidator getInstance() {
		synchronized (NameValidator.class) {
			if (validator == null) {
				validator = new NameValidator();
			}
			return validator;
		}
	}
	@Override
	public void addFailureMessage(InputValidationResponse response) {
		response.addMessage(ValidationState.MISSING_NAME.getMessage());
		response.setValid(false);
	}
}
