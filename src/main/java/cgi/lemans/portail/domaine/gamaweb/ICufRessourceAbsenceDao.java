/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.io.Serializable;
import java.util.List;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;

/**
 *
 * @author souchul
 */
public interface ICufRessourceAbsenceDao extends IGenericDao<Serializable, CufRessourceAbsence> {
    
     /**
     * @param idRessource
     * @return
     */
    //public List findCufRessourceAbsenceByCongeAndRessourceAndSolde(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */
    //public List findCufRessourceAbsenceByRttQ1AndRessourceAndSolde(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */    
    //public List findCufRessourceAbsenceByRttQ2AndRessourceAndSolde(String idRessource);
    
    /**
    * @param idRessource
    * @param type
    * @return
    */
    public List<CufRessourceAbsence> findCufRessourceAbsenceByTypeByRessource(String idRessource, String type);
    
}
