package view;

import controller.listeners.CloseListener;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;

public class CloseTab extends JPanel {

    private Component tab;

    public CloseTab(final Component tab, String title, Icon icon) {
        this.tab = tab;
        setOpaque(false);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        setLayout(flowLayout);
        JLabel jLabel = new JLabel(title);
        jLabel.setIcon(icon);
        add(jLabel);
        JButton button = new JButton(MetalIconFactory.getInternalFrameCloseIcon(16));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addMouseListener(new CloseListener(tab));
        add(button);
    }
}