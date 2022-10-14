package view.repositoryView;

import com.sun.tools.javac.Main;
import controller.listeners.TumbnailListener;
import model.JTabbedPaneModel;
import observer.Observable;
import observer.Observer;
import observer.ObserverList;
import repository.Prezentacija;
import repository.Slajd;
import repository.node.RuNode;
import state.StateManager;
import view.MainFrame;
import view.SlideShowPanel;
import view.TumbnailSlika;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class PrezentacijaView extends JPanel implements Observer, Observable {

    private Prezentacija prezentacija;
    private JTabbedPaneModel jTabbedPane;
    private JLabel autor;
    private String autorString;
    private HashMap<Slajd, SlajdView> slajdViewHashMap = new HashMap<>();
    private final ArrayList<Slajd> dodati = new ArrayList<>();
    private JToolBar toolBar;
    private StateManager stateManager;
    private SlideShowPanel slideShowPanel;
    private JPanel editPanel;
    private ObserverList observerList = new ObserverList();

    public PrezentacijaView(Prezentacija prezentacija){
            this.prezentacija = prezentacija;
            setupPrezentacijaView(prezentacija);
            this.prezentacija.addObserver(this);
            this.autorString = prezentacija.getAutor();
            this.stateManager = new StateManager();
    }

    private void createTabbedPane(){this.jTabbedPane = new JTabbedPaneModel();}

    public  SlajdView addTab(Slajd slajd) {

        SlajdView slajdView = new SlajdView(slajd);
        slajdViewHashMap.put(slajd,slajdView);
        this.jTabbedPane.addTab(prezentacija.getName(), slajdView);

        return slajdView;
    }

    private void setupPrezentacijaView(Prezentacija prezentacija){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.autor = new JLabel(prezentacija.getAutor());
        this.add(BorderLayout.SOUTH, this.autor);
        this.createTabbedPane();

        JToolBar toolBar = new JToolBar();
        this.add(toolBar,BorderLayout.NORTH);
        toolBar.add(MainFrame.getInstance().getActionManager().getRectangleAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getMoveAction());
        toolBar.addSeparator();
        toolBar.add(MainFrame.getInstance().getActionManager().getSlideShowAction());

        JPanel slidePanel = new JPanel(new BorderLayout());
        JPanel tumbPanel = new JPanel();
        tumbPanel.setLayout(new BoxLayout(tumbPanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(tumbPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,slidePanel);
        splitPane.setDividerLocation(150);
        splitPane.setOneTouchExpandable(true);
        slidePanel.add(this.jTabbedPane);

        this.add(splitPane,BorderLayout.CENTER);
        this.setVisible(true);
        if (prezentacija.getChildren() != null){
            for (RuNode node : prezentacija.getChildren()){
                this.dodati.add((Slajd) node);
                this.jTabbedPane.addTab(node.getName(),slajdViewHashMap.get(node));
            }
        }
        if (prezentacija.getChildren() != null){
            for (RuNode node : prezentacija.getChildren()){

                SlajdView slajdView = slajdViewHashMap.get(node);
                TumbnailSlika tumbnailSlika = new TumbnailSlika((Slajd) node,slajdView,this);
                tumbPanel.add(tumbnailSlika);
                scrollPane.revalidate();

            }
        }
    }

    public void setupSlideShow(){
        this.removeAll();
        slideShowPanel = new SlideShowPanel();
        this.add(slideShowPanel);
        this.revalidate();
    }

    public void setup(){this.setupPrezentacijaView(this.prezentacija);}

    public SlajdView getSelectedSlajdView(){
        SlajdView slajdView =(SlajdView)this.jTabbedPane.getSelectedComponent();
        return slajdView;
    }

    @Override
    public void update(Object obj) {
            this.autorString = prezentacija.getAutor();
            setup();
    }

    public void startEditState(){
        this.stateManager.setEditState();
        setup();
        this.revalidate();
    }

    public void startSlideShowState(){
        this.stateManager.setSlideShowState();
        setupSlideShow();
    }

    public void startRectangleState(){
        this.stateManager.setRectangelState();
    }

    public Prezentacija getPrezentacija() {
        return prezentacija;
    }

    public HashMap<Slajd, SlajdView> getSlajdViewHashMap() {
        return slajdViewHashMap;
    }

    public JTabbedPaneModel getjTabbedPane() {
        return jTabbedPane;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
            for (Observer observer : observerList.getObservers()){
                observer.update(this);
            }
    }
}











