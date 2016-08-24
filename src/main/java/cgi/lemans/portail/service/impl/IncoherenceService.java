/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import cgi.lemans.portail.controller.beans.IncoherenceBean;
import cgi.lemans.portail.controller.beans.ListIncoherenceBean;
import cgi.lemans.portail.controller.beans.LoginBean;
import cgi.lemans.portail.controller.beans.LoginCardBean;
import cgi.lemans.portail.domaine.entites.gamaweb.CufControleIncoherence;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.gamaweb.ICufControleIncoherenceDao;
import cgi.lemans.portail.domaine.gamaweb.IRessourceTmaDao;
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
    
    @Autowired
    private IRessourceTmaDao ressourceTmaDao;

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
    
    private LoginCardBean login(RessourceTma ressourceTma) {
		LoginCardBean log = new LoginCardBean();

		log.setTrigramme(ressourceTma.getIdRessource());
		log.setGroupinfra(ressourceTma.getGroupinfra());
               

		return log;
	}

    @Override
    public LoginBean connect(){
        
        List<RessourceTma> listress = ressourceTmaDao.findLogin();
		LoginBean ressRetour = new LoginBean();
		List<LoginCardBean> ress = new ArrayList<LoginCardBean>();
		for (RessourceTma ressourceTma : listress) {
			ress.add(login(ressourceTma));
                        
		
		ressRetour.setListLogin(ress);
		
                }
        return ressRetour;
    }
    
    
}
