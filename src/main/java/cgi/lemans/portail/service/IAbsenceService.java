/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import cgi.lemans.portail.config.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;

/**
 *
 * @author souchul
 */
public interface IAbsenceService {
    
    /**
     * @return
     */
    public AbsenceCardBean recupererInfosAbsRessource();
    
    
    
}
