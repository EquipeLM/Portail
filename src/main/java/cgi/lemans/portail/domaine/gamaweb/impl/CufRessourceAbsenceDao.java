/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class CufRessourceAbsenceDao extends AbstractGenericDaoGamaweb<CufRessourceAbsence> implements ICufRessourceAbsenceDao{

    @Override
    public List findCufRessourceAbsenceByCongeAndRessourceAndSolde(String idRessource) {
         String hql =  "from cuf_ressource_absence a"
        		+ "where a.annee= :annee "
        		+ "and a.typeAbsence = 1 "
        		+ "and a.ressourceTma.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List results = (List) query.uniqueResult();
        return results;
    }

    @Override
    public List findCufRessourceAbsenceByRttQ1AndRessourceAndSolde(String idRessource) {
        String hql =  "from cuf_ressource_absence a"
        		+ "where a.annee= :annee "
        		+ "and a.t ypeAbsence = 2 "
        		+ "and a.ressourceTma.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List results = (List) query.uniqueResult();
        return results;
    }

    @Override
    public List findCufRessourceAbsenceByRttQ2AndRessourceAndSolde(String idRessource) {
        String hql =  "from cuf_ressource_absence a"
        		+ "where a.annee= :annee "
        		+ "and a.typeAbsence = 3 "
        		+ "and a.ressourceTma.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List results = (List) query.uniqueResult();
        return results;
    }
    
}
