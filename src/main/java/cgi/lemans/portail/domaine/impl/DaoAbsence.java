/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.impl;

import cgi.lemans.portail.domaine.entites.Absence;
import java.util.List;

import org.hibernate.Query;


/**
 *
 * @author souchul
 */
public class DaoAbsence extends AbstractGenericDao implements IDaoAbsence{
    
   
    
    @Override
    public Absence findAbsenceByCongeAndRessourceAndPris(String idRessource) {
        String hql = "SELECT sum(a.nombre_jour) as pris from cuf_absence a where a.annee='2016' and a.ref_type_absence='1' and a.idressource LIKE :idResources";
        Query query = getSession().createQuery(hql).setParameter("idRessource", idRessource);
        List results = query.list();
        return (Absence) results;
    }

    @Override
    public Absence findAbsenceByCongeAndRessourceAndSolde(String idRessource) {
        /*String hql = "select solde from cuf_ressource_absence a where a.annee='2016' and a.ref_type_absence='1' and a.idressource LIKE :idResources";
        Query query = session.createQuery(hql);
        List results = query.list();*/


    }

   
    
    
}
