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

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;


/**
 *
 * @author souchul
 */
@Repository
public class AbsenceDao extends AbstractGenericDaoGamaweb<Absence> implements IAbsenceDao{

    
	public static final String CONGES = "1";
	public static final String RTT_Q1 = "2";
	public static final String RTT_Q2 = "3";
    
    @Override
    public Absence findAbsenceByPremierJourAbsence(String idRessource) {
        String hql = "from Absence a "
                + "where a.premierJourAbsence >= :dateToday "
                + "and a.refRessource.idRessource = :idRessource "
                + "order by a.premierJourAbsence";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setDate("dateToday", new java.util.Date());
        query.setMaxResults(1);
        Absence results = (Absence) query.uniqueResult();
        return results;
    }
    
    @Override
    public List<Absence> findAbsenceByEquipe (String equipeLibelle, String moisAafficher){
        String hql = "select a from Absence a "
                   + "left join a.refRessource ref "
                   + "where ref.tags " 
                   + "like :equipeChoisie "
//                   + "and (month(a.premierJourAbsence) = :moisAafficher or month(a.dateFinAbsence) = :moisAafficher) "
                   + "and (year(a.premierJourAbsence) = :anneeEnCours or year(a.dateFinAbsence) = :anneeEnCours) "
                   + "and ref.dateDepart > :date "
                   + "order by ref.nom desc"
                   ;
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ equipeLibelle + '%');
        query.setParameter("anneeEnCours", Calendar.getInstance().get(Calendar.YEAR));
        query.setDate("date", new java.util.Date());
//        query.setParameter("moisAafficher", ConvertUtils.parseInteger(moisAafficher) + 1 );
        List<Absence> results = (List<Absence>)query.list();
    	return results;
    }
    
    public List<Absence> findAbsenceByUser (String idRessource){
        String hql = "from Absence a "
                    + "where a.refRessource.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        List<Absence> results = (List<Absence>)query.list();
    	return results;
    }
    
    @Override
    public Double findAbsenceByTypeByRessource(String idRessource, String type) {
        String hql = "SELECT sum(a.nombreJourAbsence) as pris " 
                + "from Absence a "
                + "where YEAR(a.premierJourAbsence)= :annee "
                + "and a.refTypeAbsence.idTypeAbsence = :type "
                + "and a.refRessource.id = :idRessource ";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        query.setParameter("type", Integer.parseInt(type));
        Double results = (Double) query.uniqueResult();
        return results;
    }

}
