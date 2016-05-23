/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.gamaweb.IRessourceTmaDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class RessourceTmaDao extends AbstractGenericDaoGamaweb<RessourceTma> implements IRessourceTmaDao{

    @Override
    public List<RessourceTma> findQuiEquipe(String tag) {
            String hql = "from RessourceTma a "
                            + "where a.tags "
                            + "like :tag" ;
		Query query = getSession().createQuery(hql);
		query.setParameter("tag", tag);
		System.out.println(query.getQueryString());

		List<RessourceTma> results = query.list();
		return results;

	}
    }

    
    

