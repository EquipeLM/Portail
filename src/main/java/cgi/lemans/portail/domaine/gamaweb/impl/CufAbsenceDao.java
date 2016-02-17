/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;

/**
 *
 * @author souchul
 */
@Repository
public class CufAbsenceDao extends AbstractGenericDaoGamaweb<CufAbsence> implements ICufAbsenceDao{
	
	public static final String CONGES = "1";
	public static final String RTT_Q1 = "2";
	public static final String RTT_Q2 = "3";

    @Override
    public List<CufAbsence> findCufAbsenceByCongeAndRessourceAndPris(String idRessource) {
        String hql = "SELECT sum(a.nombreDeJour) as pris " 
                + "from CufAbsence a " 
                + "where a.annee= :annee"
                + "and a.typeAbsence = 1 "
                + "and a.ressource.idRessource = ':idRessource' ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List<CufAbsence> results = query.list();
        return results;
    }

    @Override
    public List<CufAbsence> findCufAbsenceByrttq1AndRessourceAndPris(String idRessource) {
        String hql = "SELECT sum(a.nombreDeJour) as pris " 
                + "from CufAbsence a " 
                + "where a.annee= :annee"
                + "and a.typeAbsence = 2 "
                + "and a.ressource.idRessource = ':idRessource' ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List<CufAbsence> results = query.list();
        return results;
    }

    @Override
    public List<CufAbsence> findCufAbsenceByrttq2AndRessourceAndPris(String idRessource) {
    	String hql = "SELECT sum(a.nombreDeJour) as pris " 
    			+ "from CufAbsence a " 
    			+ "where a.annee= :annee "
    			+ "and a.typeAbsence = 3 "
    			+ "and a.ressource.idRessource = ':idRessource' ";
    	Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
    	List<CufAbsence> results = query.list();
    	return results;
    }
    
    @Override
    public List<Object[]> findCufAbsenceByTypeByRessource(String idRessource, String type) {
        String hql = "SELECT sum(a.nombreDeJour) as pris " 
                + "from CufAbsence a "
                + "where a.annee= :annee "
                + "and a.typeAbsence.idTypeAbsence = :type "
                + "and a.ressource.id = :idRessource ";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        query.setParameter("type", Integer.parseInt(type));
        List<Object[]> results = query.list();
        return results;
    }
    
}
