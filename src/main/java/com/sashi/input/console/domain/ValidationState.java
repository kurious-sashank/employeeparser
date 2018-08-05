package com.sashi.input.console.domain;

public enum ValidationState {
	VALID("Data is valid"),
	EMPTY_INPUT("Input is empty."),
	NOT_A_NUMBER("Input is not a valid number"),
	INVALID_AGE("Age must be greater than 0"),
	INVALID_EXPERIENCE("Experience must be greater than 0"),
	INVALID_AGE_EXPRIENCE_RATIO("Experience cannot be less than age"),
	MISSING_NAME("Name can not be empty"),
	MISSING_ORGANIZATION("Organization can not be empty"),
	MISSING_AGE("Age can not be empty"),
	MISSING_EXPERIENCE("Experience can not be empty"),
	MISSING_FIELD("Field data can not be empty"),
	INVALID_INPUT("Employee data is incomplete or the Command is not valid. Employee data template : 'FirstName, LastName, Experience, Age, Organization'. Command List: SORT, EXIT");

	private String message;

	private ValidationState(String message) {
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
