/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.gamaweb.IRessourceTmaDao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author souchul
 */
public class RessourceTmaDao extends AbstractGenericDaoGamaweb<RessourceTma> implements IRessourceTmaDao{

    @Override
    public List<RessourceTma> findEquipeByCNP() {
        String hql = "SELECT prenom, nom, idRessource " 
                + "from RessourceTma a " 
                + "where a.tags"
                + "like '%CNP%' ";
        Query query = getSession().createQuery(hql);
        List<RessourceTma> results = query.list();
        return results;
        
    }
    
}
