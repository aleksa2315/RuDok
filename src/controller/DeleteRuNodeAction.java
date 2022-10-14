package controller;

import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.node.RuNode;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DeleteRuNodeAction extends AbstractAction{

    public DeleteRuNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_DELETE, InputEvent.CTRL_DOWN_MASK));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
        putValue(SMALL_ICON,loadIcon("images/deleteIcon.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode node = MainFrame.getInstance().getTree().getSelectedPath();

        if (node instanceof Projekat){
            MainFrame.getInstance().getTree().delProject((Projekat) node);
        }else if (node instanceof Prezentacija){
            MainFrame.getInstance().getTree().delPrezentacija((Prezentacija) node);
        }else if(node instanceof Slajd){
            MainFrame.getInstance().getTree().delSlajd((Slajd) node);
        }

        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView();
    }
}
