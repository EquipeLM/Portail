/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import java.util.Calendar;


/**
 *
 * @author souchul
 */
@Repository
public class AbsenceDao extends AbstractGenericDaoGamaweb<Absence> implements IAbsenceDao{

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
                   + "like :equipeChoisie"
                   + "and (month(a.premierJourAbsence) = :moisAafficher"
                   + "and (year(a.premierJourAbsence) = :AnneeAafficher";
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ equipeLibelle + '%');
        query.setParameter("anneeEnCours", Calendar.getInstance().get(Calendar.YEAR));
        query.setParameter("moisAafficher", moisAafficher);
        List<Absence> results = (List<Absence>)query.list();
    	return results;
    }

}
