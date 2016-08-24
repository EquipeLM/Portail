/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.CufPlanning;
import cgi.lemans.portail.domaine.gamaweb.ICufPlanningDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */

@Repository
public class CufPlanningDao extends AbstractGenericDaoGamaweb<CufPlanning> implements ICufPlanningDao{

    @Override
    public List<CufPlanning> findListDemandePlanning(String tag) {
        
        String hql = "from CufPlanning a " 
                   + "where a.equipePlanning " 
                   + "like :equipeChoisie "
                   ; 
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        
        List<CufPlanning> results = query.list();
    	return results;
        
    }
    
    @Override
    public List<CufPlanning> findTotalPlan(String tag) {
        
        String hql = "select a.idRessource, a.noSem, count(a.chargePlanifie)"
                   + "from CufPlanning a " 
                   + "where a.equipePlanning " 
                   + "like :equipeChoisie "
                   
                   ;
              
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        
        List<CufPlanning> results = (List<CufPlanning>) query.list();
        CufPlanning number = (CufPlanning) results.get(0);
    	return results;
        
    }
    
    public List<CufPlanning> findListIDDemandePlanning(String tag) {
        
        String hql = "from CufPlanning a " 
                   + "where a.equipePlanning " 
                   + "like :equipeChoisie "
                   + " and a.idDemande =: id" 
                   
                   ;
              
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        
        List<CufPlanning> results = query.list();
    	return results;
        
    }
    
}
