package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import gestionepalestra.*;
import java.awt.*;

public class VisualizzaIscritti {
    private JPanel VisIscritti;
    private JScrollPane scroll;
    private JTable tabella;
    private DefaultTableModel model;
    private JButton refresh;
    private ManagerIscrittiAbbonamenti manager;
    
    public VisualizzaIscritti() 
    {
        this.VisIscritti = new JPanel();
        this.scroll = new JScrollPane();
        this.tabella = new JTable();
        this.model = new DefaultTableModel();
        this.refresh = new JButton("Aggiorna");
        this.manager = ManagerIscrittiAbbonamenti.getInstance();
        
        
    }
    
    public JTable InitTable()
    {
        model.setRowCount(0);
        String [] nomeColonne = {"Nome", "Cognome", "Codice Fiscale"};
        model.setColumnIdentifiers(nomeColonne);
        
        for(Iscritto iscritto : manager.getMappa().keySet())
        {
            String[] dati = {iscritto.getNome(), iscritto.getCognome(), iscritto.getCodFiscale()};
            model.addRow(dati);
        }
        
        tabella.setModel(model);
        
        return tabella;
    }
    
    public JPanel getPanel()
    {
        VisIscritti.add(scroll);
        VisIscritti.setLayout(null);
        scroll.setBounds(0,0,400,400);
        VisIscritti.add(refresh);
        refresh.setBounds(140, 400, 150, 20);
        refresh.addActionListener(e -> {
            tabella = this.InitTable();
        });
        
        scroll.setViewportView(tabella);
        
        return VisIscritti;
    }
    
        
        
}
