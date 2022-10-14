package view;

import errorHandler.ErrorHandlerImpl;
import repository.Prezentacija;
import repository.node.RuNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class IzmenaPanel extends JDialog {

    private JTextField autorTF;
    private ErrorHandlerImpl error;
    private Prezentacija prezentacija;
    private slikaDialog slikaDialog;

    public IzmenaPanel(JFrame parent, String title) {
        super(parent,title);
        error = new ErrorHandlerImpl();

        setSize(300,200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel glavniPanel = new JPanel();
        this.add(glavniPanel);
        glavniPanel.setLayout(new BoxLayout(glavniPanel,BoxLayout.X_AXIS));

        JButton autorBtn = new JButton("Promeni autora");
        autorBtn.setPreferredSize(new Dimension(75,25));
        JButton pozadinaBtn = new JButton("Promeni pozadinu");
        pozadinaBtn.setPreferredSize(new Dimension(75,25));

        autorBtn.addActionListener(e -> {
            dispose();
            RuNode item = MainFrame.getInstance().getTree().getSelectedPath();
            String autor = ((Prezentacija) item).getAutor();

            if (item instanceof Prezentacija){
                autor = (String) JOptionPane.showInputDialog(MainFrame.getInstance(),
                        "Novi autor",
                        "Promenite ime autora",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        autor);

                if (autor != null){
                    ((Prezentacija) item).setAutor(autor);
                    ((Prezentacija)item).notifyObservers();
                }

            }
        });

        pozadinaBtn.addActionListener(e -> {
            dispose();
            RuNode item = MainFrame.getInstance().getTree().getSelectedPath();
            String slika = ((Prezentacija) item).getSlika();

            ArrayList<Object> listaSlika = ucitajSlike();

            slikaDialog = new slikaDialog(MainFrame.getInstance(),"Promeni pozadinu", listaSlika,(Prezentacija)item);
            slikaDialog.setVisible(true);

        });

        glavniPanel.add(autorBtn);
        glavniPanel.add(pozadinaBtn);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public ArrayList<Object> ucitajSlike(){
        File putanja = new File("src/repository/backgroundImages");

        File[] lista = putanja.listFiles();

        ArrayList<Object> fileList = new ArrayList<>();

        for (Object obj : lista){
            fileList.add(obj);
        }
        return fileList;
    }
    public class slikaDialog extends JDialog{

        private String title;
        private JFrame parent;
        private ArrayList<Object> listaSlika;
        private Prezentacija prezentacija;

        public slikaDialog(JFrame parent, String title,ArrayList<Object> listaSlika,Prezentacija prezentacija) {
            setSize(300,200);
            setLocationRelativeTo(parent);
            setLayout(new BorderLayout());

            this.parent = parent;
            this.title = title;
            this.listaSlika = listaSlika;
            this.prezentacija = prezentacija;

            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new BoxLayout(btnPanel,BoxLayout.X_AXIS));

            JButton closeBtn = new JButton("Zatvori");
            closeBtn.addActionListener(e -> {
                dispose();
            });


            JButton promeniBtn = new JButton("Promeni");
            JComboBox<Object> slikeComboBox = new JComboBox<>();
            ArrayList<Object> fileList = ucitajSlike();

            for (Object obj : fileList){
                slikeComboBox.addItem(obj);
                if (((File)obj).getName().equals(prezentacija.getImeSlike())){
                    slikeComboBox.setSelectedItem(obj);
                }
            }
            slikeComboBox.setPreferredSize(new Dimension(50,50));
            promeniBtn.addActionListener(e->{
                prezentacija.setSlika("backgroundImages/" +((File)slikeComboBox.getSelectedItem()).getName());
                dispose();
            });

            btnPanel.add(closeBtn);
            btnPanel.add(promeniBtn);

            add(slikeComboBox,BorderLayout.NORTH);
            add(btnPanel,BorderLayout.CENTER);

            this.setModalityType(ModalityType.APPLICATION_MODAL);
        }


    }
}
