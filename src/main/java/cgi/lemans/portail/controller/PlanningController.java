/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.PlanningBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.IPlanningService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
}
