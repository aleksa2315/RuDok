package repository;

import observer.Observer;
import observer.ObserverList;
import repository.node.RuNode;
import repository.node.RuNodeComposite;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Prezentacija extends RuNodeComposite {

    private ArrayList slajdList = new ArrayList();
    private String autor = "Aleksa";
    private String slika = "backgroundImages/download.jpg";
    private ObserverList observerList;
    private boolean shared = false;

    public Prezentacija(String name, RuNode parent) {
        super(name, parent);
        this.observerList = new ObserverList();
        System.out.println(autor);
    }

    @Override
    public void addChild(RuNode child) {
            if (child != null && child instanceof Slajd){
                Slajd slajd = (Slajd) child;

                if (!this.getChildren().contains(slajd)){
                    this.getChildren().add(slajd);
                    slajdList.add(slajd);
                }
            }
    }

    public ArrayList getSlajdList() {
        return slajdList;
    }

    public void ucitajSliku(){}

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifyObservers();
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList.getObservers()){
            observer.update(this);
        }
    }

    @Override
    public void update(Object obj) {

    }

    public String getImeSlike(){
        String[] ime = slika.split("/");
        return ime[1];
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
