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
    public List<CufCommentaire> findCommentaire(Integer idOT) {
        String hql = "from CufCommentaire a " 
                + "where a.idOT= :idOT "
                
                ;
        Query query = getSession().createQuery(hql).setParameter("idOT", idOT);
        List<CufCommentaire> results = query.list();
        return results;
    }
    
}
