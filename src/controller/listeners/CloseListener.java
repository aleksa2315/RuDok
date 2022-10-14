package controller.listeners;

import model.RuNodeTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CloseListener implements MouseListener {

    private Component tab;

    public CloseListener(Component tab) {
        this.tab = tab;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
            if (tab instanceof RuNodeTab) {
                ((RuNodeTab)tab).saveRuNodeState();
            }
            tabbedPane.remove(tab);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
        }
    }
}