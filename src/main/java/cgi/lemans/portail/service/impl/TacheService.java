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
import cgi.lemans.portail.controller.beans.TacheCardBean;
import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeActivite;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.domaine.gamaweb.IRessourceTmaDao;
import cgi.lemans.portail.domaine.gamaweb.ITypeActiviteDao;
import cgi.lemans.portail.service.ITacheService;
import cgi.lemans.portail.utils.ConvertUtils;
import java.text.DecimalFormat;

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
        
        @Autowired
	private IRessourceTmaDao ressourceTmaDao;

	private ListTacheBean tacheDm(DemandeOuProjet demandeOuProjet) {
		ListTacheBean task = new ListTacheBean();

		task.setId(ConvertUtils.parseInteger(demandeOuProjet.getIdDemande()));
		task.setLibelleDm(demandeOuProjet.getLibelle());

		return task;
	}

	private ListTacheBean tacheOT(TypeActivite typeActivite) {
		ListTacheBean task = new ListTacheBean();

		task.setLibelleTypeOT(typeActivite.getLibelle());

		return task;
	}

	private ListTacheBean allTaches(OrdreDeTravail ordreDeTravail) {
		ListTacheBean task = new ListTacheBean();
                
                
                double calcul =  ordreDeTravail.getChargeRestante() + ordreDeTravail.getChargeConsommeeTotale();
                
                
                DecimalFormat df = new DecimalFormat("########.00"); 
                String str = df.format(calcul); 
                calcul = Double.parseDouble(str.replace(',', '.'));

                /*BigDecimal bd = new BigDecimal(calcul);
                bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
                calcul = bd.doubleValue();*/
                
                task.setLibelleOT(ordreDeTravail.getLibelOT());
                   task.setLibelleTypeOT(ordreDeTravail.getTypeActivite());
                   task.setDate(ConvertUtils.formatterDate(ordreDeTravail.getDateFinPrevue()));
		   task.setChargePrevue(ordreDeTravail.getChargePrevue().toString());
                   task.setChargeRestante(ordreDeTravail.getChargeRestante().toString());
                   task.setId(ordreDeTravail.getIdOt());
                   task.setChargeConso(calcul);
                   
               if (ordreDeTravail.getChargeRestante() == 0.0){
                    task.setLibelleDmTermine(ordreDeTravail.getIdDemande().getLibelle());
                    
                    
               }else if(calcul == ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){
                    task.setLibelleDmDelais(ordreDeTravail.getIdDemande().getLibelle());
                    
	
               } else if (calcul > ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){
                   task.setLibelleDmRetard(ordreDeTravail.getIdDemande().getLibelle());
                   
                   
                } else if (calcul < ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){
                   task.setLibelleDmAvance(ordreDeTravail.getIdDemande().getLibelle());
                   
                }
                    
                

		return task;
                
	}
	
	private ListTacheBean allTachesEquipe(OrdreDeTravail ordreDeTravail) {
		ListTacheBean task = new ListTacheBean();
                
                
                double calcul =  ordreDeTravail.getChargeRestante() + ordreDeTravail.getChargeConsommeeTotale();
                
                
                DecimalFormat df = new DecimalFormat("########.00"); 
                String str = df.format(calcul); 
                calcul = Double.parseDouble(str.replace(',', '.'));

                /*BigDecimal bd = new BigDecimal(calcul);
                bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
                calcul = bd.doubleValue();*/
                
                    task.setLibelleOT(ordreDeTravail.getLibelOT());
                   task.setLibelleTypeOT(ordreDeTravail.getTypeActivite());
                   task.setDate(ConvertUtils.formatterDate(ordreDeTravail.getDateFinPrevue()));
		   task.setChargePrevue(ordreDeTravail.getChargePrevue().toString());
                   task.setChargeRestante(ordreDeTravail.getChargeRestante().toString());
                   task.setId(ordreDeTravail.getIdOt());
                   task.setChargeConso(calcul);
                   task.setTrigramme(ordreDeTravail.getRessource().getIdRessource());
                   
               
                if(ordreDeTravail.getIdDemande() != null){   
                   
                    if (ordreDeTravail.getChargeRestante() == 0.0){
                        task.setLibelleDmTermine(ordreDeTravail.getIdDemande().getLibelle());


                   }else if(calcul == ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){

                        task.setLibelleDmDelais(ordreDeTravail.getIdDemande().getLibelle());
                       


                   } else if (calcul > ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){
                       task.setLibelleDmRetard(ordreDeTravail.getIdDemande().getLibelle());


                    } else if (calcul < ordreDeTravail.getChargePrevue() && ordreDeTravail.getChargeRestante() != 0.0){
                       task.setLibelleDmAvance(ordreDeTravail.getIdDemande().getLibelle());

                    }
                 
                    
                }

		return task;
                
                
	}
        
        private ListTacheBean quiModal(RessourceTma ressourceTma) {
		ListTacheBean task = new ListTacheBean();
                task.setNom(ressourceTma.getNom());
                task.setPrenom(ressourceTma.getPrenom());
                return task;
        }

	@Override
	public TacheBean recupererDemandeModal(String tag) {
		List<DemandeOuProjet> listdm = demandeOuProjetDao.findListDemande(tag);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (DemandeOuProjet demandeOuProjet : listdm) {
			absResources.add(tacheDm(demandeOuProjet));

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
			absResources.add(tacheOT(typeActivite));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
	}

	@Override
	public TacheBean recupererListDemande(String idRessource) {
		List<OrdreDeTravail> allOt = ordreDeTravailDao.findAllDemande(idRessource);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (OrdreDeTravail ordreDeTravail : allOt) {
			absResources.add(allTaches(ordreDeTravail));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
	}
        
        @Override
	public TacheBean afficherTacheEquipe(String tag) {
		List<OrdreDeTravail> allOtEquipe = ordreDeTravailDao.findAllDemandeEquipe(tag);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (OrdreDeTravail ordreDeTravail : allOtEquipe) {
			absResources.add(allTachesEquipe(ordreDeTravail));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
	}

    @Override
    public TacheCardBean enregistrerConsoEnd(String idRessource, TacheCardBean bean) {
        OrdreDeTravail consoEndTache = new OrdreDeTravail();
        consoEndTache.setChargeConsommeeTotale(ConvertUtils.parseDouble(bean.getChargeConsomme()));
        ordreDeTravailDao.create(consoEndTache);
        return bean;
    }

    @Override
    public TacheBean recupererListQui(String tag) {
        List<RessourceTma> quiTAcheModal = ressourceTmaDao.findQuiEquipe(tag);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (RessourceTma ressourceTma : quiTAcheModal) {
			absResources.add(quiModal(ressourceTma));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
    }

}
