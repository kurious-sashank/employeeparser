package com.sashi.input.console.validator.field;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.ValidationState;

public class OrganizationValidator implements IInputFieldValidator {
	private static OrganizationValidator validator = null;

	private OrganizationValidator() {

	}

	public static OrganizationValidator getInstance() {
		synchronized (OrganizationValidator.class) {
			if (validator == null) {
				validator = new OrganizationValidator();
			}
			return validator;
		}
	}
	@Override
	public void addFailureMessage(InputValidationResponse response) {
		response.setValid(false);
		response.addMessage(ValidationState.MISSING_ORGANIZATION.getMessage());
	}
}
