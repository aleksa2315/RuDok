package controller;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RectangleAction extends AbstractAction{


    public RectangleAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/rectangleIcon.png"));
        putValue(NAME, "Rectangle");
        putValue(SHORT_DESCRIPTION, "Draw rectangle");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().startRectangleState();
    }
}
