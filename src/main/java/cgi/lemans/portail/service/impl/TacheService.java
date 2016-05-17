/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgi.lemans.portail.controller.beans.ListTacheBean;
import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeActivite;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.domaine.gamaweb.ITypeActiviteDao;
import cgi.lemans.portail.service.ITacheService;
import cgi.lemans.portail.utils.ConvertUtils;

/**
 *
 * @author souchul
 */

@Service
@Transactional(transactionManager = "txManagerGamaweb")
public class TacheService implements ITacheService {

	@Autowired
	private IDemandeOuProjetDao demandeOuProjetDao;

	@Autowired
	private IOrdreDeTravailDao ordreDeTravailDao;

	@Autowired
	private ITypeActiviteDao typeActiviteDao;

	private ListTacheBean TacheDm(DemandeOuProjet demandeOuProjet) {
		ListTacheBean task = new ListTacheBean();

		task.setId(ConvertUtils.parseInteger(demandeOuProjet.getIdDemande()));
		task.setLibelleDm(demandeOuProjet.getLibelle());

		return task;
	}

	private ListTacheBean TacheOT(TypeActivite typeActivite) {
		ListTacheBean task = new ListTacheBean();

		task.setLibelleTypeOT(typeActivite.getLibelle());

		return task;
	}

	private ListTacheBean AllTaches(OrdreDeTravail ordreDeTravail) {
		ListTacheBean task = new ListTacheBean();
		DemandeOuProjet dm = new DemandeOuProjet();
		TypeActivite type = new TypeActivite();

		task.setLibelleOT(ordreDeTravail.getLibelOT());
		task.setLibelleTypeOT(type.getLibelle());
		task.setLibelleDm(dm.getLibelle());
		task.setDate(ConvertUtils.formatterDate(ordreDeTravail.getDateFinPrevue()));
		task.setChargePrevue(ordreDeTravail.getChargePrevue().toString());

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
	public TacheBean recupererInfosTypeOTModal() {
		List<TypeActivite> listot = typeActiviteDao.findTypeOTModal();
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (TypeActivite typeActivite : listot) {
			absResources.add(TacheOT(typeActivite));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
	}

	@Override
	public TacheBean recupererListDemande(String idRessource) {
		List<Object[][]> allOT = ordreDeTravailDao.findAllDemande(idRessource);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (Object[] result : allOT) {
			Integer rsltDuCase = (Integer) result[0];
			OrdreDeTravail ot = (OrdreDeTravail) result[1];
			DemandeOuProjet dem = (DemandeOuProjet) result[2];

			// absResources.add(AllTaches(ordreDeTravail));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
	}

}
