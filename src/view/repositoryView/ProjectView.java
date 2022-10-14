package view.repositoryView;

import com.sun.tools.javac.Main;
import model.JTabbedPaneModel;
import observer.Observable;
import observer.Observer;
import observer.ObserverList;
import repository.Prezentacija;
import repository.Projekat;
import repository.node.RuNode;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectView extends JPanel implements Observer, Observable {
    private Projekat projekat;
    private JTabbedPaneModel jTabbedPane;
    private JLabel naslov;
    private HashMap<Prezentacija,PrezentacijaView> prezentacijaViewHashMap = new HashMap<>();
    private final ArrayList<Prezentacija> dodati = new ArrayList<>();
    private ArrayList<Projekat> projekti = new ArrayList<>();
    private ObserverList observerList = new ObserverList();

    public ProjectView(Projekat projekat){
        this.projekat = projekat;
        setupProjectView(projekat);
    }

    public ProjectView(){ this.setVisible(true);}

    private void createTabbedPane(){ this.jTabbedPane = new JTabbedPaneModel();}

    public PrezentacijaView addTab(Prezentacija prezentacija){
        if (!prezentacija.isShared()) {

            PrezentacijaView prezentacijaView = new PrezentacijaView(prezentacija);
            prezentacijaViewHashMap.put(prezentacija, prezentacijaView);
            this.jTabbedPane.addTab(prezentacija.getName(), prezentacijaView);

            return prezentacijaView;
        }else {
            PrezentacijaView prezentacijaView = new PrezentacijaView(prezentacija);
            prezentacijaView.setName(prezentacija.getName()+ ".Copy");
            prezentacijaViewHashMap.put(prezentacija, prezentacijaView);
            this.jTabbedPane.addTab(prezentacija.getName(), prezentacijaView);
            return prezentacijaView;
        }

    }


    private void setupProjectView(Projekat projekat){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.naslov = new JLabel(projekat.getName());
        this.add(BorderLayout.NORTH, this.naslov);
        this.createTabbedPane();

        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(this.jTabbedPane);
        this.add(jPanel);
        this.setVisible(true);

        if (projekat.getAdded() != null){
            for (RuNode node : projekat.getChildren()){
                    this.dodati.add((Prezentacija) node);
                    this.jTabbedPane.addTab(node.getName(), prezentacijaViewHashMap.get(node));
            }
        }
        
    }

    public void setup(){ this.setupProjectView(this.projekat);}

    public PrezentacijaView getPrezentacijaView(Prezentacija prezentacija){return prezentacijaViewHashMap.get(prezentacija);}

    public String getLabel(){return projekat.toString();}

    public PrezentacijaView getSelectedPrezentacijaView(){
        PrezentacijaView prezentacijaView = (PrezentacijaView) this.jTabbedPane.getSelectedComponent();
        return prezentacijaView;
    }

    public Projekat getProjekat() {
        return projekat;
    }

    @Override
    public void update(Object obj) {
        setup();

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
        for(Observer observer : observerList.getObservers()){
            observer.update(this);
        }
    }

    public ArrayList<Prezentacija> getDodati() {
        return dodati;
    }
}





























