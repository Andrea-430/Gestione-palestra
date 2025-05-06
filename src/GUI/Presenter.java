package GUI;
import gestionepalestra.ManagerIscrittiAbbonamenti;
import java.time.LocalDate;
import gestionepalestra.Abbonamento.tipoAbbonamento;

public class Presenter 
{
        private ManagerIscrittiAbbonamenti manager;
    
        public Presenter()
        {
            this.manager = ManagerIscrittiAbbonamenti.getInstance();
        }
    
        public String NuovoIscritto(String nome, String cognome, String CodiceFiscale)
        {
            if(manager.AggiungiIscritto(nome, cognome, CodiceFiscale) == true)
            {
                return "Iscritto aggiunto con successo";
            }
            return "Codice fiscale già presente";
        }
        
        
        
        public String NuovoAbbonamento (int Anno, int Mese, int Giorno, String CodiceFiscale,tipoAbbonamento tipo)
        {
            LocalDate DataInizio = LocalDate.of(Anno,Mese,Giorno);
            if(manager.AggiungiAbbonamento(DataInizio, CodiceFiscale, tipo) == true)
            {
                return "Abbonamento aggiunto con successo";
            }
            else
            {
                return "Qualcosa è andato storto, riprova";
            }
        }
        
        public void SalvaIscritti()
        {
            manager.SalvaIscritti();
        }
        
        public void SalvaAbbonamenti()
        {
            manager.SalvaAbbonamenti();
        }
    
}
