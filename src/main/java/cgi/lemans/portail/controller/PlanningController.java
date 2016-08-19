/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.controller.beans.PlanningCardBean;
import cgi.lemans.portail.controller.beans.PlanningModalBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.IPlanningService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author souchul
 */

@RestController
@RequestMapping(value = "/plannings")
public class PlanningController {
    
    @Autowired
    IPlanningService planningService;
    
    /**
     * @param session
     * @return
     */
	public UtilisateurBean addUtilisateurSession(HttpSession session) {
		UtilisateurBean user = (UtilisateurBean) session.getAttribute("user");
		if (user == null) {
			user = new UtilisateurBean();
			session.setAttribute("user", user);
		}
		return user;
	}
        
        @RequestMapping(value = "/planning/equipe/{tag}", method = RequestMethod.GET)
	public ResponseEntity<List<PlanningBean>> infosEquipeAbsence(@PathVariable String tag,
		HttpServletRequest request) {
		List<PlanningBean> infosSend = planningService.afficherPlanningEquipe(tag);
		return new ResponseEntity<List<PlanningBean>>(infosSend, HttpStatus.OK);
	};
        
        @RequestMapping(value = "/planning/forfaitModal", method = RequestMethod.GET)
	public ResponseEntity<PlanningModalBean> infosModalForfait(HttpServletRequest request) {
		PlanningModalBean infosSend = planningService.recupererInfosForfaitModal();
		return new ResponseEntity<PlanningModalBean>(infosSend, HttpStatus.OK);
	};
        
        @RequestMapping(value = "/planning/typeDm", method = RequestMethod.GET)
	public ResponseEntity<PlanningModalBean> infosModalTypeDM(HttpServletRequest request) {
		PlanningModalBean infosSend = planningService.recupererInfosTypeModal();
		return new ResponseEntity<PlanningModalBean>(infosSend, HttpStatus.OK);
	};
        
        @RequestMapping(value = "/planning/ajoutPlan", method = RequestMethod.POST)
	public ResponseEntity<PlanningCardBean> ajouterPlan(@RequestBody PlanningCardBean bean,
			HttpServletRequest request) {
		
			planningService.enregistrerPlan(bean);
		
		return new ResponseEntity<PlanningCardBean>(bean, HttpStatus.OK);
	}
        
        /*@RequestMapping(value = "/planning/ajoutDm", method = RequestMethod.POST)
	public ResponseEntity<PlanningCardBean> ajouterAbsence(@RequestBody PlanningCardBean bean,
			HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			absenceService.enregistrerInfosParTypes(user.getTrigramme(), bean);
		} else {
			// TODO: Equipe implémentation des erreurs
		}
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<AbsenceCardBean>(bean, HttpStatus.OK);
	}*/
}
