/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.impl.gamaweb.AbsenceDao;
import cgi.lemans.portail.domaine.impl.gamaweb.CufAbsenceDao;
import cgi.lemans.portail.domaine.impl.gamaweb.CufRessourceAbsenceDao;
import cgi.lemans.portail.service.IAbsenceService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author souchul
 */
@Transactional
public class AbsenceService implements IAbsenceService {
    
    private AbsenceDao absenceDao;
    private CufAbsenceDao cufAbsenceDao;
    private CufRessourceAbsenceDao curRessourceAbsenceDao;
    
    
    
    public void AbsenceDao(AbsenceDao absenceDao) {
    this.absenceDao = absenceDao;
    }
    
    public void CufAbsenceDao(CufAbsenceDao cufAbsenceDao) {
    this.cufAbsenceDao = cufAbsenceDao;
    }
    
    
    public void CufRessourceAbsenceDao(CufRessourceAbsenceDao cufRessourceAbsenceDao) {
    this.curRessourceAbsenceDao = cufRessourceAbsenceDao;
    }

    @Override
    public CufAbsence affichageCongePris() {
        String idRessource = "BJA";
        List listCongesPris = (List) (CufAbsence) cufAbsenceDao.findCufAbsenceByCongeAndRessourceAndPris(idRessource);
        return (CufAbsence) listCongesPris;
    }

    @Override
    public CufAbsence affichageRttq1Pris() {
        String idRessource = "BJA";
        List listRttq1Pris = (List) (CufAbsence) cufAbsenceDao.findCufAbsenceByrttq1AndRessourceAndPris(idRessource);
        return (CufAbsence) listRttq1Pris;
    }

    @Override
    public CufAbsence affichageRttq2Pris() {
        String idRessource = "BJA";
        List listRttq2Pris = (List) (CufAbsence) cufAbsenceDao.findCufAbsenceByrttq2AndRessourceAndPris(idRessource);
        return (CufAbsence) listRttq2Pris;
    }

    @Override
    public CufRessourceAbsence affichageCongeSolde() {
        String idRessource = "BJA";
        List listCongesSolde = curRessourceAbsenceDao.findCufRessourceAbsenceByCongeAndRessourceAndSolde(idRessource);
        return (CufRessourceAbsence) listCongesSolde;
    }

    @Override
    public CufRessourceAbsence affichageRttq1Solde() {
        String idRessource = "BJA";
        List listRttq1Solde = curRessourceAbsenceDao.findCufRessourceAbsenceByRttQ1AndRessourceAndSolde(idRessource);
        return (CufRessourceAbsence) listRttq1Solde;
    }

    @Override
    public CufRessourceAbsence affichageRttq2Solde() {
        String idRessource = "BJA";
        List listRttq2Solde = curRessourceAbsenceDao.findCufRessourceAbsenceByRttQ2AndRessourceAndSolde(idRessource);
        return (CufRessourceAbsence) listRttq2Solde;
    }
    

    
    
    

}
