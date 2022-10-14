package controller;

import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import view.repositoryView.PrezentacijaView;
import view.repositoryView.ProjectView;
import view.repositoryView.SlajdView;

import java.util.HashMap;

public class ViewStorage {
    private HashMap<Projekat, ProjectView> projectViewHashMap = new HashMap<>();
    private HashMap<Prezentacija, PrezentacijaView> prezentacijaViewHashMap = new HashMap<>();
    private HashMap<Slajd, SlajdView> slajdViewHashMap = new HashMap<>();

    public void putProjectView(Projekat projekat, ProjectView projectView){this.projectViewHashMap.put(projekat,projectView);}

    public void putPrezentacijaView(Prezentacija prezentacija, PrezentacijaView prezentacijaView){
        this.prezentacijaViewHashMap.put(prezentacija, prezentacijaView);
    }

    public void putSlajdView(Slajd slajd, SlajdView slajdView){this.slajdViewHashMap.put(slajd,slajdView);}

    public HashMap<Projekat, ProjectView> getProjectViewHashMap() {
        return projectViewHashMap;
    }

    public HashMap<Prezentacija, PrezentacijaView> getPrezentacijaViewHashMap() {
        return prezentacijaViewHashMap;
    }

    public HashMap<Slajd, SlajdView> getSlajdViewHashMap() {
        return slajdViewHashMap;
    }

    public ProjectView getProjectView(Projekat projekat){return projectViewHashMap.get(projekat);}

    public PrezentacijaView getPrezentacijaView(Prezentacija prezentacija){return prezentacijaViewHashMap.get(prezentacija);}

    public SlajdView getSlajdView(Slajd slajd){return slajdViewHashMap.get(slajd);}
}
