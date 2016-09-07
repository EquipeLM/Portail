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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.controller.beans.AbsenceBean;
import cgi.lemans.portail.controller.beans.EventAbsenceBean;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.JourFerieMobile;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeAbsence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.IJourFerieMobileDao;
import cgi.lemans.portail.domaine.gamaweb.impl.AbsenceDao;
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
        @Autowired
	private IJourFerieMobileDao jourFerieMobileDao;

	@Override
	public AbsenceCardBean recupererInfosAbsRessource(String idRessource) {
		AbsenceCardBean absRetour = new AbsenceCardBean();
		Double listCongesPris = (Double) absenceDao.findAbsenceByTypeByRessource(idRessource,
				AbsenceDao.CONGES);
		absRetour.setCongesConsomme(listCongesPris == null ? "0.0" : listCongesPris.toString());

		Double listQ1Pris = (Double) absenceDao.findAbsenceByTypeByRessource(idRessource, AbsenceDao.RTT_Q1);
		absRetour.setRttQunConsomme(listQ1Pris == null ? "0.0" : listQ1Pris.toString());

		Double listQ2Pris = (Double) absenceDao.findAbsenceByTypeByRessource(idRessource, AbsenceDao.RTT_Q2);
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

		Absence nvelleAbsConge = new Absence();
		// CufRessourceAbsence nvSolde = new CufRessourceAbsence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();

		// nvSolde.setSolde(Double.parseDouble(bean.getSoldeConges()));
		// cufRessourceAbsenceDao.create(nvSolde);

		ress.setIdRessource(idRessource);
		Double nbJours = 0.0;

		Calendar cal = new GregorianCalendar();
		cal.setTime(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date dateDebut = cal.getTime();

		cal.setTime(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
		cal.add(Calendar.DAY_OF_YEAR, 2);
		Date dateFin = cal.getTime();

		nvelleAbsConge.setRefRessource(ress);

		if (Boolean.parseBoolean(bean.getIsPoseSurPeriode()) == false) {
			nvelleAbsConge.setRefRessource(ress);
			if (("choixConge").equals(bean.getIdTypeAbsence())) {
				type.setIdTypeAbsence(1);
			} else if (("choixRtt1").equals(bean.getIdTypeAbsence())) {
				type.setIdTypeAbsence(2);
			} else {
				type.setIdTypeAbsence(3);
			}
			nvelleAbsConge.setRefTypeAbsence(type);
			nvelleAbsConge.setCommentaireAbsence("");
			if ("am".equals(bean.getTypeJourneeDebut())) {
				nvelleAbsConge.setCommentaireAbsence("AM");
				nbJours = 0.5;
			} else if ("pm".equals(bean.getTypeJourneeDebut())) {
				nbJours = 0.5;
				nvelleAbsConge.setCommentaireAbsence("PM");
			} else {
				nbJours = 1.0;
			}
			nvelleAbsConge.setNombreJourAbsence(nbJours);

			nvelleAbsConge.setPremierJourAbsence(dateDebut);
			nvelleAbsConge.setDateFinAbsence(dateDebut);

			absenceDao.create(nvelleAbsConge);
		} else {

			Date d1 = ConvertUtils.parseToDate(bean.getDateProchainConges(), "US");
			Date d2 = ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US");
			long diff = ((d2.getTime() - d1.getTime()) / 86400000) + 1;

			nvelleAbsConge.setNombreJourAbsence(diff);
			nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
			nvelleAbsConge.setDateFinAbsence(dateFin);
			nvelleAbsConge.setCommentaireAbsence("");
			if (("choixConge").equals(bean.getIdTypeAbsence())) {
				type.setIdTypeAbsence(1);
				nvelleAbsConge.setRefTypeAbsence(type);
			} else if (("choixRtt1").equals(bean.getIdTypeAbsence())) {
				type.setIdTypeAbsence(2);
				nvelleAbsConge.setRefTypeAbsence(type);
			} else {
				type.setIdTypeAbsence(3);
				nvelleAbsConge.setRefTypeAbsence(type);
			}

			absenceDao.create(nvelleAbsConge);

		}
		return bean;
	}

	@Override
	public List<AbsenceBean> afficherInfosEquipe(String equipeChoisie, String moisAafficher) {
		Map<String, AbsenceBean> absBytrigramme = new HashMap<String, AbsenceBean>();
		List<Absence> listNomEquipe = absenceDao.findAbsenceByEquipe(equipeChoisie, moisAafficher);

		for (Absence absence : listNomEquipe) {
			EventAbsenceBean event = creerEventAbsence(absence);
			final RessourceTma refRessource = absence.getRefRessource();
			final String idRessource = refRessource.getIdRessource();

			if (!absBytrigramme.keySet().contains(idRessource)) {
				AbsenceBean absRetour = new AbsenceBean();
				absRetour.setNom(refRessource.getNom());
				absRetour.setPrenom(refRessource.getPrenom());
				absRetour.setTrigramme(idRessource);
				absRetour.setListEvent(new ArrayList<EventAbsenceBean>());
				absBytrigramme.put(idRessource, absRetour);

			}
			absBytrigramme.get(idRessource).getListEvent().add(event);
		}
		return new ArrayList<>(absBytrigramme.values());
	}

	/**
	 * @param absence
	 * @return
	 */
	private EventAbsenceBean creerEventAbsence(Absence absence) {
		EventAbsenceBean event = new EventAbsenceBean();
		Calendar cal = Calendar.getInstance();
		if (absence.getPremierJourAbsence() != null) {
			cal.setTime(absence.getPremierJourAbsence());
			event.setNumMoisDebut(ConvertUtils.toString(cal.get(Calendar.MONTH)));
			event.setAnnee(ConvertUtils.toString(cal.get(Calendar.YEAR)));
		}
		if (absence.getDateFinAbsence() != null) {
			cal.setTime(absence.getDateFinAbsence());
			event.setNumMoisFin(ConvertUtils.toString(cal.get(Calendar.MONTH)));
			event.setAnnee(ConvertUtils.toString(cal.get(Calendar.YEAR)));
		}
		event.setDateDebut(ConvertUtils.formatterDateUS(absence.getPremierJourAbsence()));
               
                Calendar caln = new GregorianCalendar();
                caln.setTime(ConvertUtils.parseToDate(absence.getDateFinAbsence().toString(), "US"));
		caln.add(Calendar.DAY_OF_YEAR, 2);
		Date fin = cal.getTime();

		event.setDateFin(ConvertUtils.formatterDateUS(fin));
		event.setId(absence.getIdAbsence());
		event.setText(absence.getCommentaireAbsence());
                
                if(new Integer(1).equals(absence.getRefTypeAbsence().getIdTypeAbsence())){
                    event.setCouleur("rgba(127, 161, 183, 0.5)");
                } else if (new Integer(2).equals(absence.getRefTypeAbsence().getIdTypeAbsence())){
                    event.setCouleur("rgba(135, 193, 221, 0.5)");
                } else {
                    event.setCouleur("rgba(154, 230, 241, 0.5)");
                }
                
		return event;
	}

	@Override
	public AbsenceBean recupererAllAbsRessource(String idRessource) {
		List<Absence> listAbsence = absenceDao.findAbsenceByUser(idRessource);
                
		AbsenceBean absRetour = new AbsenceBean();
		List<EventAbsenceBean> absResources = new ArrayList<EventAbsenceBean>();
		for (Absence absence : listAbsence) {
			absResources.add(creerEventAbsence(absence));      
                        
                }
                absRetour.setListEvent(absResources);
                
                
                
                
		return absRetour;

	}
        
    

    @Override
    public AbsenceCardBean enregistrerSoldeParTypes(String idRessource, AbsenceCardBean bean) {
        
                        
                CufRessourceAbsence newSolde = new CufRessourceAbsence();
                CufRessourceAbsence newSolde2 = new CufRessourceAbsence();
                CufRessourceAbsence newSolde3 = new CufRessourceAbsence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();
                TypeAbsence type2 = new TypeAbsence();
                TypeAbsence type3 = new TypeAbsence();
                Calendar cal = Calendar.getInstance();
                ress.setIdRessource(idRessource);
                newSolde.setTypeAbsence(type);
                newSolde2.setTypeAbsence(type2);
                newSolde3.setTypeAbsence(type3);
                

                
                newSolde.setSolde(ConvertUtils.parseDouble(bean.getSoldeConges()));
                type.setIdTypeAbsence(1);
                newSolde.setAnnee(2016);
                newSolde.setRessourceTma(ress); 
                
                newSolde2.setSolde(ConvertUtils.parseDouble(bean.getSoldesQun()));
                type2.setIdTypeAbsence(2);
                newSolde2.setAnnee(2016);
                newSolde2.setRessourceTma(ress); 
                
                newSolde3.setSolde(ConvertUtils.parseDouble(bean.getSoldesQdeux()));
                type3.setIdTypeAbsence(3);
                newSolde3.setAnnee(2016);
                newSolde3.setRessourceTma(ress); 
                
                cufRessourceAbsenceDao.create(newSolde);
                cufRessourceAbsenceDao.create(newSolde2);
                cufRessourceAbsenceDao.create(newSolde3);
                              
                
                return bean;
    }
    
    private EventAbsenceBean creerEventAbsenceJourFerie(JourFerieMobile jourFerieMobile) {
		EventAbsenceBean event = new EventAbsenceBean();
		Calendar cal = Calendar.getInstance();
		
		event.setDateDebut(ConvertUtils.formatterDateUS(jourFerieMobile.getDateJourFerieMobile()));
		event.setDateFin(ConvertUtils.formatterDateUS(jourFerieMobile.getDateJourFerieMobile()));
		event.setId(jourFerieMobile.getIdJourFerieMobile());
		event.setText(jourFerieMobile.getLibelleJourFerieMobile());
                event.setCouleur("rgba(131, 131, 131, 0.5)");
                
                
		return event;
	}

    @Override
    public AbsenceBean recupererJourFerie() {
        List<JourFerieMobile> listJourFerie = jourFerieMobileDao.findJourFerie();
                
		AbsenceBean absRetour = new AbsenceBean();
		List<EventAbsenceBean> absResources = new ArrayList<EventAbsenceBean>();
		for (JourFerieMobile jourFerieMobile : listJourFerie) {
			absResources.add(creerEventAbsenceJourFerie(jourFerieMobile));      
                        
                }
                absRetour.setListEvent(absResources);
              
		return absRetour;
    }

}
