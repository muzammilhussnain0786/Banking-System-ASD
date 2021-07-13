package edu.mum.cs.cs525.labs.exercises.project.ui.framework.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable<T> {
    List<Observer> observers = new ArrayList<>();

    default void attach(Observer<T> observer) {
        observers.add(observer);
    }

    default void remove(Observer<T> observer) {
        observers.remove(observer);
    }

    default void notifyObservers(T data) {
        for (Observer o : observers) {
            o.update(data);
        }
    }
}