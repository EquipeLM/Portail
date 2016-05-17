/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.ITacheService;
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
@RequestMapping(value = "/taches")
public class TacheController {
    
    @Autowired
    ITacheService tacheService;
    
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
        
        @RequestMapping(value = "/tache", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosAllDemande(HttpServletRequest request) {
            UtilisateurBean user = addUtilisateurSession(request.getSession());
           
		TacheBean infosSend = tacheService.recupererListDemande(user.getTrigramme());
           
               
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/{tag}", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutDM(@PathVariable String tag, HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererDemandeModal(tag);
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutTypeOT(HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererInfosTypeOTModal();
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        


    
}
