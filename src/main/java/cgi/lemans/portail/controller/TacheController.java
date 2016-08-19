/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.controller.beans.TacheCardBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.ITacheService;
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
        
        @RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosAllDemande(HttpServletRequest request) {
            UtilisateurBean user = addUtilisateurSession(request.getSession());
           
		TacheBean infosSend = tacheService.recupererListDemande(user.getTrigramme());
           
               
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/equipe/{tag}", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> infosEquipeTache(@PathVariable String tag,
			 HttpServletRequest request) {
		TacheBean infosSend = (TacheBean) tacheService.afficherTacheEquipe(tag);
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	};
        
        
        // permet d'afficher demande dans modal
        @RequestMapping(value = "/tache/demande/libelle/{tag}", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutDM(@PathVariable String tag, HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererDemandeModal(tag);
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/typeActivite/libelle", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutTypeOT(HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererInfosTypeOTModal();
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ressource/tri/{tag}", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosQuiOT(@PathVariable String tag, HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererListQui(tag);
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/afficher/coms", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosComs(HttpServletRequest request) {
		TacheBean infosSend = tacheService.afficherComs();
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        
        @RequestMapping(value = "/tache/ajout/tache", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterTache(@RequestBody TacheCardBean bean,
			HttpServletRequest request) {
				
			tacheService.enregistrerNewTache(bean);
		
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ajout/consoEnd", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterConsoEnd(@RequestBody TacheCardBean bean,
			HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			tacheService.enregistrerConsoEnd(user.getTrigramme(), bean);
		} else {
			// TODO: Equipe implémentation des erreurs
		}
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ajout/consoJour", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterConsoJour(@RequestBody TacheCardBean bean,
			HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			tacheService.enregistrerConsoJour(user.getTrigramme(), bean);
		} else {
			// TODO: Equipe implémentation des erreurs
		}
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ajout/coms", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterComs(@RequestBody TacheCardBean bean,
			HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			tacheService.enregistrerComs(bean, user.getTrigramme());
		} else {
			// TODO: Equipe implémentation des erreurs
		}
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        
        


    
}
