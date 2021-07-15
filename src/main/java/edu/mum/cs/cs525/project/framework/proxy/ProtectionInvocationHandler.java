package edu.mum.cs.cs525.project.framework.proxy;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.AccountEntry;

public class ProtectionInvocationHandler implements InvocationHandler {
	Object IAcc;

	public ProtectionInvocationHandler(Object ob) {
		this.IAcc = ob;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("\n=====================================");
		  System.out.println(String.format("[LOG] Calling method %s with args: %s",
	                method.getName(), Arrays.toString(args)));

		if (args != null) {
			Account a = (Account) args[0];
			List<AccountEntry> accounts = a.getEntryList().stream().collect(Collectors.toList());
			double amount = accounts.get(accounts.size() - 1).getAmount();
			try {
				if (amount > 0) {
					return method.invoke(IAcc, args);
				} else if (amount <= 0) {
					throw new IllegalAccessException();
				}
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return method.invoke(IAcc, args);
	}

}