package edu.mum.cs.cs525.project.framework.accounts.facade;

import edu.mum.cs.cs525.project.framework.accounts.factory.AccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.DatabaseAccountDAO;
import edu.mum.cs.cs525.project.framework.accounts.factory.MemoryAccountDAO;

public class DatabaseAccountService extends AbstractAccountService{
    @Override
    protected AccountDAO createAccountDAO() {
        return new DatabaseAccountDAO();
    }

}
