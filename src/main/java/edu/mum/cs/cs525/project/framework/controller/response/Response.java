package edu.mum.cs.cs525.project.framework.controller.response;

public interface Response<A> {
	String getMessage();
	A getValue();
}
