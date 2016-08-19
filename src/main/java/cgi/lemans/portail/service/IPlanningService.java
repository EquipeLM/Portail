/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.controller.beans.PlanningCardBean;
import cgi.lemans.portail.controller.beans.PlanningModalBean;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface IPlanningService {
    
    public List<PlanningBean> afficherPlanningEquipe(String tag);
    
    public PlanningModalBean recupererInfosForfaitModal();
    
    public PlanningModalBean recupererInfosTypeModal();
    
    public PlanningCardBean enregistrerDemande(String idResource, PlanningCardBean bean);
    
    public PlanningCardBean enregistrerPlan (PlanningCardBean bean);
}
