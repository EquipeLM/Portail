/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */

@Repository
public class DemandeOuProjetDao extends AbstractGenericDaoGamaweb<DemandeOuProjet> implements IDemandeOuProjetDao{

        public static final String ASS = "ASS";
	public static final String RE7 = "RE7";
	public static final String PRO = "PRO";
    
    
    @Override
    public List<DemandeOuProjet> findListDemande(String tag) {
        String hql = "select a from DemandeOuProjet a "
                   + "left join a.refRessource ref "
                   + "where ref.tags " 
                   + "like :equipeChoisie "
                   + "and a.dernierEtat != 'TER'"
                  
                   + "and a.typeDemande not in('PRV')"
                   ;
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        List<DemandeOuProjet> results = (List<DemandeOuProjet>)query.list();
    	return results;
    
    }
    
    public DemandeOuProjet findIdMax (){
        String hql = "select max(a.idDemande) from DemandeOuprojet";
        Query query = getSession().createQuery(hql);
        DemandeOuProjet results = (DemandeOuProjet)query.uniqueResult();
    	return results;
    }
    
  
   
    
    
    
    
    

   

    
    

}
