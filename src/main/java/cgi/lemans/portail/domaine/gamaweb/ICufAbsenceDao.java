/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.util.List;

import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;

/**
 *
 * @author souchul
 */
public interface ICufAbsenceDao {
    
    /**
     * @param idRessource
     * @return
     */
    public List<CufAbsence> findCufAbsenceByCongeAndRessourceAndPris(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */
    public List<CufAbsence> findCufAbsenceByrttq1AndRessourceAndPris(String idRessource);
    
    /**
     * @param idRessource
     * @return
     */
    public List<CufAbsence> findCufAbsenceByrttq2AndRessourceAndPris(String idRessource);

	/**
	 * @param idRessource
	 * @param type
	 * @return
	 */
	public List<Object[]> findCufAbsenceByTypeByRessource(String idRessource, String type);
    
    
}
