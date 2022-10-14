package controller;

import state.StateManager;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditPresAction extends AbstractAction{

    public EditPresAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/editSlideIcon.png"));
        putValue(NAME, "Edit presentation");
        putValue(SHORT_DESCRIPTION, "Edit presentation");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().startEditState();
    }
}
