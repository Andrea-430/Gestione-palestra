package gestionepalestra;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import gestionepalestra.Abbonamento.tipoAbbonamento;


public class CsvManager 
{
    //private BufferedReader reader;
    
    
    public CsvManager()
    {
        
    }
    
    public void ScriviIscritti(HashMap <Iscritto, ArrayList<Abbonamento>> mappa)
    {
        try(FileWriter writer = new FileWriter("DatiUtenti.csv"))
        {
            
            for (Iscritto i : mappa.keySet())
            {
                writer.append(i.getNome()).append(",");
                writer.append(i.getCognome()).append(",");
                writer.append(i.getCodFiscale()).append(",");
                writer.append("\n");
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void LeggiIscritti(HashMap <Iscritto, ArrayList<Abbonamento>> mappa)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("DatiUtenti.csv")))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                if(line == null)
                {
                    return;
                }
                String []riga = line.split(",");
                if(riga.length < 3)
                {
                    return;
                }
                String nome = riga[0];
                String cognome = riga[1];
                String CodFiscale = riga[2];
                Iscritto i = new Iscritto(nome, cognome, CodFiscale);
                ArrayList abbonamenti = new ArrayList();
                mappa.put(i, abbonamenti);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void ScriviAbbonamenti(HashMap <Iscritto, ArrayList<Abbonamento>> mappa)
    {
        try(FileWriter writer = new FileWriter("DatiAbbonamenti.csv"))
        {
            
            for(Iscritto iscritto : mappa.keySet())
            {
                if(mappa.get(iscritto) != null && !mappa.get(iscritto).isEmpty() )
                {
                    for(int i = 0; i < mappa.get(iscritto).size(); i++)
                    {
                        writer.append(mappa.get(iscritto).get(i).getDataInizio().toString()).append(",");
                        writer.append(mappa.get(iscritto).get(i).getDataFine().toString()).append(",");
                        writer.append(mappa.get(iscritto).get(i).getCodFiscale()).append(",");
                        writer.append(mappa.get(iscritto).get(i).getTipo().toString()).append("\n");
                    }
                }
                
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    

    
    public void LeggiAbbonamenti(HashMap <Iscritto, ArrayList<Abbonamento>> mappa)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("DatiAbbonamenti.csv")))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] riga = line.split(",");
                if(riga.length < 4)
                {
                    continue;
                }
                
                String [] dataI = riga[0].split("-");
                LocalDate DataInizio = LocalDate.now();
                tipoAbbonamento tipo = null;
                
                try
                {
                    int anno = Integer.parseInt(dataI[0]);
                    int mese = Integer.parseInt(dataI[1]);
                    int giorno = Integer.parseInt(dataI[2]);
                    DataInizio = LocalDate.of(anno,mese,giorno);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
                if(riga[3].equalsIgnoreCase("Mensile"))
                {
                    tipo = tipoAbbonamento.Mensile;
                }
                else if (riga[3].equalsIgnoreCase("Annuale"))
                {
                    tipo = tipoAbbonamento.Annuale;
                }
                
                for(Iscritto iscritto : mappa.keySet())
                {
                    if(iscritto.getCodFiscale().equals(riga[2]))
                    {
                        Abbonamento a = new Abbonamento (DataInizio, riga[2], tipo);
                        mappa.get(iscritto).add(a);
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
