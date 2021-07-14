package edu.mum.cs.cs525.project.framework.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Observable {

    Map<Class<?>, List<Observer>> observerHashmap = new HashMap<>();


    default void attach(Class<?> name, Observer<?> observer){
        observerHashmap.computeIfAbsent(name, k -> new ArrayList<>());
        observerHashmap.get(name).add(observer);
    }


    default void notifyObservers(Object data) {
        observerHashmap.get(data.getClass())
                .forEach(classObserver ->
                classObserver.update(data)
    );
    }
}
