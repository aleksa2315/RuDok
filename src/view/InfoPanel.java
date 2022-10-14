package view;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JDialog {

    public InfoPanel(JFrame parent, String title) {
        super(parent,title);

        setSize(600,450);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel slikaPanel = new JPanel();
        slikaPanel.setLayout(new BorderLayout());
        slikaPanel.add(new JLabel("Aleksandar Maric, RN25/19"),BorderLayout.NORTH);
        JLabel maricLbl = new JLabel();
        maricLbl.setIcon(new ImageIcon(new ImageIcon("src/images/ja.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_REPLICATE)));
        slikaPanel.add(maricLbl,BorderLayout.CENTER);

        add(slikaPanel,BorderLayout.CENTER);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
    }
}
