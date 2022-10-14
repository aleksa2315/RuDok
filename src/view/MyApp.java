package view;

import core.Gui;
import core.Repository;

public class MyApp implements Gui {
    private MainFrame instance;
    private Repository prezentacijaRepository;

    public MyApp(Repository prezentacijaRepository){this.prezentacijaRepository = prezentacijaRepository;}

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setPrezentacijaRepository(prezentacijaRepository);
        instance.initialiseWorkspaceTree();
        instance.setVisible(true);
    }
}
