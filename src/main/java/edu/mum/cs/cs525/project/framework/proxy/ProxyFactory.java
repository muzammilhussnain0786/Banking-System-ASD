package edu.mum.cs.cs525.project.framework.proxy;
import java.lang.reflect.Proxy;

import edu.mum.cs.cs525.project.framework.accounts.facade.IAccountService;


public class ProxyFactory {
	public static Object newInstance(Object ob) {
		return Proxy.newProxyInstance(ob.getClass().getClassLoader(),
				new Class<?>[] { IAccountService.class }, new LoggingInvocationHandler(ob));
	}
}