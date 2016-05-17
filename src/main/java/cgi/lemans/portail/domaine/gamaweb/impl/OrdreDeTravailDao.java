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
	public List<Object[][]> findAllDemande(String idRessource) {
		String hql = "select case " + "when a.chargeRestante + a.chargeConcommeeTotale>a.chargePrevue then 1 "
				+ "when a.chargeRestante + a.chargeConcommeeTotale<a.chargePrevue then 3 " + "else 2 "
				+ "end as code_type_delai, dem, a " + "from OrdreDeTravail a " + "left join a.idDemande dem "
				+ "where a.typeActivite <> 'HTM' " + "and a.chargeRestante <> 0 " + "and a.ressource = :idRessource  ";
		Query query = getSession().createQuery(hql);
		query.setParameter("idRessource", idRessource);
		System.out.println(query.getQueryString());

		List<Object[][]> results = query.list();
		return results;

	}

}
