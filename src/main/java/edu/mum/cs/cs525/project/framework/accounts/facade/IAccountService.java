package edu.mum.cs.cs525.project.framework.accounts.facade;

import edu.mum.cs.cs525.project.framework.accounts.Account;

import java.util.Collection;

public interface IAccountService {

    Account createAccount(Account account);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void executeBalanceBehaviour(String description);
    String generateReports();
}
