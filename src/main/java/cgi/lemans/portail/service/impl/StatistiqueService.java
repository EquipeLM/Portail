/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.StatistiqueBean;
import cgi.lemans.portail.domaine.gamaweb.ICufEstTraitePendantDao;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import cgi.lemans.portail.service.IStatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author souchul
 */

@Service
@Transactional(transactionManager = "txManagerGamaweb")
public class StatistiqueService implements IStatistiqueService{
    
    @Autowired
    private ICufEstTraitePendantDao cufEstTraitePendantDao;
    @Autowired
    private IDemandeOuProjetDao demandeOuProjetDao;

    
    
    
    @Override
    public StatistiqueBean afficherDMTraiteStats() {
        /*StatistiqueBean statRetour = new StatistiqueBean();
        
        Double listTypeAss = (Double) demandeOuProjetDao.findAllDemandeASS(DemandeOuProjetDao.ASS);
        statRetour.setTypeASS(listTypeAss);
        
        Double listTypeRe7 = (Double) demandeOuProjetDao.findAllDemandeASS(DemandeOuProjetDao.RE7);
        statRetour.setTypeASS(listTypeRe7);
        
        Double listTypePro = (Double) demandeOuProjetDao.findAllDemandeASS(DemandeOuProjetDao.PRO);
        statRetour.setTypeASS(listTypePro);*/
        
        return null;
		
    }
					
    
}
