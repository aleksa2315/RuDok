package view;

import controller.ActionManager;
import controller.ExitAction;
import controller.ViewStorage;
import core.Repository;
import repository.Prezentacija;
import tree.RuTree;
import tree.controller.DoubleClickListener;
import tree.view.RuTreeImpl;
import view.repositoryView.ProjectView;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance;
    private JMenuBar menu;
    private JToolBar toolbar;
    private JPanel desktop;
    private ActionManager actionManager;
    private JTree workspaceTree;
    private RuTree tree;
    private Repository prezentacijaRepository;
    private ViewStorage viewStorage = new ViewStorage();
    private ProjectView projectView;


    public void initGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width/2;
        int screenHeight = screenSize.height/2;

        setSize(screenWidth,screenHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok");

        menu = new MenuBar(this);
        setJMenuBar(menu);

        toolbar = new ToolBar();
        add(toolbar,BorderLayout.NORTH);

        this.desktop = new JPanel();
        this.desktop.setLayout(new BorderLayout());


        JScrollPane scrollPane = new JScrollPane(workspaceTree);

        workspaceTree.addMouseListener(new DoubleClickListener(workspaceTree));

        scrollPane.setMinimumSize(new Dimension(200,150));
        JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,this.desktop);
        getContentPane().add(splitPane,BorderLayout.CENTER);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);


        this.setIconImage(new ImageIcon("src/images/RuDok.png").getImage());

        JPanel statusBar = new JPanel();
        statusBar.setBorder(new EtchedBorder());
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusBar.setPreferredSize(new Dimension(100,20));
        add(statusBar,BorderLayout.SOUTH);

    }

    private MainFrame(){this.addWindowListener(new ExitAction(this));}

    private void initialise(){actionManager = new ActionManager();}

    public static MainFrame getInstance(){
        if(instance==null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public void initialiseWorkspaceTree(){
        tree = new RuTreeImpl();
        workspaceTree = tree.generateTree(prezentacijaRepository.getWorkspace());
        initGui();
    }

    public void setProjectView(ProjectView projectView){
        this.desktop.removeAll();
        projectView.setup();
        this.desktop.add(projectView);
        this.setProjekat(projectView);
        this.desktop.revalidate();
    }

    public void setProjekat(ProjectView projectView){
        this.projectView = projectView;
    }

    public ProjectView getProjectView() {
        return this.projectView;
    }

    public static void setInstance(MainFrame instance) {
        MainFrame.instance = instance;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JToolBar getToolbar() {
        return toolbar;
    }

    public void setToolbar(JToolBar toolbar) {
        this.toolbar = toolbar;
    }

    public JPanel getDesktop() {
        return desktop;
    }

    public void setDesktop(JPanel desktop) {
        this.desktop = desktop;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public JTree getWorkspaceTree() {
        return workspaceTree;
    }

    public RuTree getTree() {
        return tree;
    }

    public Repository getPrezentacijaRepository() {
        return prezentacijaRepository;
    }

    public void setPrezentacijaRepository(Repository prezentacijaRepository){this.prezentacijaRepository = prezentacijaRepository;}

    public void setWorkspaceTree(JTree workspaceTree){this.workspaceTree = workspaceTree;}

    public ViewStorage getViewStorage() {
        return viewStorage;
    }
}
