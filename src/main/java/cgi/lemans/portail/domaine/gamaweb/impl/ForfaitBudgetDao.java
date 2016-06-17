/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.ForfaitBudget;
import cgi.lemans.portail.domaine.gamaweb.IForfaitBudgetDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class ForfaitBudgetDao extends AbstractGenericDaoGamaweb<ForfaitBudget> implements IForfaitBudgetDao{

    @Override
    public List<ForfaitBudget> findForfaitModalDm() {
        String hql = "from ForfaitBudget a "
                    + "where a.dateFinForfaitBudget > :dateToday ";
		
        Query query = getSession().createQuery(hql);
	query.setDate("dateToday", new java.util.Date());

	List<ForfaitBudget> results = query.list();
	return results;
    }
    
}
