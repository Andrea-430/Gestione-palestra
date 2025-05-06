package GUI;
import javax.swing.*;
//import javax.swing.border.LineBorder;
import java.awt.*;

public class NuovoIscritto 
{
    private Presenter presenter;
    private JPanel Inserimento;
    
    private JLabel nome;
    private JLabel cognome;
    private JLabel CodiceFiscale;
    private JLabel output;
    
    private JButton conferma;
    
    private JTextField InsNome;
    private JTextField InsCognome;
    private JTextField InsCodFiscale;
    
    public NuovoIscritto()
    {
        this.presenter = new Presenter();
        this.Inserimento = new JPanel();
        
        this.nome = new JLabel("Nome");
        this.cognome = new JLabel("Cognome");
        this.CodiceFiscale = new JLabel("Codice Fiscale");
        this.output = new JLabel();
        
        this.conferma = new JButton("Conferma");
         
        this.InsNome = new JTextField();
        this.InsCognome = new JTextField();
        this.InsCodFiscale = new JTextField();
    }
    
    public JPanel getPanel()
    {
        Inserimento.setLayout(null);
        //Inserimento.setBorder(new LineBorder(Color.BLACK, 3));
        
        Inserimento.add(nome);
        nome.setBounds(10,10,60,20);
        
        Inserimento.add(cognome);
        cognome.setBounds(10, 50, 60, 20);
        
        Inserimento.add(CodiceFiscale);
        CodiceFiscale.setBounds(10, 90, 120, 20);
        
        Inserimento.add(InsNome);
        InsNome.setBounds(130, 10, 200,20);
        
        Inserimento.add(InsCognome);
        InsCognome.setBounds(130, 50, 200, 20);
        
        Inserimento.add(InsCodFiscale);
        InsCodFiscale.setBounds(130, 90, 200, 20);
        
        Inserimento.add(output);
        output.setBounds(120, 150, 200, 20);
        
        Inserimento.add(conferma);
        conferma.setBounds(10, 150, 100, 20);
        conferma.addActionListener(e -> {
            output.setText(presenter.NuovoIscritto(InsNome.getText(), InsCognome.getText(), InsCodFiscale.getText()));
            
            InsNome.setText("");
            InsCognome.setText("");
            InsCodFiscale.setText("");
            
        });
        
        
        
        
        return this.Inserimento;
    }
}
