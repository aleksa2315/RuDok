package repository;

import observer.Observer;
import repository.node.RuNode;
import repository.node.RuNodeComposite;
import view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Projekat extends RuNodeComposite {

    private RuNode added;
    private boolean changed;
    private ArrayList listaPrezentacija = new ArrayList();


    public Projekat(String name, RuNode node){
        super(name, node);
        this.changed = true;
    }

    @Override
    public void addChild(RuNode child) {
            if (child != null &&  child instanceof Prezentacija){
            Prezentacija prezentacija = (Prezentacija) child;
            if (!this.getChildren().contains(prezentacija)){
                this.getChildren().add(prezentacija);
                added = prezentacija;
                listaPrezentacija.add(prezentacija);
            }
        }
    }

    public RuNode getAdded() {
        return added;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public ArrayList getListaPrezentacija() {
        return listaPrezentacija;
    }

    public String toString(){
        return this.getName();
    }

    public void setChanged(boolean changed){
        if (this.changed != changed){
            this.changed = changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        }
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
