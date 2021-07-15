package edu.mum.cs.cs525.project.framework.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {

	private final Object invocationTarget;

	public LoggingInvocationHandler(Object invocationTarget) {
		this.invocationTarget = invocationTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      
//
//		System.out.println("\n=====================================");
//		  System.out.println(String.format("[LOG] Calling method %s with args: %s",
//	                method.getName(), Arrays.toString(args)));
//		  
//		System.out.println("[LOG] " + getClass() + ".invoke() start.....");
//		System.out.println("[LOG] \n" + "Target Object method to call:" + method);
//		if (args != null) {
//			System.out.println("[LOG] \n" + "Arguments passed to the method to call the target object: " + args[0]);
//		}
//
//		try {
//			return method.invoke(invocationTarget, args);
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			System.out.println("[LOG] " + getClass() + ".invoke() end.....");
//			System.out.println("=====================================\n");
//		}
		System.out.println(String.format("Calling method %s with args: %s",
                method.getName(), Arrays.toString(args)));
        return method.invoke(invocationTarget, args);
	}

}