/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;
import cgi.lemans.portail.domaine.entites.gamaweb.CufControleIncoherence;
import cgi.lemans.portail.domaine.gamaweb.ICufControleIncoherenceDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class CufControleIncoherenceDao extends AbstractGenericDaoGamaweb<CufControleIncoherence> implements ICufControleIncoherenceDao{

    @Override
    public List<CufControleIncoherence> findNbIncoherence(String idRessource) {
        String hql = "from CufControleIncoherence a "
                + "where a.dateDerniereDetection = :dateToday "
                + "and a.idRessource = :idRessource";      
       
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setDate("dateToday", new java.util.Date());
        List<CufControleIncoherence> results = (List<CufControleIncoherence>)query.list();
    	return results;
    }
    
}
