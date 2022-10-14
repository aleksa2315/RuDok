package controller;

import errorHandler.ErrorHandlerImpl;
import errorHandler.ErrorType;
import repository.Prezentacija;
import repository.node.RuNode;
import tree.model.RuTreeItem;
import view.IzmenaPanel;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class IzmenaPrezAction extends AbstractAction{

    private IzmenaPanel izmenaPanel;
    private ErrorHandlerImpl errorHandler;

    public IzmenaPrezAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/editIcon.png"));
        putValue(NAME, "Izmena");
        putValue(SHORT_DESCRIPTION, "Izmeni naziv autora ili pozadinsku sliku");
        errorHandler = new ErrorHandlerImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode item = MainFrame.getInstance().getTree().getSelectedPath();

        if (item instanceof Prezentacija) {

            izmenaPanel = new IzmenaPanel(MainFrame.getInstance(), "Promenite autora ili pozadinsku sliku");
            izmenaPanel.setVisible(true);
        }else {
            errorHandler.generateError(ErrorType.NOT_PREZENTACIJA);
        }
    }
}
