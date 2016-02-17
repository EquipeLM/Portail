/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface IAbsenceDao extends IGenericDao<Serializable, Absence>{
    
    public List<Absence> findAbsenceByPremierJourAbsence(String idRessource);
    
    public List<Absence> findAbsenceByDureeAbsence(String idRessource);
    
}

