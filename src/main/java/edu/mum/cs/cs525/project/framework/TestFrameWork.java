package edu.mum.cs.cs525.project.framework;

import edu.mum.cs.cs525.project.framework.persistence.AccountDao;

public class TestFrameWork {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        //accountDao.attach(new EmailSenderService());

//        Account account1 = new Account(1L,"me", "me", LocalDate.of(2021,7,7), LocalDate.of(2021,7,7), 11.0);
//        accountDao.save(account1);
//        accountDao.get(account1.getId());
//        account1.setCurrentBalance(12);
//        accountDao.update(account1);
//        accountDao.get(account1.getId());
    }
}
