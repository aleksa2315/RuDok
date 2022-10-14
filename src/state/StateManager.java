package state;

public class StateManager {
    private State currState;
    private SlideShowState slideShowState;
    private EditState editState;
    private RectangelState rectangelState;

    public StateManager() {
            init();
        }

    public void init(){
        slideShowState = new SlideShowState();
        editState = new EditState();
        currState = editState;
        rectangelState = new RectangelState();
    }
    public void setSlideShowState() {
        currState = slideShowState;
    }

    public void setEditState() {
        currState = editState;
    }

    public State getCurrState() {
        return currState;
    }

    public void setRectangelState() {
        currState = rectangelState;
    }
}
