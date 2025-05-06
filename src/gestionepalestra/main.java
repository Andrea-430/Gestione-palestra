/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionepalestra;
import java.time.LocalDate;
import gestionepalestra.Abbonamento.tipoAbbonamento;
import GUI.FramePrincipale;


public class main {

    
    public static void main(String[] args) 
    {
         ManagerIscrittiAbbonamenti manager = ManagerIscrittiAbbonamenti.getInstance();
         manager.CaricaIscritti();
         manager.CaricaAbbonamenti();
         FramePrincipale f = new FramePrincipale();
         f.init();
    }
    
}
