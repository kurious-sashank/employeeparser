package com.sashi.input.console.validator;

import com.sashi.input.console.domain.InputValidationResponse;
import com.sashi.input.console.domain.RequestType;
import com.sashi.input.console.domain.ValidationState;
import com.sashi.input.console.validator.field.AgeValidator;
import com.sashi.input.console.validator.field.ExperienceValidator;
import com.sashi.input.console.validator.field.NameValidator;
import com.sashi.input.console.validator.field.OrganizationValidator;

import java.util.logging.Logger;

public class EmployeeInputValidator implements IInputValidator {
	private final static Logger LOGGER = Logger.getLogger(EmployeeInputValidator.class.getName());
	private static final int FIELD_COUNT = 5;

	@Override
	public InputValidationResponse validate(String input, InputValidationResponse response) {
		String[] empData = input.split(", ");
		if (!response.isValid()) {
			response.setValid(true);
			if (empData.length < FIELD_COUNT) {
				response.setValid(false);
				response.addMessage(ValidationState.INVALID_INPUT.getMessage());
			}
			else if (isEmployeeDataValid(response, empData)) {
				response.setValid(true);
				response.addMessage(ValidationState.VALID.getMessage());
			}
			response.setRequestType(RequestType.EMPLOYEE_DATA);
		}
		return response;
	}

	private boolean isEmployeeDataValid(InputValidationResponse response, String[] empData) {
		boolean result = true;

		for (int i = 0; i < FIELD_COUNT; i++) {
			String fieldData = empData[i].trim();
			switch (i) {
				case 0:
				case 1:
					result &= NameValidator.getInstance().validate(fieldData, response).isValid();
					break;
				case 4:
					result &= OrganizationValidator.getInstance().validate(fieldData, response).isValid();
					break;
				case 2:
					result &= ExperienceValidator.getInstance().validate(fieldData, response).isValid();
					break;
				case 3:
					result &= AgeValidator.getInstance().validate(fieldData, response).isValid();
					break;
			}
			if (!result) {
				response.setValid(false);
				response.addMessage(ValidationState.INVALID_INPUT.getMessage());
				return result;
			}
		}
		if(!isAgeExperienceRatioValid(Integer.parseInt(empData[2]), Integer.parseInt(empData[3]))){
			response.setValid(false);
			response.addMessage(ValidationState.INVALID_AGE_EXPRIENCE_RATIO.getMessage());
			result = false;
		}
		return result;
	}

	private boolean isAgeExperienceRatioValid(int experience, int age){
		return age*12>experience;
	}

}
