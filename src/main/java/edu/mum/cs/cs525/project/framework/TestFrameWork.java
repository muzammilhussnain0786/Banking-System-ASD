package edu.mum.cs.cs525.project.framework;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.factory.DataAccess;
import edu.mum.cs.cs525.project.framework.accounts.strategy.BalanceBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestFrameWork {
    public static void main(String[] args) {

        Account account = new Account("111", new BalanceBehaviour() {
            @Override
            public double getResult(double balance) {
                return 0;
            }
        });
        List<Account> l = new ArrayList<>();
        l.add(account);
        DataAccess.saveAccounts(l);
        DataAccess dataAccess = DataAccess.getInstance();
        //dataAccessFacade.saveNewMember(account);
        Map<String, Account> stringAccountMap = dataAccess.readAccountMap();

    }
}

