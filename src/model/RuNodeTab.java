package model;

import repository.node.RuNode;

import javax.swing.*;
import java.awt.*;

public class RuNodeTab extends JPanel {

    private JPanel topPanel;
    private String tabName;

    public RuNodeTab(RuNode node){
        this.tabName = node.getName();
        this.setLayout(new BorderLayout());

        this.topPanel = new JPanel();
        topPanel.add(new JLabel("Toolbar za " + this.tabName));
        this.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.add(new JLabel("Stablo " + this.tabName));

        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel("Sadrzaj  " + this.tabName));

        this.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel),
                BorderLayout.CENTER);

    }
    public void saveRuNodeState(){
        System.out.println("Cuvam sadrzaj dokumenta: " + this.tabName);
    }
}