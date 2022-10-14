package repository;

import observer.Observer;
import repository.node.RuNode;
import repository.node.RuNodeComposite;
import view.MainFrame;

import javax.swing.*;

public class Slajd extends RuNodeComposite {

    private boolean changed;

    public Slajd(String name, RuNode node){
        super(name,node);
    }

    @Override
    public void addChild(RuNode child) {
    }

    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
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
