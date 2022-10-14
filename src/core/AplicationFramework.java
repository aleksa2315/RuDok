package core;



public abstract class AplicationFramework {
    protected Gui gui;
    protected Repository repository;
    protected ErrorHandler errorHandler;
    public abstract void run();

    public void init(Gui gui, Repository repository, ErrorHandler errorHandler){
        this.gui = gui;
        this.repository = repository;
        this.errorHandler = errorHandler;
    }
}
