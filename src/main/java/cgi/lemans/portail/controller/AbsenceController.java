package cgi.lemans.portail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
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
	
	@RequestMapping(value="/")
	public ResponseEntity<AbsenceCardBean> getInfosAbsencesCard(){
		AbsenceCardBean infosSend = absenceService.recupererInfosAbsRessource();
		return new ResponseEntity<AbsenceCardBean>(infosSend, HttpStatus.OK);
	}
}
