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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		
		
		Absence nvelleAbsConge = new Absence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();
	
                  
//		type.setIdTypeAbsence(Integer.parseInt(bean.getIdTypeAbsence()));
//		ress.setIdRessource(UtilisateurBean.USER_TRI);
//		newSoldeConge.setAnnee(Calendar.YEAR);
//		newSoldeConge.setSolde(Double.parseDouble(bean.getSoldeConges()));
//		cufRessourceAbsenceDao.create(newSoldeConge);
		

                if ( Boolean.parseBoolean(bean.getIsPoseSurPeriode()) == false){
                    if(bean.getTypeJourneeDebut().equals("amPm")){
                       
                        
                        nvelleAbsConge.setNombreJourAbsence(0.5);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                        
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                        
                        if(bean.getTypeJourneeDebut().equals("am")){
                            nvelleAbsConge.setCommentaireAbsence("AM");
                        } else {
                            nvelleAbsConge.setCommentaireAbsence("PM");
                        } 
                         
                        absenceDao.create(nvelleAbsConge);
                        
                    } else {
                        nvelleAbsConge.setNombreJourAbsence(1);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        nvelleAbsConge.setCommentaireAbsence("");
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                        absenceDao.create(nvelleAbsConge);
                        
                    }
                } else {
                   if((bean.getTypeJourneeDebut().equals("am")) && (bean.getTypeJourneeFin().equals("pm"))){
                        //calculer nbJours et créer absence
                        String debut = bean.getDateProchainConges();
                        String fin = bean.getDateFinProchainConges();
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = df.parse(bean.getDateProchainConges());
                            Date d2 = df.parse(bean.getDateFinProchainConges());
                            double diff = d2.getTime() - d1.getTime();
                            
                            nvelleAbsConge.setNombreJourAbsence(diff);
                            nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                            nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                            nvelleAbsConge.setCommentaireAbsence("");
                            if(bean.getIdTypeAbsence().equals("choixConge")) {
                                type.setIdTypeAbsence(1);
                                nvelleAbsConge.setRefTypeAbsence(type); 
                            } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                                type.setIdTypeAbsence(2);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            } else {
                                type.setIdTypeAbsence(3);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            }
                            ress.setIdRessource(idRessource);
                            nvelleAbsConge.setRefRessource(ress);
                            
                            absenceDao.create(nvelleAbsConge);
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                       
                   } else if ((bean.getTypeJourneeDebut().equals("am")) && (bean.getTypeJourneeFin().equals("am"))){
                        
                        String debut = bean.getDateProchainConges();
                        String fin = bean.getDateFinProchainConges();
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = df.parse(bean.getDateProchainConges());
                            Date d2 = df.parse(bean.getDateFinProchainConges());
                            double diff = d2.getTime() - d1.getTime();
                            
                            nvelleAbsConge.setNombreJourAbsence(diff);
                            nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                            nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                            nvelleAbsConge.setCommentaireAbsence("");
                            if(bean.getIdTypeAbsence().equals("choixConge")) {
                                type.setIdTypeAbsence(1);
                                nvelleAbsConge.setRefTypeAbsence(type); 
                            } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                                type.setIdTypeAbsence(2);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            } else {
                                type.setIdTypeAbsence(3);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            }
                            ress.setIdRessource(idRessource);
                            nvelleAbsConge.setRefRessource(ress);
                            
                            absenceDao.create(nvelleAbsConge);
                        } catch (ParseException ex) {
                            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        nvelleAbsConge.setNombreJourAbsence(0.5);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        nvelleAbsConge.setCommentaireAbsence("AM");
                        
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                         
                        absenceDao.create(nvelleAbsConge);
                        
                 
                   } else if ((bean.getTypeJourneeDebut().equals("pm")) && (bean.getTypeJourneeFin().equals("am"))){
                        
                        nvelleAbsConge.setNombreJourAbsence(0.5);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setCommentaireAbsence("PM");
                        
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                         
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                        
                        absenceDao.create(nvelleAbsConge);
                        
                        //creer absence de dateDebut +1jr à dateDeFin - 1jr (nbJours = 1 2 3)
                        
                        
                        String debut = bean.getDateProchainConges();
                        String fin = bean.getDateFinProchainConges();
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = df.parse(bean.getDateProchainConges()); 
                            Date d2 = df.parse(bean.getDateFinProchainConges());
                            
                            GregorianCalendar gc = new GregorianCalendar();
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(); 
                            gregorianCalendar.setGregorianChange(d1); 
                            gregorianCalendar.add(gc.DAY_OF_YEAR,1); 
                            d1 = gregorianCalendar.getGregorianChange();
                            
                            gregorianCalendar.setGregorianChange(d2); 
                            gregorianCalendar.add(gc.DAY_OF_YEAR,-1); 
                            d2 = gregorianCalendar.getGregorianChange();
                            
                            double diff = d2.getTime() - d1.getTime();
                            
                            nvelleAbsConge.setNombreJourAbsence(diff);
                            nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                            nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                            nvelleAbsConge.setCommentaireAbsence("");
                            if(bean.getIdTypeAbsence().equals("choixConge")) {
                                type.setIdTypeAbsence(1);
                                nvelleAbsConge.setRefTypeAbsence(type); 
                            } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                                type.setIdTypeAbsence(2);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            } else {
                                type.setIdTypeAbsence(3);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            }
                            
                            ress.setIdRessource(idRessource);
                            nvelleAbsConge.setRefRessource(ress);
                            
                            absenceDao.create(nvelleAbsConge);
                        } catch (ParseException ex) {
                            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        //creer absence sur dateFin (0.5jr avec commenaire à AM)
                        
                        nvelleAbsConge.setNombreJourAbsence(0.5);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                        nvelleAbsConge.setCommentaireAbsence("AM");
                        
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                         
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                        
                        absenceDao.create(nvelleAbsConge);
                        
                   } else if ((bean.getTypeJourneeDebut().equals("pm")) && (bean.getTypeJourneeFin().equals("pm"))){
                        //creer absence dateDebut (0.5J)
                        nvelleAbsConge.setNombreJourAbsence(0.5);
                        nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                        nvelleAbsConge.setCommentaireAbsence("PM");
                        
                        if(bean.getIdTypeAbsence().equals("choixConge")) {
                            type.setIdTypeAbsence(1);
                            nvelleAbsConge.setRefTypeAbsence(type); 
                        } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                            type.setIdTypeAbsence(2);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        } else {
                            type.setIdTypeAbsence(3);
                            nvelleAbsConge.setRefTypeAbsence(type);
                        }
                         
                        ress.setIdRessource(idRessource);
                        nvelleAbsConge.setRefRessource(ress);
                        
                        absenceDao.create(nvelleAbsConge);
                        //creer absence de dateDebut+1 (non?) à dateFin (nbJours = 1 2 3)
                        
                        String debut = bean.getDateProchainConges();
                        String fin = bean.getDateFinProchainConges();
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = df.parse(bean.getDateProchainConges());
                            Date d2 = df.parse(bean.getDateFinProchainConges());
                            
                            GregorianCalendar gc = new GregorianCalendar();
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(); 
                            gregorianCalendar.setGregorianChange(d1); 
                            gregorianCalendar.add(gc.DAY_OF_YEAR,1); 
                            d1 = gregorianCalendar.getGregorianChange();
                            
                            double diff = d2.getTime() - d1.getTime();
                            
                            nvelleAbsConge.setNombreJourAbsence(diff);
                            nvelleAbsConge.setPremierJourAbsence(ConvertUtils.parseToDate(bean.getDateProchainConges(), "US"));
                            nvelleAbsConge.setDateFinAbsence(ConvertUtils.parseToDate(bean.getDateFinProchainConges(), "US"));
                            nvelleAbsConge.setCommentaireAbsence("");
                            if(bean.getIdTypeAbsence().equals("choixConge")) {
                                type.setIdTypeAbsence(1);
                                nvelleAbsConge.setRefTypeAbsence(type); 
                            } else if (bean.getIdTypeAbsence().equals("choixRtt1")) {
                                type.setIdTypeAbsence(2);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            } else {
                                type.setIdTypeAbsence(3);
                                nvelleAbsConge.setRefTypeAbsence(type);
                            }
                            
                            ress.setIdRessource(idRessource);
                            nvelleAbsConge.setRefRessource(ress);

                            absenceDao.create(nvelleAbsConge);
                        } catch (ParseException ex) {
                            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                } 
                
		
		

		
		
		
                return bean;
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
