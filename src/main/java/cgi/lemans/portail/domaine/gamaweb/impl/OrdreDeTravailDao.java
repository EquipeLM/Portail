/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class OrdreDeTravailDao extends AbstractGenericDaoGamaweb<OrdreDeTravail> implements IOrdreDeTravailDao{

        
    
    @Override
    public List<OrdreDeTravail> findAllDemande(String tag) {
         String hql = 
                    "from OrdreDeTravail a "
                    + "left join a.Ressource ref "
                   + "where a.typeActivite!='HTM' "
                   + "and a.chargeRestante!=0 "
                   + "and ref.tags " 
                   + "like :equipeChoisie "
                   ;
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        System.out.println(query.getQueryString());
        
        List<OrdreDeTravail> results = (List<OrdreDeTravail>)query.list();
    	return results;        
    
    }

    

   
    
    
    
}
