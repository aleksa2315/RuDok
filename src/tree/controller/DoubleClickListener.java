package tree.controller;

import controller.ViewStorage;
import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import repository.node.RuNode;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickListener implements MouseListener {

    private final JTree workspaceTree;
    private final ViewStorage viewStorage = MainFrame.getInstance().getViewStorage();

    public DoubleClickListener(JTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            RuNode item = MainFrame.getInstance().getTree().getSelectedPath();

            if (item instanceof Workspace){
            }else if (item instanceof Projekat){
                viewStorage.getProjectView((Projekat) item).setup();
                MainFrame.getInstance().setProjectView(viewStorage.getProjectView((Projekat) item));
            }else if (item instanceof Prezentacija){
                viewStorage.getPrezentacijaView((Prezentacija) item).setup();
            }else if (item instanceof Slajd){
                viewStorage.getSlajdView((Slajd) item);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
