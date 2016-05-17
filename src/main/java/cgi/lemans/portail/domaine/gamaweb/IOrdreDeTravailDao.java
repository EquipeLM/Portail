/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface IOrdreDeTravailDao extends IGenericDao<Serializable, OrdreDeTravail>{
    
    public List<OrdreDeTravail> findAllDemande(String idRessource);
    
        
 
    
}
