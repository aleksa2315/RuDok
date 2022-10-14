package repository.node;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode {

    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public RuNodeComposite(String name, RuNode parent, List<RuNode> children) {
        super(name, parent);
        this.children = children;
    }

    public RuNode getChildByName(String name){
        for (RuNode child : this.getChildren()){
            if (child.getName().equals(name)){
                return child;
            }
        }
        return null;
    }

    public abstract void addChild(RuNode child);

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

}
