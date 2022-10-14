package state;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class EditState implements State{

    @Override
    public void changePanel() {
        MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().startEditState();
    }
}
