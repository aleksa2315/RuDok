package view;

import controller.listeners.TumbnailListener;
import repository.Prezentacija;
import repository.Slajd;
import view.repositoryView.PrezentacijaView;
import view.repositoryView.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TumbnailSlika extends JComponent {
    private Slajd slajd;
    private SlajdView slajdView;
    private PrezentacijaView prezentacija;
    private TumbnailListener tumbnailListener;

    public TumbnailSlika(Slajd slajd, SlajdView slajdView,PrezentacijaView prezentacija) {
        this.slajd = slajd;
        this.slajdView = slajdView;
        this.prezentacija = prezentacija;
        tumbnailListener = new TumbnailListener(prezentacija,this);
        addMouseListener(tumbnailListener);

        BufferedImage img = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = img.createGraphics();
        slajdView.print(graphics2D);
        graphics2D.dispose();

        this.setLayout(new BorderLayout());
        this.add(new JLabel(slajd.getName()),BorderLayout.NORTH);
        this.add(new JLabel(new ImageIcon(img)));


    }

    public SlajdView getSlajdView() {
        return slajdView;
    }
}
