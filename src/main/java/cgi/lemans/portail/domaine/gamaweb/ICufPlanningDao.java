/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.gamaweb.CufPlanning;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface ICufPlanningDao extends IGenericDao<Serializable, CufPlanning>{
    
   public List<CufPlanning> findListDemandePlanning (String tag) ;
    
}
