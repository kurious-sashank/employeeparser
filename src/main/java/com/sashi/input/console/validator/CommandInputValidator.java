package com.sashi.input.console.validator;

import com.sashi.input.console.domain.Command;
import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.RequestType;
import com.sashi.input.console.domain.ValidationState;

public class CommandInputValidator implements IInputValidator {

	@Override
	public InputValidationResponse validate(String input, InputValidationResponse response) {
		if(!response.isValid()) {
			String[] inputs = input.split(",");
			boolean result = inputs.length == 1 && Command.contains(input);
			response.setValid(result);
			if (!result) {
				response.addMessage(ValidationState.INVALID_INPUT.getMessage());
			} else {
				response.setValid(true);
				response.addMessage(ValidationState.VALID.getMessage());
				response.setRequestType(RequestType.COMMAND_DATA);
			}
		}
		return response;
	}
}
