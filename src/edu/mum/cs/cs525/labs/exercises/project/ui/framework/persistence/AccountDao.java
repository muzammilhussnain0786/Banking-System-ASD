package edu.mum.cs.cs525.labs.exercises.project.ui.framework.persistence;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.observer.Observable;


public class AccountDao extends Dao<Account> implements Observable<Account> {
    @Override
    public void update(Account t){
        super.update(t);
        notifyObservers(t);
    }
}
