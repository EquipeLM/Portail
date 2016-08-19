package cgi.lemans.portail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgi.lemans.portail.controller.beans.ToolsCardBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.IToolsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gautierfa
 *
 */
@RestController
@RequestMapping(value = "/tools")
public class ToolsController {
	
	@Autowired
	IToolsService toolsService;
	/**
     * @param session
     * @return
     */
    public UtilisateurBean addUtilisateurSession(HttpSession session) {
    	UtilisateurBean user = (UtilisateurBean) session.getAttribute("user");
		if(user == null){
			user = new UtilisateurBean();
			session.setAttribute("user", user);
    	}
        return user;
    }
	
	
	
	@RequestMapping(value="")
	public ResponseEntity<ToolsCardBean> getIconePlusUtiliseByUser(HttpServletRequest request){
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		ToolsCardBean tools = toolsService.afficherLesIconesCardByUser(user.getTrigramme());
		return new ResponseEntity<ToolsCardBean>(tools, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{{id}}")
	public ResponseEntity<ToolsCardBean> ajoutClicIcone(HttpServletRequest request){
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		ToolsCardBean tools = toolsService.afficherLesIconesCardByUser(user.getTrigramme());
		return new ResponseEntity<ToolsCardBean>(tools, HttpStatus.OK);
		
	}
        
        
}
