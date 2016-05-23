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
                   //+ "left join a.idOT b "
                   //+ "left join b.idDemande c "
                   + "where a.equipePlanning " 
                   + "like :equipeChoisie "
                   //+ "and right(a.noSem,2) >= weekofyear(now())"
                   ;
              
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        
        List<CufPlanning> results = query.list();
    	return results;
        
    }
    
}
