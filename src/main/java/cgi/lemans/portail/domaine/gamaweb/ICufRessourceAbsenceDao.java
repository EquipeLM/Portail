/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

/**
 *
 * @author souchul
 */
public interface ICufRessourceAbsenceDao {
    
     /**
     * @param idRessource
     * @return
     */
    public String findCufRessourceAbsenceByCongeAndRessourceAndSolde(String idRessource);
}
