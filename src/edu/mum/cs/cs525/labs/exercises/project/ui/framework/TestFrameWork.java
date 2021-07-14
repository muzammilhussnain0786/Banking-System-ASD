package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.persistence.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.service.EmailSenderService;

public class TestFrameWork {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        accountDao.attach(new EmailSenderService());

        Account account1 = new ConcreteAccount();
        accountDao.save(account1);
        accountDao.get(account1.getId());
        account1.setCurrentBalance(12);
        accountDao.update(account1);
        accountDao.get(account1.getId());
    }
}

class ConcreteAccount extends Account  {

    @Override
    public void addInterest() {

    }

    @Override
    public double getInterest() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return null;
    }
}
