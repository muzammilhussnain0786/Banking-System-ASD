package edu.mum.cs.cs525.project.bank.persistence;

import edu.mum.cs.cs525.project.framework.accounts.facade.AbstractAccountService;
import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;

public class MongoAccountService extends AbstractAccountService {

    private static final MongoAccountService INSTANCE = new MongoAccountService();

    public static MongoAccountService getInstance(){
        return INSTANCE;
    }

    private MongoAccountService(){
        super();
    }

    @Override
    protected AccountDAO createAccountDAO() {
        return new MongoAccountDao();
    }
}
