package tree.controller;

import tree.model.RuTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class RuTreeSelectionListener implements TreeSelectionListener {

    private Object node;

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        RuTreeItem selectedTreeItem =(RuTreeItem) path.getLastPathComponent();
    }
}
