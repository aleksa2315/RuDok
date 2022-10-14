package view;

import repository.Prezentacija;
import repository.Projekat;
import repository.Workspace;
import repository.node.RuNode;
import tree.model.RuTreeItem;
import view.repositoryView.PrezentacijaView;
import view.repositoryView.ProjectView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShareDialog extends JDialog {

    private Prezentacija selektovanaPrez;
    private Projekat selektovanPro;

    public ShareDialog(Frame parent, String title) {
        super(parent,title);
        selektovanaPrez = (Prezentacija) MainFrame.getInstance().getTree().getSelectedPath();
        setSize(300,150);
        setLocationRelativeTo(parent);
        setModal(true);
        JPanel jpMain = new JPanel();
        setLayout(new BorderLayout());
        add(jpMain,BorderLayout.CENTER);
        ArrayList lista = new ArrayList();

        JLabel label = new JLabel("Odaberite projekat:");

        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");

        JPanel comboPanel = new JPanel();

        JComboBox<Projekat> comboBox = new JComboBox();
        Workspace workspace = (Workspace) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel();

        for (RuNode node : workspace.getChildren()){

            if (!selektovanaPrez.getParent().equals((Projekat)node)){
                comboBox.addItem((Projekat) node);
            }
        }

        comboPanel.add(comboBox);
        comboPanel.setPreferredSize(new Dimension(200,100));

        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(150,50));
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);

        cancelBtn.addActionListener(e -> {
            dispose();
        });



        okBtn.addActionListener(e -> {
            selektovanPro = (Projekat) comboBox.getSelectedItem();
            selektovanaPrez.setShared(true);
            selektovanPro.addChild(selektovanaPrez);
            ProjectView projectView = MainFrame.getInstance().getViewStorage().getProjectView(selektovanPro);
           // MainFrame.getInstance().getTree().addSharedPrez(selektovanaPrez,selektovanPro);
            MainFrame.getInstance().getViewStorage().putPrezentacijaView(selektovanaPrez,projectView.addTab(selektovanaPrez));
            MainFrame.getInstance().setProjectView(projectView);
           // projectView.addTab(selektovanaPrez);


            projectView.update(selektovanaPrez);
            dispose();
        });

        jpMain.setLayout(new BorderLayout());
        jpMain.add(label,BorderLayout.NORTH);
        jpMain.add(comboPanel,BorderLayout.CENTER);
        jpMain.add(btnPanel,BorderLayout.SOUTH);


        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
