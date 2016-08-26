/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.IncoherenceBean;
import cgi.lemans.portail.service.IIncoherenceService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author souchul
 */

@RestController
@RequestMapping(value = "/incoherences")
public class IncoherenceController {
    
    @Autowired
    IIncoherenceService incoherenceService;
    
     
       
    
    @RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<IncoherenceBean> nbIncoherence(HttpServletRequest request) {
            
		IncoherenceBean infosSend = incoherenceService.afficherNbIncoherence("");
		return new ResponseEntity<IncoherenceBean>(infosSend, HttpStatus.OK);
	};
        
        
        
       
        
        
        /*@RequestMapping(value = "/incoherence/connect", method = RequestMethod.POST)

	public ResponseEntity<LoginWebBean> Connect(HttpServletRequest request, LoginWebBean bean, RessourceTma ressource, HttpSession session) {
            
		LoginBean infosSend = incoherenceService.connect();
                if((bean.getTrigramme()).equals(infosSend.getListLogin())){
                            session.setAttribute("user", bean.getTrigramme());
                            
                            System.out.print("ok");
                        }else{
                            System.out.println("erreur");
                        }
                
		return new ResponseEntity<LoginWebBean>(bean, HttpStatus.OK);
	};*/
        
         
    
}
