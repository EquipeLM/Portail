/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.impl.gamaweb;

import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author souchul
 */
public class CufAbsenceDao extends AbstractGenericDaoGamaweb<CufAbsence> implements ICufAbsenceDao{

    @Override
    public List findCufAbsenceByCongeAndRessourceAndPris(String idRessource) {
        String hql = "SELECT sum(a.nombreDeJour) as pris " 
                + "from CufAbsence a " 
                + "where a.annee= :annee"
                + "and a.typeAbsence = 1 "
                + "and a.ressource.idRessource = ':idRessource' ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource).setParameter("annee", Calendar.getInstance().get(Calendar.YEAR));
        List results = query.list();
        return results;
    }
    
}
