/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.service.IStatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author souchul
 */

@RestController
@RequestMapping(value = "/statistiques")
public class StatistiqueController extends ControllerPrincipal{
    
    @Autowired
    IStatistiqueService statistiqueService;
    
   
    
    /*@RequestMapping(value = "/statistique/demandeStats", method = RequestMethod.GET)
	
	public ResponseEntity<List<StatistiqueBean>> getInfosDmStat(HttpServletRequest request) {
		List<StatistiqueBean> listRetour = new ArrayList<StatistiqueBean>();
		StatistiqueBean infosSend = statistiqueService.afficherDMTraiteStats();
                listRetour.add(infosSend);
		return new ResponseEntity<List<StatistiqueBean>>(listRetour, HttpStatus.OK);
	}*/
    
}
