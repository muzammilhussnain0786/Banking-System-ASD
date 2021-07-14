package edu.mum.cs.cs525.project.framework.persistence;


import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.observer.Observable;

public class AccountDao extends Dao<Account> implements Observable<Account> {
    @Override
    public void update(Account t){
        super.update(t);
        notifyObservers(t);
    }
}
