/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import java.io.Serializable;
import java.util.List;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;

/**
 *
 * @author souchul
 */
public interface ICufAbsenceDao extends IGenericDao<Serializable, CufAbsence> {
    
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
	public Long findCufAbsenceByTypeByRessource(String idRessource, String type);
    
    
}
