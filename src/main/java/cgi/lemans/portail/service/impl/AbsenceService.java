/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.controller.beans.UtilisateurBean;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeAbsence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.impl.CufAbsenceDao;
import cgi.lemans.portail.service.IAbsenceService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author souchul
 */
@Service
@Transactional(transactionManager = "txManagerGamaweb")
public class AbsenceService implements IAbsenceService {

	@Autowired
	private ICufAbsenceDao cufAbsenceDao;
	@Autowired
	private ICufRessourceAbsenceDao cufRessourceAbsenceDao;
	@Autowired
	private IAbsenceDao absenceDao;

	@Override
	public AbsenceCardBean recupererInfosAbsRessource(String idRessource) {
		AbsenceCardBean absRetour = new AbsenceCardBean();
		Double listCongesPris = (Double) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource,
				CufAbsenceDao.CONGES);
		absRetour.setCongesConsomme(listCongesPris == null ? "0.0" : listCongesPris.toString());
		
		Double listQ1Pris = (Double) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource,
				CufAbsenceDao.RTT_Q1);
		absRetour.setRttQunConsomme(listQ1Pris == null ? "0.0" :  listQ1Pris.toString());
		
		Double listQ2Pris = (Double) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource,
				CufAbsenceDao.RTT_Q2);
		absRetour.setRttQdeuxConsomme(listQ2Pris == null ? "0.0" : listQ2Pris.toString());
		
		CufRessourceAbsence listCongesSolde = (CufRessourceAbsence) cufRessourceAbsenceDao
				.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.CONGES);
		absRetour.setSoldeConges(listCongesSolde == null ? "0.0" : listCongesSolde.getSolde().toString());
		
		
		CufRessourceAbsence listQ1Solde = (CufRessourceAbsence) cufRessourceAbsenceDao
				.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q1);
		absRetour.setSoldesQun(listQ1Solde == null ? "0.0" : listQ1Solde.getSolde().toString());
		
		CufRessourceAbsence listQ2Solde = (CufRessourceAbsence) cufRessourceAbsenceDao
				.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q2);
		absRetour.setSoldesQdeux(listQ2Solde == null ? "0.0" : listQ2Solde.getSolde().toString());
		
		Absence dateProchainConge = (Absence) absenceDao.findAbsenceByPremierJourAbsence(idRessource);
		Date premierJourAbsence = dateProchainConge.getPremierJourAbsence();
		SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yyyy");
		if(premierJourAbsence != null){
			absRetour.setDateProchainConges(format.format(premierJourAbsence));
		}
		Double nombreJourAbsence = dateProchainConge.getNombreJourAbsence();
		if(nombreJourAbsence != null){
			absRetour.setDureeProchainConges(nombreJourAbsence.toString());
		}
		return absRetour;
	}

	@Override
	public void enregistrerInfosParTypes(AbsenceCardBean bean) {
		CufRessourceAbsence newSoldeConge = new CufRessourceAbsence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();
		type.setIdTypeAbsence(Integer.parseInt(bean.getIdTypeAbsence()));
		ress.setIdRessource(UtilisateurBean.USER_TRI);
		newSoldeConge.setAnnee(Calendar.YEAR);
		newSoldeConge.setSolde(Double.parseDouble(bean.getSoldeConges()));
		cufRessourceAbsenceDao.create(newSoldeConge);


		Absence nvelleAbsConge = new Absence();
		type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.CONGES));
		ress.setIdRessource("BJA");
		nvelleAbsConge.setPremierJourAbsence(null);
		nvelleAbsConge.setDateFinAbsence(null);
		nvelleAbsConge.setNombreJourAbsence(0);
		absenceDao.create(nvelleAbsConge);

		// update absence

	}

}
