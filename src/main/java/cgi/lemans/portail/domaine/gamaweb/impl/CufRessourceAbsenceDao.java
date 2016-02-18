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

import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;

/**
 *
 * @author souchul
 */
@Repository
public class CufRessourceAbsenceDao extends AbstractGenericDaoGamaweb<CufRessourceAbsence> implements ICufRessourceAbsenceDao{

    public static final String CONGES = "1";
    public static final String RTT_Q1 = "2";
    public static final String RTT_Q2 = "3";
    

    @Override
    public CufRessourceAbsence findCufRessourceAbsenceByTypeByRessource(String idRessource, String type) {
        String hql =  "from CufRessourceAbsence a "
                + "where a.annee= :annee "
                + "and a.typeAbsence.idTypeAbsence = :type "
                + "and a.ressourceTma.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql);
        query.setParameter("idRessource", idRessource);
        query.setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        query.setParameter("type", Integer.parseInt(type));
        CufRessourceAbsence results = (CufRessourceAbsence) query.uniqueResult();
        return results;
    }
    
}
