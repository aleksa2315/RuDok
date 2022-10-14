package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractAction{

    public MoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/moveIcon.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move shape");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
