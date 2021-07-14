package edu.mum.cs.cs525.project.framework.controller.response;

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
