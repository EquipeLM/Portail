/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.IncoherenceBean;
import cgi.lemans.portail.controller.beans.ListIncoherenceBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufControleIncoherence;
import cgi.lemans.portail.domaine.gamaweb.ICufControleIncoherenceDao;
import cgi.lemans.portail.service.IIncoherenceService;
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
public class IncoherenceService implements IIncoherenceService{
    
    @Autowired
    private ICufControleIncoherenceDao cufControleIncoherenceDao;

    private ListIncoherenceBean incoherence(CufControleIncoherence cufControleIncoherence) {
		ListIncoherenceBean inco = new ListIncoherenceBean();

		inco.setId(cufControleIncoherence.getId());
		inco.setIdResponsable(cufControleIncoherence.getIdResponsable());

		return inco;
	}
    
    
    @Override
    public IncoherenceBean afficherNbIncoherence(String idRessource) {
        List<CufControleIncoherence> incoh = cufControleIncoherenceDao.findNbIncoherence(idRessource);
        IncoherenceBean incoherence = new IncoherenceBean();
        List<ListIncoherenceBean> listInco = new ArrayList<ListIncoherenceBean>();
        for (CufControleIncoherence cufControleIncoherence : incoh){
            listInco.add(incoherence(cufControleIncoherence));
        }
        incoherence.setListInco(listInco);
        
        return incoherence;
    }
 
    
}
