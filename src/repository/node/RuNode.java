package repository.node;

import observer.Observable;
import observer.Observer;

public abstract class RuNode implements Observer, Observable {
    private String name;
    private RuNode parent;

    public RuNode(String name, RuNode parent){
        this.parent = parent;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof RuNode) {
            RuNode otherObj = (RuNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }
}
