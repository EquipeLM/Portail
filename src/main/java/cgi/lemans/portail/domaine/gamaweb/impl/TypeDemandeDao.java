/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.TypeDemande;
import cgi.lemans.portail.domaine.gamaweb.ITypeDemandeDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class TypeDemandeDao extends AbstractGenericDaoGamaweb<TypeDemande> implements ITypeDemandeDao{

    @Override
    public List<TypeDemande> findForfaitModalDm() {
         String hql = "from TypeDemande a ";
                    
		
        Query query = getSession().createQuery(hql);
	

	List<TypeDemande> results = query.list();
	return results;
    }
    
}
