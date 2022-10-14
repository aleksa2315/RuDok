package view;

import controller.ExitAction;
import controller.InfoAction;

import javax.swing.*;

public class ToolBar extends JToolBar {
    public ToolBar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewRuNodeAction());
        add(MainFrame.getInstance().getActionManager().getDeleteRuNodeAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getExitAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getIzmenaPrezAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getShareNodeAction());
    }
}
