package repository;

import observer.Observer;
import repository.node.RuNode;
import repository.node.RuNodeComposite;

import java.util.ArrayList;

public class Workspace extends RuNodeComposite {

    public ArrayList listaProjekata = new ArrayList();

    public Workspace(String name){
        super(name, null);
    }

    @Override
    public void addChild(RuNode child) {
        if (child != null && child instanceof Projekat){
            Projekat projekat = (Projekat) child;
            if (!this.getChildren().contains(projekat)){
                this.getChildren().add(projekat);
            }
            listaProjekata.add(child);
        }
    }

    public ArrayList getListaProjekata() {
        return listaProjekata;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }


    @Override
    public void update(Object obj) {

    }
}
