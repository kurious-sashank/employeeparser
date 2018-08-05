package com.sashi.input.console.domain;

public enum Command {
		SORT,
		EXIT;

		private Command() {
		}

		public static boolean contains(String input) {
			for (Command command : Command.values()) {
				if (command.name().equals(input)) {
					return true;
				}
			}
			return false;
		}
	}