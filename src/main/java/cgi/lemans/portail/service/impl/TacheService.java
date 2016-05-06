/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.ListTacheBean;
import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.controller.beans.TacheCardBean;
import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeActivite;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.service.ITacheService;
import cgi.lemans.portail.utils.ConvertUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author souchul
 */

@Service
@Transactional(transactionManager = "txManagerGamaweb")
public class TacheService implements ITacheService{
    
    @Autowired
    private IDemandeOuProjetDao demandeOuProjetDao;
    
    @Autowired
    private IOrdreDeTravailDao ordreDeTravailDao;
    
    private ListTacheBean TacheDm(DemandeOuProjet demandeOuProjet) {
		ListTacheBean task = new ListTacheBean();
		
		task.setId(ConvertUtils.parseInteger(demandeOuProjet.getIdDemande()));
		task.setLibelle(demandeOuProjet.getLibelle());
                
                
		return task;
	}
    private ListTacheBean TacheOT(OrdreDeTravail ordreDeTravail) {
		ListTacheBean task = new ListTacheBean();
		
		task.setId(ordreDeTravail.getIdOt());
		task.setLibelle(ordreDeTravail.getLibelOT());
                
                
		return task;
	}
    
    
    @Override
    public TacheBean recupererDemandeModal(String tag) {
        List<DemandeOuProjet> listdm = demandeOuProjetDao.findListDemande(tag);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (DemandeOuProjet demandeOuProjet : listdm) {
			absResources.add(TacheDm(demandeOuProjet));      
                        
                }
                taskRetour.setListTache(absResources);
              
		return taskRetour;
    }

        
    @Override
    public TacheBean recupererInfosOrdreTravailModal(String tag) {
        List<OrdreDeTravail> listot = ordreDeTravailDao.findInfosOrdreTravailModal(tag);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (OrdreDeTravail ordreDeTravail : listot) {
			absResources.add(TacheOT(ordreDeTravail));      
                        
                }
                taskRetour.setListTache(absResources);
              
		return taskRetour;
    }

    @Override
    public TacheCardBean recupererListDemande(String tag) {
        List<OrdreDeTravail> listDemande = ordreDeTravailDao.findAllDemande("CNP");
        DemandeOuProjet dm = new DemandeOuProjet();
        TypeActivite type = new TypeActivite();
               //dm.setLibelle(); recupérer par l'id
		TacheCardBean tacheRetour = new TacheCardBean();
		
		for (OrdreDeTravail ordreDeTravail : listDemande) {
			
                        tacheRetour.setOt(ordreDeTravail.getLibelOT());
                        tacheRetour.setDate(ConvertUtils.formatterDate(ordreDeTravail.getDateFinPrevue()));
                        tacheRetour.setDemande(dm.getLibelle()); 
                        //tacheRetour.setCharge(ordreDeTravail.getChargePrevue().toString());
                        tacheRetour.setType(type.getLibelle());
                        ;
                        
                }
                return tacheRetour;
                
    }

    
    
    
}
