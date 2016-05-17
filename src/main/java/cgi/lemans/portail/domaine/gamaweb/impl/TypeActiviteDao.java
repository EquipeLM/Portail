/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.TypeActivite;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import cgi.lemans.portail.domaine.gamaweb.ITypeActiviteDao;

/**
 *
 * @author souchul
 */

@Repository
public class TypeActiviteDao extends AbstractGenericDaoGamaweb<TypeActivite> implements ITypeActiviteDao{

    @Override
    public List<TypeActivite> findTypeOTModal() {
        String hql = "from TypeActivite a ";
        Query query = getSession().createQuery(hql);
        List<TypeActivite> results = (List<TypeActivite>)query.list();
    	return results;
    }
    
    
    
}
