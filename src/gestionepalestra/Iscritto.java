package gestionepalestra;


public class Iscritto 
{
    private String nome;
    private String cognome;
    private String CodFiscale;
    
    public Iscritto (String nome, String cognome, String CodFiscale)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.CodFiscale = CodFiscale;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getCognome()
    {
        return this.cognome;
    }
    
    public String getCodFiscale()
    {
        return this.CodFiscale;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    
    public void setCodFiscale(String Codfiscale)
    {
        this.CodFiscale = CodFiscale;
    }
    
    @Override
    public String toString()
    {
        return "Nome = " + this.nome + "\n" + "Cognome = " + this.cognome + "\n" + "Codice Fiscale = " + this.CodFiscale;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this.getClass() != o.getClass())
        {
            return false;
        }
        
        final Iscritto a = (Iscritto) o;
        if (this.getNome().equals(a.getNome()))
        {
            if(this.getCognome().equals(a.getCognome()))
            {
                if(this.getCodFiscale() == a.getCodFiscale())
                {
                    return true;
                }
            }
        }
        return false;
    }
}
