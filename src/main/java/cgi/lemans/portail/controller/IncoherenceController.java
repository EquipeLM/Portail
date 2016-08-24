/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.IncoherenceBean;
import cgi.lemans.portail.controller.beans.LoginBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.IIncoherenceService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    
    public UtilisateurBean addUtilisateurSession(HttpSession session) {
		UtilisateurBean user = (UtilisateurBean) session.getAttribute("user");
		if (user == null) {
			user = new UtilisateurBean();
			session.setAttribute("user",user);
		}
		return user;
	}
    /*@RequestMapping(value = "/incoherence/connect")
	public ResponseEntity<LoginWebBean> addConnect(@RequestBody LoginWebBean bean,
			HttpServletRequest request, HttpSession session) {
                        if(bean.getTrigramme() != null){
                            session.setAttribute("user", bean.getTrigramme());
                                                        
                        }
		return new ResponseEntity<LoginWebBean>(bean, HttpStatus.OK);
	}*/
    
   
    
    @RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<IncoherenceBean> nbIncoherence(HttpServletRequest request) {
            UtilisateurBean user = addUtilisateurSession(request.getSession());
		IncoherenceBean infosSend = incoherenceService.afficherNbIncoherence(user.getTrigramme());
		return new ResponseEntity<IncoherenceBean>(infosSend, HttpStatus.OK);
	};
        
        @RequestMapping(value = "/loginValue", method = RequestMethod.GET)
	public ResponseEntity<LoginBean> loginValue(HttpServletRequest request) {
            LoginBean infosSend = incoherenceService.connect();
	return new ResponseEntity<LoginBean>(infosSend, HttpStatus.OK);
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
