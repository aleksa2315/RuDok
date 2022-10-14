package controller;

import errorHandler.ErrorHandlerImpl;
import errorHandler.ErrorType;
import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import repository.node.RuNode;
import view.MainFrame;
import view.repositoryView.PrezentacijaView;
import view.repositoryView.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class NewRuNodeAction extends AbstractAction{

    private int numberProjekat = 0;
    private int numberPrezentacija = 0;
    private int numberSlajd = 0;
    private ErrorHandlerImpl error;
    private ViewStorage viewStorage = MainFrame.getInstance().getViewStorage();

    public NewRuNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/plus.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
        error = new ErrorHandlerImpl();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode node = MainFrame.getInstance().getTree().getSelectedPath();

        if (node == null){
            error.generateError(ErrorType.NON_SELECTED);
        }

        if (node instanceof Workspace){
            Projekat projekat;

            if (((Workspace) node).getListaProjekata().isEmpty()){
                projekat = new Projekat("Projekat " + (((Workspace) node).getListaProjekata().size()+1) , node);

            }else{
                projekat = new Projekat("Projekat " + (((Workspace) node).getListaProjekata().size()+1) , node);

            }
            MainFrame.getInstance().getTree().addProject(projekat);
            viewStorage.putProjectView(projekat, new ProjectView(projekat));
            MainFrame.getInstance().setProjectView(viewStorage.getProjectView(projekat));

        }else if (node instanceof Projekat) {
            Prezentacija prezentacija;

            if (((Projekat) node).getListaPrezentacija().isEmpty()) {
                prezentacija = new Prezentacija("Prezentacija " + (((Projekat) node).getListaPrezentacija().size() + 1), node);
            } else {
                prezentacija = new Prezentacija("Prezentacija " + (((Projekat) node).getListaPrezentacija().size() + 1), node);
            }
            MainFrame.getInstance().getTree().addPrezentacija(prezentacija);
            viewStorage.putPrezentacijaView(prezentacija,viewStorage.getProjectView((Projekat) node).addTab(prezentacija));
            MainFrame.getInstance().setProjectView(viewStorage.getProjectView((Projekat) node));
        }else if (node instanceof Prezentacija) {
            Slajd slajd;

            if (((Prezentacija) node).getSlajdList().isEmpty()) {
                slajd = new Slajd("Slajd " + (((Prezentacija) node).getSlajdList().size() + 1), node);
            } else {
                slajd = new Slajd("Slajd " + (((Prezentacija) node).getSlajdList().size() + 1), node);
            }
            MainFrame.getInstance().getTree().addSlajd(slajd);
            viewStorage.putSlajdView(slajd, viewStorage.getPrezentacijaView((Prezentacija) node).addTab(slajd));
            viewStorage.getPrezentacijaView((Prezentacija) node).setup();
            viewStorage.getProjectView((Projekat) node.getParent()).setup();
        }
    }
}
