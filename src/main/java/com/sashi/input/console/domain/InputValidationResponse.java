package com.sashi.input.console.domain;

import java.util.ArrayList;
import java.util.List;

public class InputValidationResponse {
	private String input;
	private List<String> messages = new ArrayList<>();
	private boolean valid;
	private RequestType requestType;

	public InputValidationResponse(String input, boolean valid) {
		this.input = input;
		this.valid = valid;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void addMessage(String message) {
		this.messages.add(message);
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
