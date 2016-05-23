/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.ListPlanningBean;
import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufPlanning;
import cgi.lemans.portail.domaine.gamaweb.ICufPlanningDao;
import cgi.lemans.portail.service.IPlanningService;
import java.util.ArrayList;
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
public class PlanningService implements IPlanningService{
    
        @Autowired
	private ICufPlanningDao cufPlanningDao;

	

    @Override
    
    public List<PlanningBean> afficherPlanningEquipe(String tag) {
       
       Map<Integer, PlanningBean> planByidOT = new HashMap<Integer, PlanningBean>();
               List<CufPlanning> listEquipePlanning = cufPlanningDao.findListDemandePlanning(tag);
      
                              for (CufPlanning cufPlanning : listEquipePlanning) {
                                             
                                              
                                              Integer idOT = cufPlanning.getIdOT();
                                                
                                             
                              }
                              return new ArrayList<>(planByidOT.values());
                              
               
   }
    /*public List<PlanningBean> afficherPlanningEquipe(String tag) {
        
        Map<Integer, PlanningBean> planByidOT = new HashMap<Integer, PlanningBean>();
	List<Object[]> listEquipePlanning = cufPlanningDao.findListDemandePlanning(tag);
       //String[] str = planByidOT.keySet().toArray(new String[planByidOT.size()]);
		for (Object[] cufPlanning : listEquipePlanning) {
			ListPlanningBean plan = planningEquipe(cufPlanning);
			
			final Integer idOT = cufPlanning.getIdOT().getIdOt();

			if (!planByidOT.keySet().contains(idOT)) {
				PlanningBean planRetour = new PlanningBean();
				planRetour.setLibelleOT(cufPlanning.getIdOT().getLibelOT());
                                planRetour.setIdOt(idOT);
                                planRetour.setTrigramme(cufPlanning.getIdResource());
                                planRetour.setConsommé(cufPlanning.getIdOT().getChargeConsommeeTotale().toString());
                                planRetour.setPrevue(cufPlanning.getIdOT().getChargePrevue().toString());
                                planRetour.setRaf(cufPlanning.getIdOT().getChargeRestante().toString());

			}
			planByidOT.get(idOT).getListPlanning().add(plan);
		}
		return new ArrayList<>(planByidOT.values());
		
                
    }*/
    
    private ListPlanningBean planningEquipe (CufPlanning cufPlanning){
        
        ListPlanningBean event = new ListPlanningBean();
		
            event.setId(cufPlanning.getIdPlanning());
            event.setSemaine(cufPlanning.getNoSem());
            event.setIdOt(cufPlanning.getIdOT().getIdOt());
            event.setTrigramme(cufPlanning.getIdResource());
                
		return event;
    }
   
    
}
