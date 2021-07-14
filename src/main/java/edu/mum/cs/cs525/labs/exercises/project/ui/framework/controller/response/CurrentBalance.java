package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response;

public class CurrentBalance implements Response<Double> {
	public static final String NEGATIVE_BALANCE = "negative_balance";
	public static final String SUCCESS = "success";
	private double value;
	private String message;

	public CurrentBalance(double value, String message) {
		this.value = value;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Double getValue() {
		return value;
	}
}