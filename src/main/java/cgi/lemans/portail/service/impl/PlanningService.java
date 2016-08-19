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
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeDemande;
import cgi.lemans.portail.domaine.gamaweb.ICufPlanningDao;
import cgi.lemans.portail.domaine.gamaweb.IForfaitBudgetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.domaine.gamaweb.ITypeDemandeDao;
import cgi.lemans.portail.service.IPlanningService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class PlanningService implements IPlanningService{
    
        @Autowired
	private ICufPlanningDao cufPlanningDao;
        @Autowired
	private IOrdreDeTravailDao ordreDeTravailDao;
        @Autowired
        private IForfaitBudgetDao forfaitBudgetDao;
        @Autowired
        private ITypeDemandeDao typeDemandeDao;
        

	
private ListPlanningBean planningEquipe (CufPlanning cufPlanning){
        
        
        ListPlanningBean plan = new ListPlanningBean();          
        
        if((cufPlanning.getIdResource() != null) && (cufPlanning.getChargePlanning() != null) && (cufPlanning.getIdOT() != null) ){
		
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
            
        }
        
            
	    return plan;
            
    }
        
        
    @Override
    public List<PlanningBean> afficherPlanningEquipe(String tag) {
        
         Map<Integer, PlanningBean> absByDm = new HashMap<Integer, PlanningBean>();
        List<CufPlanning> listplan = cufPlanningDao.findListDemandePlanning(tag);
		
		for (CufPlanning cufPlanning : listplan) {
                        ListPlanningBean plan = planningEquipe(cufPlanning);
                        if(cufPlanning.getIdOT() != null){
                        final Integer idOt = cufPlanning.getIdOT().getIdOt();
                        
                        if (!absByDm.keySet().contains(idOt)) {
                            PlanningBean planRetour = new PlanningBean();
                            planRetour.setIdOt(idOt);
                            planRetour.setLibelleOT(cufPlanning.getIdOT().getLibelOT());
                            planRetour.setPrevue(cufPlanning.getIdOT().getChargePrevue().toString());
                            planRetour.setRaf(cufPlanning.getIdOT().getChargeRestante().toString());
                            planRetour.setConsomme(cufPlanning.getIdOT().getChargeConsommeeTotale().toString());
                            planRetour.setTypeOT(cufPlanning.getIdOT().getTypeActivite());
                           
                           planRetour.setTrigrammeOT(cufPlanning.getIdResource());
                            planRetour.setListPlanning(new ArrayList<ListPlanningBean>());
                            absByDm.put(idOt, planRetour);   
                        }
                        absByDm.get(idOt).getListPlanning().add(plan);
                }}
		

		return new ArrayList<>(absByDm.values());
             
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

    @Override
    public PlanningCardBean enregistrerPlan(PlanningCardBean bean) {
        CufPlanning plan = new CufPlanning();
        
    
        
        OrdreDeTravail ot = new OrdreDeTravail();
        ot.setIdOt(bean.getIdOtPlan());
        plan.setIdOT(ot);
        
        plan.setIdResource(bean.getIdRessource());
        plan.setNoSem(bean.getNoSem());
        plan.setChargePlanning(bean.getCharge());
        plan.setDateModif(new Date());
        plan.setUserModif("annie");
        plan.setEquipePlanning("CNP");
        cufPlanningDao.create(plan);
        return bean;
    }
    
    
    
    
    
    
   
    
}
