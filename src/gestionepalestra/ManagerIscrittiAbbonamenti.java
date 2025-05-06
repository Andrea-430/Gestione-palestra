package gestionepalestra;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import gestionepalestra.Abbonamento.tipoAbbonamento;
import java.io.*;



public class ManagerIscrittiAbbonamenti 
{
    private static HashMap <Iscritto, ArrayList<Abbonamento>> mappa;
    private static ManagerIscrittiAbbonamenti instance = null;
    private CsvManager csv;
    
    private ManagerIscrittiAbbonamenti()
    {
        this.mappa = new HashMap <Iscritto, ArrayList<Abbonamento>>();
        this.csv = new CsvManager();
    }
    
    public static ManagerIscrittiAbbonamenti getInstance()
    {
        if(instance == null)
        {
          instance = new ManagerIscrittiAbbonamenti();          
        }
        return instance;
    }
    
    public boolean AggiungiIscritto(String nome, String cognome, String CodiceFiscale)
    {
        for(Iscritto i : mappa.keySet())
        {
            if(i.getCodFiscale().equals(CodiceFiscale))
            {
                return false;
            }
        }
        Iscritto nuovo = new Iscritto(nome,cognome,CodiceFiscale);
        ArrayList <Abbonamento> abbonamenti = new ArrayList <>();
        mappa.put(nuovo, abbonamenti);
        System.out.println(mappa.keySet());
        return true;
    }
    
    
    public boolean AggiungiAbbonamento(LocalDate DataInizio, String CodiceFiscale, tipoAbbonamento tipo)
    {
        System.out.println(mappa.keySet());
        Abbonamento nuovo;
        for(Iscritto i : mappa.keySet())
        {
            if(i.getCodFiscale().equals(CodiceFiscale))
            {
                
                mappa.get(i).add(nuovo = new Abbonamento(DataInizio, CodiceFiscale,tipo));
                return true;
            }
        }
        return false;
    }
    
    
    
    public Iscritto CercaIscritto(String CodFiscale)
    {
        for(Iscritto i : mappa.keySet())
        {
            if(i.getCodFiscale().equals(CodFiscale))
            {
                return i;
            }
            
        }
        return null;
    }
    
    public HashMap<Iscritto, ArrayList<Abbonamento>> getMappa()
    {
        return ManagerIscrittiAbbonamenti.mappa;
    }
    
    
    public void SalvaIscritti()
    {
        csv.ScriviIscritti(ManagerIscrittiAbbonamenti.mappa);
    }
    
    public void CaricaIscritti()
    {
        csv.LeggiIscritti(ManagerIscrittiAbbonamenti.mappa);
    }
    
    public void SalvaAbbonamenti()
    {
        csv.ScriviAbbonamenti(ManagerIscrittiAbbonamenti.mappa);
    }
    
    public void CaricaAbbonamenti()
    {
        csv.LeggiAbbonamenti(ManagerIscrittiAbbonamenti.mappa);
    }
    

    
}
