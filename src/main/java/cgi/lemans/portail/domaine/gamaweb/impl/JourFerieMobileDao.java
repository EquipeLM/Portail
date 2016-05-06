/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.JourFerieMobile;
import cgi.lemans.portail.domaine.gamaweb.IJourFerieMobileDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class JourFerieMobileDao extends AbstractGenericDaoGamaweb<JourFerieMobile> implements IJourFerieMobileDao{

    @Override
    public List<JourFerieMobile> findJourFerie() {
        String hql = "from JourFerieMobile a "
                    + "where a.refCalendrier = '13' ";
        Query query = getSession().createQuery(hql);
        List<JourFerieMobile> results = (List<JourFerieMobile>)query.list();
    	return results;
    }
    
}
