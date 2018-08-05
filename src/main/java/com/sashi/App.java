package com.sashi;

import com.sashi.input.console.impl.EmployeeDataConsoleReader;

public class App {
	public static void main(String[] args) {
		EmployeeDataConsoleReader.getInstance().read();
	}
}
