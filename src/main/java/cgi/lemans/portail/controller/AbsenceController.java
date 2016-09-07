package cgi.lemans.portail.controller;

import cgi.lemans.portail.controller.beans.AbsenceBean;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.service.IAbsenceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gautierfa
 *
 */
@RestController
@RequestMapping(value = "/absences")
public class AbsenceController extends ControllerPrincipal{

	@Autowired
	IAbsenceService absenceService;
      
        
        
	@RequestMapping(value = "/absence/valueCard")
	public ResponseEntity<List<AbsenceCardBean>> getInfosAbsencesCard(HttpServletRequest request, HttpSession session) {
		
		List<AbsenceCardBean> listRetour = new ArrayList<AbsenceCardBean>();
		
			AbsenceCardBean infosSend = absenceService.recupererInfosAbsRessource((String)session.getAttribute("user"));

			listRetour.add(infosSend);

		
		return new ResponseEntity<List<AbsenceCardBean>>(listRetour, HttpStatus.OK);
	}

	@RequestMapping(value = "/equipe/mois/{mois}", method = RequestMethod.GET)
	public ResponseEntity<List<AbsenceBean>> infosEquipeAbsence(
			@PathVariable String mois, HttpServletRequest request) {
		List<AbsenceBean> infosSend = absenceService.afficherInfosEquipe("CNP", mois);
		return new ResponseEntity<List<AbsenceBean>>(infosSend, HttpStatus.OK);
	};

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<AbsenceBean> infosUserAbsence(HttpServletRequest request, HttpSession session) {
            
		AbsenceBean infosSend = absenceService.recupererAllAbsRessource((String) session.getAttribute("user"));
		return new ResponseEntity<AbsenceBean>(infosSend, HttpStatus.OK);
	};
        
        @RequestMapping(value = "/absence/jourFerie", method = RequestMethod.GET)
	public ResponseEntity<AbsenceBean> infosUseAbsenceJourFerie(HttpServletRequest request) {
		AbsenceBean infosSend = absenceService.recupererJourFerie();
		return new ResponseEntity<AbsenceBean>(infosSend, HttpStatus.OK);
	};

	@RequestMapping(value = "/absence/addAbsence", method = RequestMethod.POST)
	public ResponseEntity<AbsenceCardBean> ajouterAbsence(HttpSession session, @RequestBody AbsenceCardBean bean,
			HttpServletRequest request) {
		absenceService.enregistrerInfosParTypes((String) session.getAttribute("user"), bean);
		
		return new ResponseEntity<AbsenceCardBean>(bean, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/absence/AddSolde", method = RequestMethod.POST)
	public ResponseEntity<AbsenceCardBean> ajouterSolde(HttpSession session, @RequestBody AbsenceCardBean bean,
			HttpServletRequest request) {
		
		
		absenceService.enregistrerSoldeParTypes((String) session.getAttribute("user"), bean);
		
		// FIXME: Le code retourné est toujours OK mais ça ne veut pas dire que
		// c'est vrai tq les exceptions ne sont pas gérées.
		return new ResponseEntity<AbsenceCardBean>(bean, HttpStatus.OK);
	}
}
