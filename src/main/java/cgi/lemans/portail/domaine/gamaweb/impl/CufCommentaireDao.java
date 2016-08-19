/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.CufCommentaire;
import cgi.lemans.portail.domaine.gamaweb.ICufCommentaireDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class CufCommentaireDao extends AbstractGenericDaoGamaweb<CufCommentaire> implements ICufCommentaireDao{

    
    @Override
    public List<CufCommentaire> findCommentaire() {
        String hql = "from CufCommentaire a " 
                                
                ;
        Query query = getSession().createQuery(hql);
        List<CufCommentaire> results = (List<CufCommentaire>) query.list();
        return results;
    }
    
}
