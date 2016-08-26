/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.LoginBean;
import cgi.lemans.portail.controller.beans.LoginWebBean;
import cgi.lemans.portail.service.IIncoherenceService;
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
@RequestMapping(value = "/login")
public class ControllerPrincipal {
    
    @Autowired
    IIncoherenceService incoherenceService;
    
    
    @RequestMapping(value = "/loginValue", method = RequestMethod.GET)
	public ResponseEntity<LoginBean> loginValue(HttpServletRequest request) {
            LoginBean infosSend = incoherenceService.connect();
	return new ResponseEntity<LoginBean>(infosSend, HttpStatus.OK);
	};
        
     @RequestMapping(value = "/test", method = RequestMethod.GET)
        public ResponseEntity<LoginWebBean> testLogin(HttpServletRequest request, HttpSession session) {
          LoginWebBean log = new LoginWebBean();
          if(session.getAttribute("user") != null){
              log.setTrigramme((String) session.getAttribute("user"));
              return new ResponseEntity<LoginWebBean>(log, HttpStatus.OK);
          }else {
              return new ResponseEntity<LoginWebBean>(log, HttpStatus.OK);
          }
        }
        
        @RequestMapping(value = "/infosConnexion")
	public ResponseEntity<LoginWebBean> infosConnect(@RequestBody LoginWebBean bean,
			HttpServletRequest request, HttpSession session) {
		session.setAttribute("user", bean.getTrigramme());
		
		return new ResponseEntity<LoginWebBean>(bean, HttpStatus.OK);
	}
        
    
    
}
