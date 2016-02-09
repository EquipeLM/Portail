/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.impl.gamaweb;

import java.util.List;

import org.hibernate.Query;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.impl.newportal.AbstractGenericDaoNewPortal;


/**
 *
 * @author souchul
 */
public class AbsenceDao extends AbstractGenericDaoNewPortal<Absence> implements IAbsenceDao{
    
   
    
    @Override
    public List<Absence> findAbsenceByCongeAndRessourceAndPris(String idRessource) {
        String hql = "SELECT sum(a.nombreJourAbsence) as pris "
        		+ "from Absence a "
        		+ "where a.annee='2016' "
        		+ "and a.refTypeAbsence.idTypeAbsence = 1 "
        		+ "and a.refRessource.idRessource = ':idRessource' ";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource);
        List<Absence> results = query.list();
        return results;
    }

    @Override
    public Absence findAbsenceByCongeAndRessourceAndSolde(String idRessource) {
		return null;
        /*String hql = "select solde from cuf_ressource_absence a where a.annee='2016' and a.ref_type_absence='1' and a.idressource LIKE :idResources";
        Query query = session.createQuery(hql);
        List results = query.list();*/


    }

   
    
    
}
