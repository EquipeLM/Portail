/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.util.List;

/**
 *
 * @author souchul
 */
public interface ICufRessourceAbsenceDao {
    
     /**
     * @param idRessource
     * @return
     */
    public List findCufRessourceAbsenceByCongeAndRessourceAndSolde(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */
    public List findCufRessourceAbsenceByRttQ1AndRessourceAndSolde(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */    
    public List findCufRessourceAbsenceByRttQ2AndRessourceAndSolde(String idRessource);
}
