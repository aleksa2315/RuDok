package tree;

import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import repository.node.RuNode;
import tree.model.RuTreeItem;

import javax.swing.*;
import javax.swing.tree.TreePath;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject(Projekat projekat);
    void addPrezentacija(Prezentacija prezentacija);
    void addSlajd(Slajd slajd);
    void delProject(Projekat projekat);
    void delPrezentacija(Prezentacija prezentacija);
    void delSlajd(Slajd slajd);
    RuNode getSelectedPath();
    RuTreeItem getPath(Projekat projekat);
    void addSharedPrez(Prezentacija prezentacija,Projekat projekat);
    void refresh();

    public Projekat getCurrentProject();
}
