package view.repositoryView;

import controller.listeners.RectangleListener;
import model.DiagramModel;
import model.JTabbedPaneModel;
import model.elements.DiagramDevice;
import observer.Observer;
import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.node.RuNode;
import view.painters.ElementPainter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Iterator;

public class SlajdView extends JPanel implements Observer {
    private Slajd slajd;
    private JTabbedPane tabbedPane;
    private JLabel naslov;
    private RuNode dodati;
    private JDesktopPane content;
    private JLabel slika;
    private String putanjaSlika;
    private DiagramModel diagramModel;

    public SlajdView(Slajd slajd) {
        this.diagramModel = new DiagramModel();
        addMouseListener(new RectangleListener(this,diagramModel));
        this.slajd = slajd;
        this.naslov = new JLabel(slajd.getName());


        Prezentacija prezentacija = (Prezentacija) slajd.getParent();
        putanjaSlika = prezentacija.getSlika();
        prezentacija.addObserver(this);

        this.content = new JDesktopPane(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getToolkit().getImage("src/repository/" + putanjaSlika), 0, 0, getWidth(), getHeight(), null);
                Graphics2D g2 = (Graphics2D) g;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                Iterator<DiagramDevice> it = diagramModel.getDeviceIterator();
                while (it.hasNext()) {
                    DiagramDevice d = (DiagramDevice) it.next();
                    ElementPainter painter = d.getPainter();
                    painter.paint(g2, d);
                    this.updateUI();
                }
                updateUI();
            }
        };
        this.content.setVisible(true);


        this.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(this.content, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    public JDesktopPane getContent(){
        return this.content;
    }

    @Override
    public void update(Object obj) {
        putanjaSlika = ((Prezentacija)obj).getSlika();
        updateUI();
        repaint();
    }

    public DiagramModel getDiagramModel() {
        return diagramModel;
    }
}
