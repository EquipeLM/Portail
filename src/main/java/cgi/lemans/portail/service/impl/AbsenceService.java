/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.controller.beans.AbsenceEquipeBean;
import cgi.lemans.portail.controller.beans.EventAbsenceEquipeBean;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeAbsence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.impl.CufAbsenceDao;
import cgi.lemans.portail.service.IAbsenceService;
import cgi.lemans.portail.utils.ConvertUtils;

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

		Double listQ1Pris = (Double) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q1);
		absRetour.setRttQunConsomme(listQ1Pris == null ? "0.0" : listQ1Pris.toString());

		Double listQ2Pris = (Double) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q2);
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
		if (dateProchainConge != null && dateProchainConge.getPremierJourAbsence() != null) {
			Date premierJourAbsence = dateProchainConge.getPremierJourAbsence();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			absRetour.setDateProchainConges(format.format(premierJourAbsence));
			Double nombreJourAbsence = dateProchainConge.getNombreJourAbsence();
			if (nombreJourAbsence != null) {
				absRetour.setDureeProchainConges(nombreJourAbsence.toString());
			}
		}

		return absRetour;
	}

	@Override
	public AbsenceCardBean enregistrerInfosParTypes(String idRessource, AbsenceCardBean bean) {
		
		
		CufRessourceAbsence newSoldeConge = new CufRessourceAbsence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();
	
//		type.setIdTypeAbsence(Integer.parseInt(bean.getIdTypeAbsence()));
//		ress.setIdRessource(UtilisateurBean.USER_TRI);
//		newSoldeConge.setAnnee(Calendar.YEAR);
//		newSoldeConge.setSolde(Double.parseDouble(bean.getSoldeConges()));
//		cufRessourceAbsenceDao.create(newSoldeConge);
		
		
		/*Algo pour enregistrer des absences
		 * 
		 * si isPosePeriode == false (absence sur journée ou demie-jnée) alors 
		 * -----si typeJourneeDeut != amPm créer absence avec 0.5j et ajouter AM ou PM dans le commentaire selon le typeJnée
		 * -----sinon créer absence avec nbJours à 1
		 *      
		 *      ex: 01/09/2016 avec 'matin' de choché => Absence de 0.5jours ayant pour commentaire AM
		 *     
		 *     
		 * sinon (on est sur une période)
		 * -----si typeJneeDebut == AM & typeJneeFin = PM (cas d'une période avec journées complète) calculer nbJours et créer absence
		 * 			ex: 01/07/2016 matin à 09/07/2016 à après midi => Absence de 9 jours
		 * 
		 * -----sinon si typeJneeDebut == AM & typeJneeFin = AM 
		 * 			creer absence de dateDebut à dateFin - 1jr (nbJours complets)
		 *          creer absence sur dateFin (0.5jr avec commenaire à AM)
		 *          
		 *          ex: 01/07/2016 matin à 09/07/2016 à matin
		 *              1 Absence de 8 jours (du 01/07 au 08/07)
		 *              1 Absence de 0.5jrs pour le 09/07 avec AM en commentaire
		 *              
		 * -----sinon si typejourneeDebut = PM & typeJneeFin = AM
		 * 			creer absence dateDebut (0.5J)
		 * 			creer absence de dateDebut +1jr à dateDeFin - 1jr (nbJours = 1 2 3)
		 *          creer absence sur dateFin (0.5jr avec commenaire à AM)
		 *          
		 *          ex: 01/07/2016 après-midi au 09/07/2016  matin
		 *              1 Absence de 0.5jrs pour le 01/07 avec PM en commentaire
		 *              1 Absence de 7jrs (du 02/07 au 08/07)
		 *              1 Absence de 0.5jrs pour le 09/07 avec AM en commentaire 
		 *              
		 * -----sinon si typejourneeDebut = PM & typeJneeFin = PM
		 *          creer absence dateDebut (0.5J)
		 * 			creer absence de dateDebut à dateFin (nbJours = 1 2 3)
		 * 			
		 * 			ex: 01/07/2016 après-midi à 09/07/2016 après-midi
		 *              1 Absence de 8 jours (du 02/07 au 09/07)
		 *              1 Absence de 0.5jrs pour le 01/07 avec PM en commentaire
		 * 
		 * 
		 * */
		 

		Absence nvelleAbsConge = new Absence();
		nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
		nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
		nvelleAbsConge.setNombreJourAbsence(Double.parseDouble(bean.getNombreJours()));
		nvelleAbsConge.setCommentaireAbsence(bean.getTypeJournee());
		absenceDao.create(nvelleAbsConge);

		return bean; // modifier
		// update absence

	}

	@Override
	public List<AbsenceEquipeBean> afficherInfosEquipe(String equipeChoisie, String moisAafficher) {
		Map<String, AbsenceEquipeBean> absBytrigramme = new HashMap<String, AbsenceEquipeBean>();
		List<Absence> listNomEquipe = absenceDao.findAbsenceByEquipe(equipeChoisie, moisAafficher);
		
		for (Absence absence : listNomEquipe) {
			EventAbsenceEquipeBean event = new EventAbsenceEquipeBean();
			Calendar cal = Calendar.getInstance();
			if(absence.getPremierJourAbsence() != null){
				cal.setTime(absence.getPremierJourAbsence());
				event.setNumMoisDebut(ConvertUtils.toString(cal.get(Calendar.MONTH)));
                event.setAnnee(ConvertUtils.toString(cal.get(Calendar.YEAR)));
			}
			if(absence.getDateFinAbsence() != null){
				cal.setTime(absence.getDateFinAbsence());
				event.setNumMoisFin(ConvertUtils.toString(cal.get(Calendar.MONTH)));
                event.setAnnee(ConvertUtils.toString(cal.get(Calendar.YEAR)));
			}
			event.setDateDebut(ConvertUtils.formatterDateUS(absence.getPremierJourAbsence()));
			event.setDateFin(ConvertUtils.formatterDateUS(absence.getDateFinAbsence()));
			event.setId(absence.getIdAbsence());
			event.setText(absence.getCommentaireAbsence());
			final RessourceTma refRessource = absence.getRefRessource();
			final String idRessource = refRessource.getIdRessource();
			
			if(!absBytrigramme.keySet().contains(idRessource)){
				AbsenceEquipeBean absRetour = new AbsenceEquipeBean();
				absRetour.setNom(refRessource.getNom());
				absRetour.setPrenom(refRessource.getPrenom());
				absRetour.setTrigramme(idRessource);
				absRetour.setListEvent(new ArrayList<EventAbsenceEquipeBean>());
				absBytrigramme.put(idRessource, absRetour);
				
			}
			absBytrigramme.get(idRessource).getListEvent().add(event);
		}
		return new ArrayList<>(absBytrigramme.values());
	}

}
