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

    @Override
    public List<DemandeOuProjet> findListDemande(String tag) {
        String hql = "select a from DemandeOuProjet a "
                   + "left join a.refRessource ref "
                   + "where ref.tags " 
                   + "like :equipeChoisie "
                   + "and a.dernierEtat != 'TER'"
                   + "and a.chargeRestanteTotale !=0"
                   + "and a.typeDemande not in('PRV')"
                   ;
        Query query = getSession().createQuery(hql);
        query.setParameter("equipeChoisie", '%'+ tag + '%');
        List<DemandeOuProjet> results = (List<DemandeOuProjet>)query.list();
    	return results;
    
    }
    
    
    /*select * from demande_ou_projet a
left join ressource_tma b on a.ref_ressource = b.idressource
where b.tags like '%CNP%' and Dernier_etat!='TER' and charge_restante_totale!=0 and type_demande not in ('PRV')*/
}
