/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;

/**
 *
 * @author souchul
 */
public interface IAbsenceService {
    
    public CufAbsence affichageCongePris();
    public CufAbsence affichageRttq1Pris();
    public CufAbsence affichageRttq2Pris();
    
    public CufRessourceAbsence affichageCongeSolde();
    public CufRessourceAbsence affichageRttq1Solde();
    public CufRessourceAbsence affichageRttq2Solde();
    
    
    
}
