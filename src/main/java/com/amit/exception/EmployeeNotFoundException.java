package com.amit.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		// TODO Auto-generated constructor stub
		super();

	}

	public EmployeeNotFoundException(String message) {
		// TODO Auto-generated constructor stub

		super(message);
	}

}
