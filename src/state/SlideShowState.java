package state;

import view.MainFrame;
import view.SlideShowPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class SlideShowState implements State{

    @Override
    public void changePanel() {
        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().startSlideShowState();
    }
}
