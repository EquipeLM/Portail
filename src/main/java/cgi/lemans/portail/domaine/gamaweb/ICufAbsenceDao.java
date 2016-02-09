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
public interface ICufAbsenceDao {
    
    /**
     * @param idRessource
     * @return
     */
    public List findCufAbsenceByCongeAndRessourceAndPris(String idRessource);
    
}
