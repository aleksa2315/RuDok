package controller;

import errorHandler.ErrorHandlerImpl;
import errorHandler.ErrorType;
import repository.Prezentacija;
import repository.Projekat;
import repository.node.RuNode;
import view.MainFrame;
import view.ShareDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ShareNodeAction extends AbstractAction{

    private ArrayList<Projekat> projects;
    private RuNode node;
    private ErrorHandlerImpl error = new ErrorHandlerImpl();;

    public ShareNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/shareIcon.png"));
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        node = MainFrame.getInstance().getTree().getSelectedPath();

        if (!(node instanceof Prezentacija)){
            error.generateError(ErrorType.NOT_PREZENTACIJA);
        }else {
            ShareDialog shareDialog = new ShareDialog((Frame) MainFrame.getInstance().getParent(),"Podeli dokument");
            shareDialog.setVisible(true);

        }
    }
}
