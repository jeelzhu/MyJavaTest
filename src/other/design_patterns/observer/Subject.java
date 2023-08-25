package other.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<Observer> observers = new ArrayList<>();

    public void update(){
        observers.forEach(observer -> observer.update("subject is updated"));
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }


}
