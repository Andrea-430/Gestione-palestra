package gestionepalestra;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Abbonamento 
{
    public enum tipoAbbonamento{Mensile, Annuale};
    private tipoAbbonamento tipo;
    private LocalDate DataInizio;
    private LocalDate DataFine;
    private String CodFiscale;
    
    
    
    public Abbonamento (LocalDate DataInizio, String CodiceFiscale, tipoAbbonamento tipo )
    {
        this.DataInizio = DataInizio;
        this.tipo = tipo;
        if(tipo == tipo.Mensile)
        {
            this.DataFine = DataInizio.plus(1, ChronoUnit.MONTHS);
        }
        else
        {
            this.DataFine = DataInizio.plus(1, ChronoUnit.YEARS);
        }
        this.DataFine = DataFine;
        this.CodFiscale = CodiceFiscale;
        
    }
       
    public LocalDate getDataInizio()
    {
        return this.DataInizio;
    }
    
    public LocalDate getDataFine()
    {
        return this.DataFine;
    }
    
    public String getCodFiscale()
    {
        return this.CodFiscale;
    }
    
    public tipoAbbonamento getTipo()
    {
        return this.tipo;
    }
    
    public void setDataInizio(LocalDate DataInizio)
    {
        this.DataInizio = DataInizio;
    }
    
    public void sedDataFine(LocalDate DataFine)
    {
        this.DataFine = DataFine;
    }
    
    public void setCodFiscale(String CodFiscale)
    {
        this.CodFiscale = CodFiscale;
    }
    
    public void setTipo(String tipo)
    {
        if(tipo.equals("Mensile"))
        {
            this.tipo = tipoAbbonamento.Mensile;
        }
        else if(tipo.equals("Annuale"))
        {
            this.tipo = tipoAbbonamento.Annuale;
        }
    }
    
    @Override
    public String toString()
    {
        return  "Tipo di abbonamento = " + this.tipo + "\n" + "Data di inizio = " + this.DataInizio + "\n" + "Data di fine = " +  this.DataFine;
    }
    
    
}
