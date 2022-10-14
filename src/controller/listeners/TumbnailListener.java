package controller.listeners;

import repository.Prezentacija;
import view.TumbnailSlika;
import view.repositoryView.PrezentacijaView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TumbnailListener implements MouseListener {
    private PrezentacijaView prezentacija;
    private TumbnailSlika slika;

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getClickCount() == 2 ){
            prezentacija.getjTabbedPane().setSelectedComponent(slika.getSlajdView());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    public TumbnailListener(PrezentacijaView prezentacija, TumbnailSlika slika) {
        this.prezentacija = prezentacija;
        this.slika = slika;
    }
}
