package edu.mum.cs.cs525.project.framework.accounts.facade;

import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.DatabaseAccountDAO;

public class DatabaseAccountService extends AbstractAccountService{

    private static final DatabaseAccountService INSTANCE = new DatabaseAccountService();

    public static DatabaseAccountService getInstance(){
        return INSTANCE;
    }

    private DatabaseAccountService(){
        super();
    }

    @Override
    protected AccountDAO createAccountDAO() {
        return new DatabaseAccountDAO();
    }

}
