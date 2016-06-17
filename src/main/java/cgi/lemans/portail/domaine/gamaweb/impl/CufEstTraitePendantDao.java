/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.CufEstTraitePendant;
import cgi.lemans.portail.domaine.gamaweb.ICufEstTraitePendantDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class CufEstTraitePendantDao extends AbstractGenericDaoGamaweb<CufEstTraitePendant> implements ICufEstTraitePendantDao{

    @Override
    public List<CufEstTraitePendant> findAllDemandeTraiteStats(String idRessource) {
                String hql = "from CufEstTraitePendant a "
                            
                            +"where a.chargeRestante=0 "
                            +"and a.idOT.ressource.idRessource= :idRessource" ;
      
                        
		Query query = getSession().createQuery(hql);
		query.setParameter("idRessource", idRessource);
		System.out.println(query.getQueryString());

		List<CufEstTraitePendant> results = (List<CufEstTraitePendant>)query.list();
		return results;
    }

    
}
