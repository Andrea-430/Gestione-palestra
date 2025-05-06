package GUI;
import javax.swing.*;
import java.awt.*;
import gestionepalestra.Abbonamento.tipoAbbonamento;
import java.time.LocalDate;

public class NuovoAbbonamento 
{
    private Presenter presenter;
    private JPanel abbonamento;
    
    private JLabel DataInizio;
    private JLabel CodiceFiscale;
    private JLabel output;
    
    private JTextField Anno;
    private JTextField Mese;
    private JTextField Giorno;
    private JTextField InsCodFiscale;
    
    private JComboBox <tipoAbbonamento> tendina;
    
    private JButton conferma;
    
    
    public NuovoAbbonamento()
    {
        this.presenter = new Presenter();
        this.abbonamento = new JPanel();
        
        this.DataInizio = new JLabel("Data di Inizio YYYY/MM/GG");
        this.CodiceFiscale = new JLabel("Codice Fiscale");
        this.output = new JLabel();
        
        this.Anno = new JTextField();
        this.Mese = new JTextField();
        this.Giorno = new JTextField();
        this.InsCodFiscale = new JTextField();
        
        this.tendina = new JComboBox<>(tipoAbbonamento.values());
        
        this.conferma = new JButton("Conferma");
    }
    
    public JPanel getPanel()
    {
        abbonamento.setLayout(null);
        
        abbonamento.add(tendina);
        tendina.setBounds(10, 20, 200, 20);
        
        abbonamento.add(DataInizio);
        DataInizio.setBounds(10, 60, 150, 20);
        
        abbonamento.add(CodiceFiscale);
        CodiceFiscale.setBounds(10, 100, 150, 20);
        
        abbonamento.add(Anno);
        Anno.setBounds(160, 60, 40, 20);
        
        abbonamento.add(Mese);
        Mese.setBounds(210, 60, 40 ,20);
        
        abbonamento.add(Giorno);
        Giorno.setBounds(260, 60, 40, 20);
        
        abbonamento.add(InsCodFiscale);
        InsCodFiscale.setBounds(160, 100, 200, 20);
        
        abbonamento.add(output);
        output.setBounds(140, 150, 250, 20);
        
        abbonamento.add(conferma);
        conferma.setBounds(10, 150, 120, 20);
        conferma.addActionListener(e -> {
            try
            {
                output.setText(presenter.NuovoAbbonamento(Integer.parseInt(Anno.getText()), Integer.parseInt(Mese.getText()), Integer.parseInt(Giorno.getText()), InsCodFiscale.getText(), (tipoAbbonamento)tendina.getSelectedItem()));
            
                Anno.setText("");
                Mese.setText("");
                Giorno.setText("");
                InsCodFiscale.setText("");
            }
            catch(Exception ex)
            {
                output.setText("Inserimento dati non valido, riprova");
            }
        });
        
        
        return this.abbonamento;
    }
}
