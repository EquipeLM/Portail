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
         String hql =  "select case " 
                 + "when a.chargeRestante + a.chargeConcommeeTotale>a.chargePrevue then 1 " 
                 + "when a.chargeRestante + a.chargeConcommeeTotale<a.chargePrevue then 3 " 
                 + "else 2 " 
                 + "end as code_type_delai " 
                 + "from OrdreDeTravail a "
                 + "left join a.idDemande dem " 
                 + "left join a.ressource ref " 
                 + "where a.typeActivite != 'HTM' " 
                 + "and a.chargeRestante != 0 " 
                 + "and ref.tags " 
                 + "like :equipeChoisie ";
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        System.out.println(query.getQueryString());
        
        List<OrdreDeTravail> results = query.list();
    	return results;        
    
    }

    

   
    
    
    
}
