package tree.view;

import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import tree.model.RuTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    public RuTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);

        if (((RuTreeItem)value).getNodeModel() instanceof Workspace) {
            URL imageURL = getClass().getResource("images/workspaceIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (((RuTreeItem)value).getNodeModel() instanceof Projekat) {
            URL imageURL = getClass().getResource("images/projectIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (((RuTreeItem)value).getNodeModel() instanceof Prezentacija) {
            URL imageURL = getClass().getResource("images/documentIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (((RuTreeItem)value).getNodeModel() instanceof Slajd) {
            URL imageURL = getClass().getResource("images/pageIcon.jpg");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        }
        return this;
    }
}
