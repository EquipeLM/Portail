/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.CufCommentaire;
import java.io.Serializable;

/**
 *
 * @author souchul
 */
public interface ICufCommentaireDao extends IGenericDao<Serializable, CufCommentaire>{
    
    public CufCommentaire findCommentaire(String idRessource);
    
    
}
