package edu.mum.cs.cs525.labs.exercises.project.ui.framework.controller.response;

public class DoneResult implements Response {

	Object value;

	public DoneResult() {

	}
	public DoneResult(Object value) {
		this.value = value;
	}
	@Override
	public String getMessage() {
		return CurrentBalance.SUCCESS; // TODO Do something else!
	}

	@Override
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
