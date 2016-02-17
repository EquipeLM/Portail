/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;


import org.springframework.stereotype.Repository;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author souchul
 */
@Repository
public class AbsenceDao extends AbstractGenericDaoGamaweb<Absence> implements IAbsenceDao{

    @Override
    public List<Absence> findAbsenceByPremierJourAbsence(String idRessource) {
        String hql = "SELECT a.premierJourAbsence " 
                + "from Absence a "
                + "where a.premierJourAbsence >= :dateToday "
                + "and a.refRessource.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setDate("dateToday", new java.util.Date());
        List<Absence> results = query.list();
        return results;
    }

    @Override
    public List<Absence> findAbsenceByDureeAbsence(String idRessource) {
       String hql = "SELECT a.nombreJourAbsence "
                + "from Absence a "
                + "where a.premierJourAbsence = some (SELECT aBis.premierJourAbsence " 
                + "from Absence aBis "
                + "where aBis.premierJourAbsence >= :dateToday "
                + "and aBis.refRessource.idRessource = :idRessource)";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setDate("dateToday", new java.util.Date());
        List<Absence> results = query.list();
        return results; 
    }
}
