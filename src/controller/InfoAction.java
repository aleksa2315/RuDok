package controller;

import view.InfoPanel;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractAction{

    private InfoPanel infoPanel;

    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/infoIcon.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoPanel = new InfoPanel(MainFrame.getInstance(),"Info");
        infoPanel.setVisible(true);
    }
}
