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

}
