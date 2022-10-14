import core.AplicationFramework;
import core.ErrorHandler;
import core.Gui;
import core.Repository;
import errorHandler.ErrorHandlerImpl;
import repository.RepositoryImpl;
import view.MyApp;

public class AppCore extends AplicationFramework {

    private static AppCore instance;

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance==null){
            instance = new AppCore();
        }
        return instance;
    }

    @Override
    public void run() {
        this.gui.start();
    }

    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandlerImpl();
        Repository repository = new RepositoryImpl();
        Gui gui = new MyApp(repository);
        AplicationFramework appCore = AppCore.getInstance();
        appCore.init(gui,repository,errorHandler);
        appCore.run();
    }
}
