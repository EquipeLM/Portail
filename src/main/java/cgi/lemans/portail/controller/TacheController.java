/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.controller.beans.TacheCardBean;
import cgi.lemans.portail.service.ITacheService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class TacheController extends ControllerPrincipal{
    
    @Autowired
    ITacheService tacheService;
    
        
        @RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosAllDemande(HttpServletRequest request, HttpSession session) {
            TacheBean infosSend = tacheService.recupererListDemande((String)session.getAttribute("user"));
            return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/equipe", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> infosEquipeTache(
			 HttpServletRequest request) {
		TacheBean infosSend = (TacheBean) tacheService.afficherTacheEquipe("CNP");
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	};
        
        
        // permet d'afficher demande dans modal
        @RequestMapping(value = "/tache/demande/libelle", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutDM(HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererDemandeModal("CNP");
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/typeActivite/libelle", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosTacheAjoutTypeOT(HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererInfosTypeOTModal();
		return new ResponseEntity<TacheBean>(infosSend, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ressource/tri", method = RequestMethod.GET)
	public ResponseEntity<TacheBean> getInfosQuiOT(HttpServletRequest request) {
		TacheBean infosSend = tacheService.recupererListQui("CNP");
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
	public ResponseEntity<TacheCardBean> ajouterConsoEnd(HttpSession session, @RequestBody TacheCardBean bean,
			HttpServletRequest request) {

			tacheService.enregistrerConsoEnd((String)session.getAttribute("user"), bean);
		
		
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ajout/consoJour", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterConsoJour(HttpSession session, @RequestBody TacheCardBean bean,
			HttpServletRequest request) {
		
			tacheService.enregistrerConsoJour((String)session.getAttribute("user"), bean);
		
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/tache/ajout/coms", method = RequestMethod.POST)
	public ResponseEntity<TacheCardBean> ajouterComs(@RequestBody TacheCardBean bean,
			HttpServletRequest request, HttpSession session) {
		
			tacheService.enregistrerComs(bean, (String)session.getAttribute("user"));
		
		return new ResponseEntity<TacheCardBean>(bean, HttpStatus.OK);
	}
        
        
        


    
}
