package view;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    private JFrame parent = null;

    public MenuBar(final JFrame parent) {
        this.parent = parent;

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.addSeparator();
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewRuNodeAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteRuNodeAction());
        JMenu editMenu = new JMenu("Edit");

        editMenu.addSeparator();
        editMenu.add(new JMenuItem("Undo"));
        editMenu.addSeparator();
        editMenu.add(new JMenuItem("Redo"));
        editMenu.addSeparator();
        editMenu.add(MainFrame.getInstance().getActionManager().getIzmenaPrezAction());

        JMenu sourceMenu = new JMenu("Source");

        JMenu infoMenu = new JMenu("Info");
        infoMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());


        add(fileMenu);
        add(editMenu);
        add(sourceMenu);
        add(infoMenu);


    }
}
