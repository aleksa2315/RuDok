package view;

import repository.Slajd;
import state.StateManager;
import view.MainFrame;
import view.repositoryView.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SlideShowPanel extends JPanel {

    private CardLayout cardLayout = new CardLayout();
    private JButton sledeciBtn = new JButton("Sledeci slajd");
    private JButton prethodniBtn = new JButton("Prethodni slajd");
    private JToolBar toolBar;
    private ArrayList listaPanela = new ArrayList();
    private StateManager stateManager = new StateManager();

    public SlideShowPanel() {
        setLayout(new BorderLayout());
        this.toolBar = new JToolBar();
        this.toolBar.add(MainFrame.getInstance().getActionManager().getEditPresAction());
        this.add(toolBar, BorderLayout.NORTH);
        JPanel slideShow = new JPanel();
        this.add(slideShow, BorderLayout.CENTER);
        slideShow.setLayout(cardLayout);

        this.add(sledeciBtn, BorderLayout.EAST);
        this.add(prethodniBtn, BorderLayout.WEST);
        HashMap slajdViewHashMap = MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().getSlajdViewHashMap();

        for (int i = 0; i < MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().getPrezentacija().getChildren().size(); i++) {
            Slajd slajd = (Slajd) MainFrame.getInstance().getProjectView().getSelectedPrezentacijaView().getPrezentacija().getChildren().get(i);
            JPanel cardPanel = new JPanel(new BorderLayout());
            cardPanel.add(new JLabel(slajd.getName()),BorderLayout.NORTH);
            cardPanel.add((SlajdView) slajdViewHashMap.get(slajd),BorderLayout.CENTER);

            slideShow.add(cardPanel,i);
        }

        cardLayout.show(slideShow, "0");

        sledeciBtn.addActionListener(e -> {
            cardLayout.next(slideShow);
        });

        prethodniBtn.addActionListener(e -> {
            cardLayout.previous(slideShow);
        });
    }

    public void startEditState() {
        this.stateManager.setEditState();
    }

    public void startSlideShowState() {
        this.stateManager.setSlideShowState();
    }
}
