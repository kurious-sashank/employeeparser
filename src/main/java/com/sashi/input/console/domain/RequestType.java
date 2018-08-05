package com.sashi.input.console.domain;

public enum RequestType {
		EMPLOYEE_DATA, COMMAND_DATA;

		private RequestType() {
		}

		public static boolean contains(String command) {
			for (RequestType req : RequestType.values()) {
				if (req.name().equals(command)) {
					return true;
				}
			}
			return false;
		}
	}