package cgi.lemans.portail.controller;

import java.util.ArrayList;
import java.util.List;

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

import cgi.lemans.portail.controller.beans.AbsenceBean;
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
		if (user == null) {
			user = new UtilisateurBean();
			session.setAttribute("user", user);
		}
		return user;
	}

	@RequestMapping(value = "")
	public ResponseEntity<List<AbsenceCardBean>> getInfosAbsencesCard(HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		List<AbsenceCardBean> listRetour = new ArrayList<AbsenceCardBean>();
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			AbsenceCardBean infosSend = absenceService.recupererInfosAbsRessource(user.getTrigramme());

			listRetour.add(infosSend);

		} else {
			// TODO: Equipe implémentation des erreurs
		}
		return new ResponseEntity<List<AbsenceCardBean>>(listRetour, HttpStatus.OK);
	}

	@RequestMapping(value = "/equipe/{nomEquipe}/mois/{mois}", method = RequestMethod.GET)
	public ResponseEntity<List<AbsenceBean>> infosEquipeAbsence(@PathVariable String nomEquipe,
			@PathVariable String mois, HttpServletRequest request) {
		List<AbsenceBean> infosSend = absenceService.afficherInfosEquipe(nomEquipe, mois);
		return new ResponseEntity<List<AbsenceBean>>(infosSend, HttpStatus.OK);
	};

	@RequestMapping(value = "/{idRessource}", method = RequestMethod.GET)
	public ResponseEntity<AbsenceBean> infosUserAbsence(@PathVariable String idRessource, HttpServletRequest request) {
		AbsenceBean infosSend = absenceService.recupererAllAbsRessource(idRessource);
		return new ResponseEntity<AbsenceBean>(infosSend, HttpStatus.OK);
	};

	@RequestMapping(value = "/absence", method = RequestMethod.POST)
	public ResponseEntity<AbsenceCardBean> ajouterAbsence(@RequestBody AbsenceCardBean bean,
			HttpServletRequest request) {
		UtilisateurBean user = addUtilisateurSession(request.getSession());
		if (user != null && UtilisateurBean.USER_TRI.equals(user.getTrigramme())) {
			absenceService.enregistrerInfosParTypes(user.getTrigramme(), bean);
		} else {
			// TODO: Equipe implémentation des erreurs
		}
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<AbsenceCardBean>(bean, HttpStatus.OK);
	}
}
