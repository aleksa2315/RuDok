package controller.listeners;

import jdk.jshell.Diag;
import model.DiagramModel;
import model.elements.RectangleElement;
import repository.Slajd;
import view.repositoryView.SlajdView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

public class RectangleListener implements MouseListener {
    private SlajdView slajdView;
    private DiagramModel diagramModel;

    public RectangleListener(SlajdView slajdView,DiagramModel diagramModel) {
        this.slajdView = slajdView;
        this.diagramModel = diagramModel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();
            GeneralPath gp=new GeneralPath();

            Paint fill = new Color(255,255,255);

            RectangleElement rectangle=new RectangleElement(position, new Dimension(100,50),
                    new BasicStroke(2f), fill);

            rectangle.setName("Rectangle " + diagramModel.getElementCount());
            diagramModel.addDiagramElements(rectangle);
            slajdView.repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
