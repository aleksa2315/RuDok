package tree.view;

import com.sun.source.tree.Tree;
import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import repository.node.RuNode;
import tree.RuTree;
import tree.model.RuTreeItem;
import view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.Objects;

public class RuTreeImpl implements RuTree {
    private RuTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public JTree generateTree(Workspace workspace) {
        RuTreeItem root = new RuTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        treeView = new RuTreeView(treeModel);
        treeView.setSelectionPath(treeView.getPathForLocation(0,0));
        return treeView;
    }

    @Override
    public void addProject(Projekat projekat) {
        RuNode nodeModel = ((RuTreeItem)treeModel.getRoot()).getNodeModel();
        ((RuTreeItem)treeModel.getRoot()).add(new RuTreeItem(projekat));
        ((Workspace) nodeModel).addChild(projekat);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.expandPath(treeView.getSelectionPath());
    }

    @Override
    public void addPrezentacija(Prezentacija prezentacija) {
        RuTreeItem selectedNode = (RuTreeItem) Objects.requireNonNull(MainFrame.getInstance().getWorkspaceTree().getSelectionPath()).getLastPathComponent();
        if (selectedNode == null)
            return;
        selectedNode.add(new RuTreeItem(prezentacija));
        RuNode nodeModel = selectedNode.getNodeModel();
        ((Projekat) nodeModel).addChild(prezentacija);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.expandPath(treeView.getSelectionPath());
    }
    @Override
    public void addSlajd(Slajd slajd) {
        RuTreeItem selectedNode = (RuTreeItem) Objects.requireNonNull(MainFrame.getInstance().getWorkspaceTree().getSelectionPath()).getLastPathComponent();
        if (selectedNode == null)
            return;
        selectedNode.add(new RuTreeItem(slajd));
        RuNode nodeModel = selectedNode.getNodeModel();
        ((Prezentacija) nodeModel).addChild(slajd);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.expandPath(treeView.getSelectionPath());
    }

    @Override
    public void delProject(Projekat projekat) {
        if (projekat == null)
            return;
        Workspace workspace = (Workspace) projekat.getParent();
        workspace.getChildren().remove(projekat);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.setSelectionPath(treeView.getPathForLocation(0,0));
    }

    @Override
    public void delPrezentacija(Prezentacija prezentacija) {
        if (prezentacija == null)
            return;
        System.out.println(prezentacija.getParent());
        Projekat projekat = (Projekat) prezentacija.getParent();
        projekat.getChildren().remove(prezentacija);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.setSelectionPath(treeView.getPathForLocation(0,0));
    }

    @Override
    public void delSlajd(Slajd slajd) {
        if (slajd == null)
            return;
        Prezentacija prezentacija = (Prezentacija) slajd.getParent();
        prezentacija.getChildren().remove(slajd);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.setSelectionPath(treeView.getPathForLocation(0,0));
    }


    @Override
    public RuNode getSelectedPath() {
        return ((RuTreeItem) Objects.requireNonNull(MainFrame.getInstance().getWorkspaceTree().getSelectionPath()).getLastPathComponent()).getNodeModel();
    }

    @Override
    public void refresh(){
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public Projekat getCurrentProject() {
        TreePath path = treeView.getSelectionPath();
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof Projekat){
                return (Projekat) path.getPathComponent(i);
            }
        }
        return null;
    }

    @Override
    public RuTreeItem getPath(Projekat projekat) {
        TreePath jedan = MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getParentPath();
        TreePath root = jedan.getParentPath();
        MainFrame.getInstance().getWorkspaceTree().setSelectionPath(root);
        RuTreeItem rootItem =(RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();

        String[] ime = projekat.getName().split(" ");
        int index = Integer.parseInt(ime[1]);

        RuTreeItem projekatItem = (RuTreeItem) rootItem.getChildAt(index);
        return projekatItem;
    }

    public void addSharedPrez(Prezentacija prezentacija,Projekat projekat){
        RuTreeItem selectedNode = getPath(projekat);
        if (selectedNode == null)
            return;
        selectedNode.add(new RuTreeItem(prezentacija));
        RuNode nodeModel = selectedNode.getNodeModel();
        ((Projekat) nodeModel).addChild(prezentacija);
        SwingUtilities.updateComponentTreeUI(treeView);
        treeView.expandPath(treeView.getSelectionPath());
    }
}
