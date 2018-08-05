package com.sashi.input.console.validator;

import com.sashi.input.console.domain.InputValidationResponse;

public interface IInputValidator {
	public InputValidationResponse validate(String input, InputValidationResponse response);
}
