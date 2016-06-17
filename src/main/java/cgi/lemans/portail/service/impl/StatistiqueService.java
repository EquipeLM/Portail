/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.ListStatistiqueBean;
import cgi.lemans.portail.controller.beans.StatistiqueBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufEstTraitePendant;
import cgi.lemans.portail.domaine.gamaweb.ICufEstTraitePendantDao;
import cgi.lemans.portail.service.IStatistiqueService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    
    private ListStatistiqueBean statsDm(CufEstTraitePendant cufEstTraitePendant) {
		ListStatistiqueBean stats = new ListStatistiqueBean();
                stats.setDate(cufEstTraitePendant.getDateImputation().toString());
                stats.setTypeActivite(cufEstTraitePendant.getIdOT().getTypeActivite());
                
                return stats;
        }
    
    @Override
    public List<StatistiqueBean> afficherDMTraiteStats(String idRessource) {
        Map<Date, StatistiqueBean> absByDate = new HashMap<Date, StatistiqueBean>();
        List<CufEstTraitePendant> liststats = cufEstTraitePendantDao.findAllDemandeTraiteStats(idRessource);
		//
		//List<ListStatistiqueBean> absResources = new ArrayList<ListStatistiqueBean>();
		for (CufEstTraitePendant cufEstTraitePendant : liststats) {
                        ListStatistiqueBean listStats = statsDm(cufEstTraitePendant);
                        final Date dateImputation = cufEstTraitePendant.getDateImputation();
                        
                        if (!absByDate.keySet().contains(dateImputation)) {
                            StatistiqueBean statsRetour = new StatistiqueBean();
                            statsRetour.setDate(dateImputation.toString());
                            statsRetour.setListStats(new ArrayList<ListStatistiqueBean>());
                            absByDate.put(dateImputation, statsRetour);   
                        }
                        absByDate.get(dateImputation).getListStats().add(listStats);
                }
		

		return new ArrayList<>(absByDate.values());
    }
					
    
}
