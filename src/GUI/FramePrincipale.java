package GUI;
import javax.swing.*;
import java.awt.*;

public class FramePrincipale 
{
    private Presenter presenter;
    
    private JFrame MFrame;
    private JPanel MPanel;
    private JPanel CPanel;
    private JPanel PannelloBiancoIniziale;
    
    //Altri Panneli
    
    private NuovoIscritto NI;
    private NuovoAbbonamento NA;
    private VisualizzaIscritti VI;
    private Cerca C;
    
    //Componenti menu della finestra
   
    private JLabel Titolo;
    private JButton b1; //aggiungi iscritto
    private JButton b2; //aggiungi abbonamento
    private JButton b3; //cerca iscritto
    private JButton b5; //visualizza Iscritti
    private JButton b4; //esci

    
    public FramePrincipale()
    {
        this.presenter = new Presenter();
        
        this.MFrame = new JFrame();
        this.CPanel = new JPanel();
        this.PannelloBiancoIniziale = new JPanel();
        
        //Inizializzazione altri pannelli
        this.NI = new NuovoIscritto();
        this.NA = new NuovoAbbonamento();
        this.VI = new VisualizzaIscritti();
        this.C = new Cerca();
        
        //Inizializzazione dei componenti della finestra
        
        this.Titolo = new JLabel("Menu Principale");
        this.b1 = new JButton("Aggiungi Iscritto");
        this.b2 = new JButton("Aggiungi abbonamento");
        this.b3 = new JButton("Cerca Iscritto");
        this.b4 = new JButton("Salva ed esci");
        this.b5 = new JButton("Visualizza Iscritti");
    }
    
    
    public void init ()
    {
        CardLayout cl = new CardLayout();
        MFrame.setLayout(null);
        MFrame.add(CPanel);
        CPanel.setBounds(185, 0, 455, 480);
        CPanel.setLayout(cl);
        
        //Aggiunta dei pannelli al Card Layout panel
        
        CPanel.add(this.PannelloBiancoIniziale, "PannelloBianco");
        CPanel.add(this.NI.getPanel(), "AggiungiIscritto");
        CPanel.add(this.NA.getPanel(), "AggiungiAbbonamento");
        CPanel.add(this.VI.getPanel(), "VisualizzaIscritti");
        CPanel.add(this.C.getPanel(), "Cerca"); 
        
        //Configurazione componenti del menu della finestra
        MFrame.add(Titolo);
        Titolo.setBounds(45,25,150,20);
        
        MFrame.add(b1);
        b1.setBounds(10, 60, 165, 20);
        b1.addActionListener(e -> cl.show(CPanel, "AggiungiIscritto"));
        
        MFrame.add(b2);
        b2.setBounds(10,90, 165, 20);
        b2.addActionListener(e -> 
        {
            cl.show(CPanel, "AggiungiAbbonamento");
            presenter.SalvaIscritti();
        });
        
        MFrame.add(b3);
        b3.setBounds(10, 120, 165, 20);
        b3.addActionListener(e -> cl.show(CPanel, "Cerca"));
        
        MFrame.add(b5);
        b5.setBounds(10, 150, 165, 20);
        b5.addActionListener(e -> cl.show(CPanel, "VisualizzaIscritti"));
        
        
        MFrame.add(b4);
        b4.setBounds(10, 180, 165, 20);
        b4.addActionListener(e -> {
            presenter.SalvaIscritti();
            presenter.SalvaAbbonamenti();
            System.exit(0);
        });
        
        //Configurazione della finestra
        MFrame.setSize(640,480);
        MFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MFrame.setResizable(false);
        MFrame.setVisible(true);
        
                
    }
}
