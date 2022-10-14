package controller;

import view.MainFrame;

public class ActionManager {
    private ExitAction exitAction;
    private NewRuNodeAction newRuNodeAction;
    private InfoAction infoAction;
    private IzmenaPrezAction izmenaPrezAction;
    private DeleteRuNodeAction deleteRuNodeAction;
    private SlideShowAction slideShowAction;
    private EditPresAction editPresAction;
    private RectangleAction rectangleAction;
    private MoveAction moveAction;
    private ShareNodeAction shareNodeAction;

    public ActionManager() {

        exitAction = new ExitAction(MainFrame.getInstance());
        newRuNodeAction = new NewRuNodeAction();
        infoAction = new InfoAction();
        izmenaPrezAction = new IzmenaPrezAction();
        deleteRuNodeAction = new DeleteRuNodeAction();
        slideShowAction = new SlideShowAction();
        editPresAction = new EditPresAction();
        rectangleAction = new RectangleAction();
        moveAction = new MoveAction();
        shareNodeAction = new ShareNodeAction();
    }

    public ExitAction getExitAction() {
        return this.exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewRuNodeAction getNewRuNodeAction() {
        return this.newRuNodeAction;
    }

    public void setNewRuNodeAction(NewRuNodeAction newRuNodeAction) {
        this.newRuNodeAction = newRuNodeAction;
    }

    public InfoAction getInfoAction() {
        return this.infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public IzmenaPrezAction getIzmenaPrezAction() {
        return izmenaPrezAction;
    }

    public void setIzmenaPrezAction(IzmenaPrezAction izmenaPrezAction) {
        this.izmenaPrezAction = izmenaPrezAction;
    }

    public DeleteRuNodeAction getDeleteRuNodeAction() {
        return deleteRuNodeAction;
    }

    public void setDeleteRuNodeAction(DeleteRuNodeAction deleteRuNodeAction) {
        this.deleteRuNodeAction = deleteRuNodeAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public void setSlideShowAction(SlideShowAction slideShowAction) {
        this.slideShowAction = slideShowAction;
    }

    public EditPresAction getEditPresAction() {
        return editPresAction;
    }

    public void setEditPresAction(EditPresAction editPresAction) {
        this.editPresAction = editPresAction;
    }

    public RectangleAction getRectangleAction() {
        return rectangleAction;
    }

    public void setRectangleAction(RectangleAction rectangleAction) {
        this.rectangleAction = rectangleAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public void setMoveAction(MoveAction moveAction) {
        this.moveAction = moveAction;
    }

    public ShareNodeAction getShareNodeAction() {
        return shareNodeAction;
    }

    public void setShareNodeAction(ShareNodeAction shareNodeAction) {
        this.shareNodeAction = shareNodeAction;
    }
}
