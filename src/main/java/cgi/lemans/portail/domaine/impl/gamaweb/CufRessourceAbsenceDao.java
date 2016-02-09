/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.impl.gamaweb;

import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import java.util.Calendar;
import org.hibernate.Query;

/**
 *
 * @author souchul
 */
public class CufRessourceAbsenceDao extends AbstractGenericDaoGamaweb<CufRessourceAbsence> implements ICufRessourceAbsenceDao{

    @Override
    public String findCufRessourceAbsenceByCongeAndRessourceAndSolde(String idRessource) {
         String hql =  "from cuf_ressource_absence a"
        		+ "where a.annee= :annee "
        		+ "and a.typeAbsence = 1 "
        		+ "and a.ressourceTma.idRessource = :idRessource ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        String results = (String) query.uniqueResult();
        return results;
    }
    
}
