package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverList {
    private List<Observer> observers;

    public ObserverList() {
        this.observers =  new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public boolean contains(Observer observer){
        boolean bool = true;
        for (Observer obs : observers){
            if (obs.equals(observer)){
                bool = true;
            }else {
                bool = false;
            }
        }
        return bool;
    }

    public boolean isEmpty(){
        if (observers.isEmpty()){
            return true;
        }else return false;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
