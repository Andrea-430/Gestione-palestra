package GUI;
import gestionepalestra.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class PresenterCerca 
{
    private ManagerIscrittiAbbonamenti manager;
    
    
    public PresenterCerca()
    {
        this.manager = ManagerIscrittiAbbonamenti.getInstance();
    }
    
    public JTable initTable(Iscritto is)
    {
        JTable tabella = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        
        String[] nomeColonne = {"Data Inizio", "Data Fine", "Codice Fiscale", "Tipo abbonamento"};
        model.setColumnIdentifiers(nomeColonne);
        
        for(int i = 0; i < manager.getMappa().get(is).size(); i++)
        {
            Object[] dati = {manager.getMappa().get(is).get(i).getDataInizio(), manager.getMappa().get(is).get(i).getDataFine(), manager.getMappa().get(is).get(i).getCodFiscale(), manager.getMappa().get(is).get(i).getTipo()};
            model.addRow(dati);
        }
        
        tabella.setModel(model);
        
        return tabella;
    }
    
    public JTable cerca(String CodFiscale)
    {
        Iscritto i = manager.CercaIscritto(CodFiscale);
        
        if(i != null)
        {
            return this.initTable(i);
        }
        return null;
    }
}
