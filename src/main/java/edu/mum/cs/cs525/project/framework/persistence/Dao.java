package edu.mum.cs.cs525.project.framework.persistence;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.model.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Dao<T> {

    List<T> entities = new ArrayList<>();

    public Optional<T> get(String id){
        return entities.stream().filter(x -> ((Account) x).getId() == id).findAny();
    }

    public List<T> getAll(){
        return entities;
    }

    public void save(T t){
        entities.add(t);
    };

    public void update(T t){
        delete(t);
        entities.add(t);
    }

    public void delete(T t) {
        Optional<T> any = get(((Account) t).getId());
        any.orElseThrow(IllegalArgumentException::new);
        any.ifPresent(value -> entities.remove(value));
    }
}