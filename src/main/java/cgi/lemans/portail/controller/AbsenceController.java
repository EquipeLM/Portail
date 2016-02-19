package cgi.lemans.portail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.service.IAbsenceService;

/**
 * @author gautierfa
 *
 */
@RestController
@RequestMapping(value = "/absences")
public class AbsenceController {
	
	@Autowired
	IAbsenceService absenceService;
	
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
	public ResponseEntity<List<AbsenceCardBean>> getInfosAbsencesCard(HttpServletRequest request){
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		List<AbsenceCardBean> listRetour = new ArrayList<AbsenceCardBean>();
		if(user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())){
			AbsenceCardBean infosSend = absenceService.recupererInfosAbsRessource(user.getTrigramme());
			listRetour.add(infosSend);
		}else {
			//TODO: Equipe implémentation des erreurs
		}
		return new ResponseEntity<List<AbsenceCardBean>>(listRetour, HttpStatus.OK);
	}
}
