package tree.model;

import errorHandler.ErrorHandlerImpl;
import errorHandler.ErrorType;
import repository.node.RuNode;
import repository.node.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Iterator;

public class RuTreeItem extends DefaultMutableTreeNode {

    private String name;
    private RuNode nodeModel;
    private ErrorHandlerImpl error;

    public RuTreeItem(RuNode nodeModel){
        this.nodeModel = nodeModel;
        this.name = nodeModel.getName();
        this.error = new ErrorHandlerImpl();
    }

    public RuTreeItem(String name, RuNode node) {
        this.name = name;
        this.nodeModel = node;
    }

    public int getIndex(TreeNode node){
        return findIndexByChild((RuTreeItem) node);
    }

    public TreeNode getChildAt(int index){
        return findChildByIndex(index);
    }

    public String getName() {
        return name;
    }

    public RuNode getNodeModel() {
        return nodeModel;
    }

    public void setNodeModel(RuNode nodeModel) {
        this.nodeModel = nodeModel;
    }

    public void setName(String name) {
        this.name = name;
        this.nodeModel.setName(name);
        if (name.isBlank() || name == " "){
            error.generateError(ErrorType.RENAME);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getChildCount() {
        if(nodeModel instanceof RuNodeComposite)
            return ((RuNodeComposite) nodeModel).getChildren().size();
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        if(nodeModel instanceof RuNodeComposite)
            return true;
        return false;
    }

    @Override
    public boolean isLeaf() {
        if(nodeModel instanceof RuNodeComposite)
            return false;
        return true;
    }

    @Override
    public Enumeration children() {
        if(nodeModel instanceof RuNodeComposite)
            return (Enumeration) ((RuNodeComposite) nodeModel).getChildren();
        return null;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof RuTreeItem) {
            RuTreeItem otherObj = (RuTreeItem) obj;
            return this.nodeModel.equals(otherObj.nodeModel);
        }
        return false;
    }

    private int findIndexByChild(RuTreeItem node){

        if(this.nodeModel instanceof RuNodeComposite){
            return  ((RuNodeComposite) this.nodeModel).getChildren().indexOf(node.getNodeModel());
        }
        return -1;
    }

    private TreeNode findChildByIndex(int childIndex){

        if(nodeModel instanceof RuNodeComposite){
            RuTreeItem toLookFor = new RuTreeItem(((RuNodeComposite) nodeModel).getChildren().get(childIndex));

            Iterator childrenIterator = children.iterator();
            TreeNode current;

            while (childrenIterator.hasNext()){
                current = (TreeNode) childrenIterator.next();
                if (current.equals(toLookFor))
                    return current;
            }
        }
        return null;
    }

}
