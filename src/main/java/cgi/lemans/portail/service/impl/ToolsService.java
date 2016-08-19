package cgi.lemans.portail.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.IconesCardBean;
import cgi.lemans.portail.controller.beans.ToolsCardBean;
import cgi.lemans.portail.domaine.entites.newportal.Icones;
import cgi.lemans.portail.domaine.entites.newportal.IconesByUser;
import cgi.lemans.portail.domaine.gamaweb.ILoginDao;
import cgi.lemans.portail.domaine.newportal.IIconesByUserDao;
import cgi.lemans.portail.service.IToolsService;

/**
 * @author gautierfa
 *
 */
@Service
@Transactional(transactionManager = "txManagerNewPortal")
public class ToolsService implements IToolsService {
	
	@Autowired
	IIconesByUserDao iconeByUserDao;
        
        @Autowired
        ILoginDao loginDao;

	@Override
	public ToolsCardBean afficherLesIconesCardByUser(String user) {
		List<IconesByUser> lesIcones = iconeByUserDao.getIconesPlusUtilises(user);
		List<IconesCardBean> iconesVue = new ArrayList<IconesCardBean>();
		for (IconesByUser iconesByUser : lesIcones) {
			IconesCardBean iconeUser = new IconesCardBean();
			Icones icone = iconesByUser.getIcone();
			iconeUser.setClassStyle(icone.getIcone());
			iconeUser.setHrefLien(icone.getLien());
			iconeUser.setTitre(icone.getText());
			iconeUser.setIdIcone(icone.getIdIcone());
			iconesVue.add(iconeUser);
		}
		IconesByUser iconeUse = iconeByUserDao.getLastIconeByUser(user);
		IconesCardBean iconeUser = new IconesCardBean();
		Icones icone = iconeUse.getIcone();
		iconeUser.setClassStyle(icone.getIcone());
		iconeUser.setHrefLien(icone.getLien());
		iconeUser.setTitre(icone.getText());
		iconeUser.setIdIcone(icone.getIdIcone());
		
		ToolsCardBean tools = new ToolsCardBean();
		tools.setIconDernierUtilise(iconeUser);
		tools.setIconesPlusUtilise(iconesVue);
		return tools;
	}

	@Override
	public void enregistrerClicIcone(String idIcone, String idUser) {
		Icones icone = new Icones();
		icone.setIdIcone(Long.parseLong(idIcone));
		IconesByUser icbu = iconeByUserDao.getIconeByUser(idIcone, idUser);
		icbu.setCpt(icbu.getCpt() + 1);
		iconeByUserDao.update(icbu);
	}

    
        
        

	
}
