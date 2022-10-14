package state;

import controller.listeners.RectangleListener;
import model.DiagramModel;
import view.MainFrame;
import view.repositoryView.SlajdView;

public class RectangelState implements State {

    @Override
    public void changePanel() {

    SlajdView slajdView = MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().getSelectedSlajdView();
        DiagramModel diagramModel = slajdView.getDiagramModel();
        slajdView.addMouseListener(new RectangleListener(slajdView,diagramModel));
    }
}
