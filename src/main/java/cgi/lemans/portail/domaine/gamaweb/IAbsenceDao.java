/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.util.List;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;

/**
 *
 * @author souchul
 */
public interface IAbsenceDao {
    
    /**
     * @param idRessource
     * @return
     */
    public List<Absence> findAbsenceByCongeAndRessourceAndPris(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */
    public Absence findAbsenceByCongeAndRessourceAndSolde(String idRessource);
    
    
}
