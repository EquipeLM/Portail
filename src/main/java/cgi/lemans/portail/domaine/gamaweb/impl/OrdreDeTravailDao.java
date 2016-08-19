/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;

/**
 *
 * @author souchul
 */
@Repository
public class OrdreDeTravailDao extends AbstractGenericDaoGamaweb<OrdreDeTravail> implements IOrdreDeTravailDao {

	@Override
	public List<OrdreDeTravail> findAllDemande(String idRessource) {
		String hql = "from OrdreDeTravail a "
                            
                            + "where a.typeActivite!='HTM' "
                            
                            
                            + "and a.ressource.idRessource = :idRessource" ;
		Query query = getSession().createQuery(hql);
		query.setParameter("idRessource", idRessource);
		System.out.println(query.getQueryString());

		List<OrdreDeTravail> results = query.list();
		return results;

	}
      

    @Override
    public List<OrdreDeTravail> findAllDemandeEquipe(String tag) {
                String hql = "from OrdreDeTravail a "   
                            //+ "left join a.ressource ref " 
                            + "where a.ressource.tags " 
                            + "like :equipeChoisie "
                            + "and a.typeActivite != 'HTM' "
                            + "and a.chargeRestante != 0"
                           ;
		Query query = getSession().createQuery(hql);
		query.setParameter("equipeChoisie", '%'+ tag + '%');
		
		List<OrdreDeTravail> results = query.list();
		return results; 
    }

    @Override
    public List<OrdreDeTravail> findIdDemandePlanning(String id) {
        String hql = "from OrdreDeTravail a "   

                            + "where a.chargeRestante != 0"
                            + "and a.idDemande.idDemande = :id"
                           ;
		Query query = getSession().createQuery(hql);
		
                query.setParameter("id", id);
		
		List<OrdreDeTravail> results = query.list();
		return results; 
    }

}
