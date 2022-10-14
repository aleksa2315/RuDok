package controller;

import com.sun.tools.javac.Main;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SlideShowAction extends AbstractAction{

    public SlideShowAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F9, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("images/slideShowImg.png"));
        putValue(NAME, "Slideshow");
        putValue(SHORT_DESCRIPTION, "Start slideshow");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().startSlideShowState();
    }
}
