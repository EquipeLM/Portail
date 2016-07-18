/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.ListPlanningBean;
import cgi.lemans.portail.controller.beans.ListPlanningModalBean;
import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.controller.beans.PlanningCardBean;
import cgi.lemans.portail.controller.beans.PlanningModalBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufPlanning;
import cgi.lemans.portail.domaine.entites.gamaweb.ForfaitBudget;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeDemande;
import cgi.lemans.portail.domaine.gamaweb.ICufPlanningDao;
import cgi.lemans.portail.domaine.gamaweb.IForfaitBudgetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.domaine.gamaweb.ITypeDemandeDao;
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
        @Autowired
	private IOrdreDeTravailDao ordreDeTravailDao;
        @Autowired
        private IForfaitBudgetDao forfaitBudgetDao;
        @Autowired
        private ITypeDemandeDao typeDemandeDao;
        

	

    @Override
    public List<PlanningBean> afficherPlanningEquipe(String tag) {
        
         Map<String, PlanningBean> absByDm = new HashMap<String, PlanningBean>();
        List<CufPlanning> listplan = cufPlanningDao.findListDemandePlanning(tag);
		
		for (CufPlanning cufPlanning : listplan) {
                        ListPlanningBean plan = planningEquipe(cufPlanning);
                        final String idDemande = cufPlanning.getIdOT().getIdDemande().getIdDemande();
                        
                        if (!absByDm.keySet().contains(idDemande)) {
                            PlanningBean planRetour = new PlanningBean();
                            planRetour.setIdDm(idDemande);
                            planRetour.setLibelleDM(cufPlanning.getIdOT().getIdDemande().getLibelle());
                            planRetour.setListPlanning(new ArrayList<ListPlanningBean>());
                            absByDm.put(idDemande, planRetour);   
                        }
                        absByDm.get(idDemande).getListPlanning().add(plan);
                }
		

		return new ArrayList<>(absByDm.values());
                
                              
               
   }
    
    
    private ListPlanningBean planningEquipe (CufPlanning cufPlanning){
        
        
        ListPlanningBean plan = new ListPlanningBean();
        
        if (cufPlanning.getIdOT().getIdOt() != null) {
		
            plan.setId(cufPlanning.getIdPlanning());
            String sem = (cufPlanning.getNoSem().toString());
            String nSem = sem.substring(4, 6);
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd ");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(nSem));        
            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            
            
            
            plan.setSemaine(date.format(cal.getTime()));
            plan.setIdOt(cufPlanning.getIdOT().getIdOt());
            
            plan.setPlanifie(cufPlanning.getChargePlanning());
            plan.setTrigramme(cufPlanning.getIdResource());
        }
                
	    return plan;
            
    }
    
    
    private ListPlanningModalBean forfaitDm(ForfaitBudget forfaitBudget) {
		ListPlanningModalBean plan = new ListPlanningModalBean();

		plan.setIdforfait(forfaitBudget.getIdForfaitBudget());
                plan.setRefForfait(forfaitBudget.getRefSousSysteme());
                plan.setLibelleForfait(forfaitBudget.getLibelleForfaitBudget());

		return plan;
	}
  

    @Override
    public PlanningModalBean recupererInfosForfaitModal() {
        List<ForfaitBudget> listforfait = forfaitBudgetDao.findForfaitModalDm();
		PlanningModalBean planRetour = new PlanningModalBean();
		List<ListPlanningModalBean> absResources = new ArrayList<ListPlanningModalBean>();
		for (ForfaitBudget forfaitBudget : listforfait) {
			absResources.add(forfaitDm(forfaitBudget));

		}
		planRetour.setListPlanModal(absResources);

		return planRetour;
    }
    
    private ListPlanningModalBean TypeDm(TypeDemande typeDemande) {
		ListPlanningModalBean plan = new ListPlanningModalBean();

		plan.setIdTypeDm(typeDemande.getTypeDem());
                plan.setLibelleDm(typeDemande.getLibelle());

		return plan;
	}
  

    @Override
    public PlanningModalBean recupererInfosTypeModal() {
        List<TypeDemande> listforfait = typeDemandeDao.findForfaitModalDm();
		PlanningModalBean planRetour = new PlanningModalBean();
		List<ListPlanningModalBean> absResources = new ArrayList<ListPlanningModalBean>();
		for (TypeDemande typeDemande : listforfait) {
			absResources.add(TypeDm(typeDemande));

		}
		planRetour.setListPlanModal(absResources);

		return planRetour;
    }

    @Override
    public PlanningCardBean enregistrerDemande(String idResource, PlanningCardBean bean) {
       return null;
    }
    
    
    
    
    
    
   
    
}
