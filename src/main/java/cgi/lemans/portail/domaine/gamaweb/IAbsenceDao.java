/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.io.Serializable;
import java.util.List;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;

/**
 *
 * @author souchul
 */
public interface IAbsenceDao extends IGenericDao<Serializable, Absence>{
    
    /**
     * @param idRessource
     * @return
     */
    public Absence findAbsenceByPremierJourAbsence(String idRessource);
    
    
     /**
     * @param EquipeLibelle
     * @return
     */
    public List<Absence> findAbsenceByEquipe (String EquipeLibelle, String moisAafficher);
    
    /**
     * @param idRessource
     * @param type
     * @return
     */
    
    public List<Absence> findAbsenceByUser (String idRessource);
    
    public Double findAbsenceByTypeByRessource(String idRessource, String type);
    
}

