package GUI;
import javax.swing.table.DefaultTableModel;
import gestionepalestra.*;
import javax.swing.*;

public class Cerca 
{
    private JPanel CercaIscritto;
    private JLabel ricerca;
    private JLabel output;
    private JTextField BarraRicerca;
    private JButton cerca;
    private JTable tabella;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private ManagerIscrittiAbbonamenti manager;
    private PresenterCerca presenter;
    
    
    public Cerca()
    {
        this.CercaIscritto = new JPanel();
        this.cerca = new JButton("Cerca");
        this.ricerca = new JLabel("Inserire il codice fiscale da cercare");
        this.output = new JLabel();
        this.BarraRicerca = new JTextField();
        this.tabella = new JTable();
        this.scroll  = new JScrollPane();
        this.model = new DefaultTableModel();
        this.manager = ManagerIscrittiAbbonamenti.getInstance();
        this.presenter = new PresenterCerca();
        
    }
    
  
    
    public JPanel getPanel()
    {
        CercaIscritto.setLayout(null);
        CercaIscritto.add(ricerca);
        ricerca.setBounds(100, 10, 200,20);
        
        
        CercaIscritto.add(BarraRicerca);
        BarraRicerca.setBounds(50, 30, 300, 20);
        
        
        CercaIscritto.add(cerca);
        cerca.setBounds(150, 55, 100, 20);
        cerca.addActionListener(e -> {
            tabella = presenter.cerca(BarraRicerca.getText());
            scroll.setViewportView(tabella);
        });
        
        CercaIscritto.add(scroll);
        scroll.setBounds(10, 200, 400, 200);
        
        
        return this.CercaIscritto;
    }
}


