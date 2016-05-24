/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.ListOTPlanningBean;
import cgi.lemans.portail.controller.beans.ListPlanningBean;
import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufPlanning;
import cgi.lemans.portail.domaine.gamaweb.ICufPlanningDao;
import cgi.lemans.portail.service.IPlanningService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        Map<String, PlanningBean> planByidDM = new HashMap<String, PlanningBean>();
        List<CufPlanning> listEquipePlanning = cufPlanningDao.findListDemandePlanning(tag);
      
            for (CufPlanning cufPlanning : listEquipePlanning) {
                ListOTPlanningBean plan = planningOTEquipe(tag);
                final String idDM = cufPlanning.getIdOT().getIdDemande().getIdDemande();
                if (!planByidDM.keySet().contains(idDM)) {
                    PlanningBean planRetour = new PlanningBean();
                   
                    planRetour.setIdDm(cufPlanning.getIdOT().getIdDemande().getIdDemande());
                    planRetour.setLibelleDM(cufPlanning.getIdOT().getIdDemande().getLibelle());
                    planRetour.setListOTPlanning(new ArrayList<ListOTPlanningBean>());
                    planByidDM.put(idDM, planRetour);
                    }
                planByidDM.get(idDM).getListOTPlanning().add(plan);
            }
                              
            return new ArrayList<>(planByidDM.values());
                              
               
   }
    
    private ListOTPlanningBean planningOTEquipe (String tag){
        
        //Map<Integer, ListOTPlanningBean> planByidOT = new HashMap<Integer, ListOTPlanningBean>();
        List<CufPlanning> listEquipePlanning = cufPlanningDao.findListDemandePlanning(tag);
      
        ListOTPlanningBean planOTRetour = new ListOTPlanningBean();
        List<ListPlanningBean> planRessources = new ArrayList<ListPlanningBean>();
        for (CufPlanning cufPlanning : listEquipePlanning) {
            
            ListPlanningBean plan = planningEquipe(cufPlanning);
            final Integer idOT = cufPlanning.getIdOT().getIdOt();
           
            planRessources.add(planningEquipe(cufPlanning));
            planOTRetour.setIdDM(cufPlanning.getIdOT().getIdDemande().getIdDemande());
            planOTRetour.setIdOt(idOT);
            planOTRetour.setLibelleOT(cufPlanning.getIdOT().getLibelOT());
            planOTRetour.setTypeOT(cufPlanning.getIdOT().getTypeActivite());
            planOTRetour.setConsomme(cufPlanning.getIdOT().getChargeConsommeeTotale().toString());
            planOTRetour.setRaf(cufPlanning.getIdOT().getChargeRestante().toString());
            planOTRetour.setPrevue(cufPlanning.getIdOT().getChargePrevue().toString());
            planOTRetour.setTrigrammeOT(cufPlanning.getIdResource());
          
            
            
            // planifié
  
        }
        planOTRetour.setListPlanning(planRessources);
		
	return planOTRetour;
        
    }
 	
    
    private ListPlanningBean planningEquipe (CufPlanning cufPlanning){
        
        ListPlanningBean plan = new ListPlanningBean();
		
            plan.setId(cufPlanning.getIdPlanning());
            String sem = (cufPlanning.getNoSem().toString());
            String nSem = sem.substring(4, 6);
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd ");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(nSem));        
            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            
            
            plan.setSem(nSem);
            plan.setSemaine(date.format(cal.getTime()));
            plan.setIdOt(cufPlanning.getIdOT().getIdOt());
            plan.setPlanifie(cufPlanning.getChargePlanning());
            //event.setTrigramme(cufPlanning.getIdResource());
                
		return plan;
    }
   
    
}
