/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface IDemandeOuProjetDao extends IGenericDao<Serializable, DemandeOuProjet> {
    
    public List<DemandeOuProjet> findListDemande(String tag);
    //public Double findAllDemandeASS(String type);
    //public List<DemandeOuProjet> findListIDDemandePlanning(String tag, String id);
    //public List<DemandeOuProjet> findListDemandePlanning(String tag);
    
}
