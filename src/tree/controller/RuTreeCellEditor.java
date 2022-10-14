package tree.controller;

import controller.ViewStorage;
import errorHandler.ErrorHandlerImpl;
import errorHandler.ErrorType;
import repository.Prezentacija;
import repository.Projekat;
import repository.Slajd;
import repository.Workspace;
import repository.node.RuNode;
import tree.model.RuTreeItem;
import view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object selektovan = null;
    private JTextField edit = null;
    private ErrorHandlerImpl erorr;
    private ViewStorage viewStorage = MainFrame.getInstance().getViewStorage();

    public RuTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
        this.erorr = new ErrorHandlerImpl();
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5){
        selektovan = arg1;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }


    public boolean isCellEditable(EventObject object){
        if (object instanceof MouseEvent){
            if(((MouseEvent) object).getClickCount() == 3){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(selektovan instanceof RuTreeItem)){
                return;
        }

        RuTreeItem clicked = (RuTreeItem) selektovan;

        boolean jeste = false;

        if (clicked.getNodeModel() instanceof Workspace){
            clicked.setName(e.getActionCommand());
            ((Workspace) clicked.getNodeModel()).setName(e.getActionCommand());
        }else if(clicked.getNodeModel() instanceof Projekat){
            for (RuNode node : ((Workspace) clicked.getNodeModel().getParent()).getChildren()){
                if (node.getName().equals(e.getActionCommand())){
                    jeste = true;
                }
            }

            if(jeste){
                erorr.generateError(ErrorType.SAME_NAME);
            }else{
                clicked.setName(e.getActionCommand());
                ((Projekat)clicked.getNodeModel()).setName(e.getActionCommand());
                viewStorage.getProjectView((Projekat) clicked.getNodeModel()).setup();
            }
        }else if(clicked.getNodeModel() instanceof Prezentacija){
            for (RuNode node : ((Projekat)clicked.getNodeModel().getParent()).getChildren()){
                if (node.getName().equals(e.getActionCommand())){
                    jeste = true;
                }
            }
            if (jeste){
                erorr.generateError(ErrorType.SAME_NAME);
            }else {
                clicked.setName(e.getActionCommand());
                ((Prezentacija)clicked.getNodeModel()).setName(e.getActionCommand());
                viewStorage.getProjectView((Projekat)clicked.getNodeModel().getParent()).setup();
            }
        }else if(clicked.getNodeModel() instanceof Slajd){
            for (RuNode node : ((Prezentacija)clicked.getNodeModel().getParent()).getChildren()){
                if (node.getName().equals(e.getActionCommand())){
                    jeste = true;
                }
            }
            if (jeste){
                erorr.generateError(ErrorType.SAME_NAME);
            }else{
                clicked.setName(e.getActionCommand());
                ((Slajd)clicked.getNodeModel()).setName(e.getActionCommand());
            }
        }

    }
}

























