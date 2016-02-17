/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeAbsence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.ICufRessourceAbsenceDao;
import cgi.lemans.portail.domaine.gamaweb.impl.CufAbsenceDao;
import cgi.lemans.portail.service.IAbsenceService;
import java.util.Calendar;

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
    public AbsenceCardBean recupererInfosAbsRessource() {
        String idRessource = "BJA";
        List<Object[]> listCongesPris = (List<Object[]>)  cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource, CufAbsenceDao.CONGES);
        List<Object[]> listQ1Pris = (List<Object[]>) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q1);
        List<Object[]> listQ2Pris = (List<Object[]>) cufAbsenceDao.findCufAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q2);
        
        List<CufRessourceAbsence> listCongesSolde = (List<CufRessourceAbsence>)  cufRessourceAbsenceDao.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.CONGES);
        List<CufRessourceAbsence> listQ1Solde = (List<CufRessourceAbsence>)  cufRessourceAbsenceDao.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q1);
        List<CufRessourceAbsence> listQ2Solde = (List<CufRessourceAbsence>)  cufRessourceAbsenceDao.findCufRessourceAbsenceByTypeByRessource(idRessource, CufAbsenceDao.RTT_Q2);
        
        List<Absence> dateProchainConge = (List<Absence>)  absenceDao.findAbsenceByPremierJourAbsence(idRessource);
        
        List<Absence> dureeProchainConge = (List<Absence>)  absenceDao.findAbsenceByDureeAbsence(idRessource);
        
        AbsenceCardBean absRetour = new AbsenceCardBean();
        
        return absRetour;
    }


	@Override
	public void enregistrerInfosParTypes(AbsenceCardBean bean) {
		CufRessourceAbsence newSoldeConge = new CufRessourceAbsence();
		RessourceTma ress = new RessourceTma();
		TypeAbsence type = new TypeAbsence();
		type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.CONGES));
		ress.setIdRessource("BJA");
		newSoldeConge.setAnnee(Calendar.YEAR);
                newSoldeConge.setSolde(new Integer(null).doubleValue());
		cufRessourceAbsenceDao.create(newSoldeConge);
                
                CufRessourceAbsence newSoldeQ1 = new CufRessourceAbsence();
                type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.RTT_Q1));
		ress.setIdRessource("BJA");
		newSoldeConge.setAnnee(Calendar.YEAR);
                newSoldeConge.setSolde(new Integer(null).doubleValue());
		cufRessourceAbsenceDao.create(newSoldeQ1);
                
                CufRessourceAbsence newSoldeQ2 = new CufRessourceAbsence();
                type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.RTT_Q2));
		ress.setIdRessource("BJA");
		newSoldeConge.setAnnee(Calendar.YEAR);
                newSoldeConge.setSolde(new Integer(null).doubleValue());
		cufRessourceAbsenceDao.create(newSoldeQ2);
                
                
                Absence nvelleAbsConge = new Absence();
                type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.CONGES));
                ress.setIdRessource("BJA");
                nvelleAbsConge.setPremierJourAbsence(null);
                nvelleAbsConge.setDateFinAbsence(null);
                nvelleAbsConge.setNombreJourAbsence(0);
                absenceDao.create(nvelleAbsConge);
                
                Absence nvelleAbsQ1 = new Absence();
                type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.RTT_Q1));
                ress.setIdRessource("BJA");
                nvelleAbsConge.setPremierJourAbsence(null);
                nvelleAbsConge.setDateFinAbsence(null);
                nvelleAbsConge.setNombreJourAbsence(0);
                absenceDao.create(nvelleAbsQ1);
                
                Absence nvelleAbsQ2 = new Absence();
                type.setIdTypeAbsence(Integer.parseInt(CufAbsenceDao.RTT_Q2));
                ress.setIdRessource("BJA");
                nvelleAbsConge.setPremierJourAbsence(null);
                nvelleAbsConge.setDateFinAbsence(null);
                nvelleAbsConge.setNombreJourAbsence(0);
                absenceDao.create(nvelleAbsQ2);
                
                //update absence
                
	}
    
    
}
