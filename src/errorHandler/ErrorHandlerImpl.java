package errorHandler;

import core.ErrorHandler;

import javax.swing.*;


public class ErrorHandlerImpl implements ErrorHandler {
    @Override
    public void generateError(errorHandler.ErrorType errorType) {
        JFrame frame = new JFrame();
        if (errorType == ErrorType.RENAME){
            JOptionPane.showMessageDialog(frame,"To ne moze da bude ime!");
        }else if (errorType == ErrorType.NON_SELECTED){
            JOptionPane.showMessageDialog(frame,"Ni jedan element nije selektovan!");
        }else if(errorType == ErrorType.SAME_NAME){
            JOptionPane.showMessageDialog(frame,"Vec postoji element sa tim imenom!");
        }else if(errorType == ErrorType.NOT_PREZENTACIJA){
            JOptionPane.showMessageDialog(frame,"Selektovani element nije prezentacija!");
        }
    }
}
