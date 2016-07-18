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
import cgi.lemans.portail.domaine.entites.gamaweb.CufCommentaire;
import cgi.lemans.portail.domaine.entites.gamaweb.DemandeOuProjet;
import cgi.lemans.portail.domaine.entites.gamaweb.OrdreDeTravail;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeActivite;
import cgi.lemans.portail.domaine.gamaweb.ICufCommentaireDao;
import cgi.lemans.portail.domaine.gamaweb.IDemandeOuProjetDao;
import cgi.lemans.portail.domaine.gamaweb.IOrdreDeTravailDao;
import cgi.lemans.portail.domaine.gamaweb.IRessourceTmaDao;
import cgi.lemans.portail.domaine.gamaweb.ITypeActiviteDao;
import cgi.lemans.portail.service.ITacheService;
import cgi.lemans.portail.utils.ConvertUtils;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        
        @Autowired
        private ICufCommentaireDao cufCommentaireDao;

	private ListTacheBean tacheDm(DemandeOuProjet demandeOuProjet) {
		ListTacheBean task = new ListTacheBean();

		task.setIdDm(ConvertUtils.parseInteger(demandeOuProjet.getIdDemande()));
		task.setLibelleDm(demandeOuProjet.getLibelle());
                task.setEstimationRevisee(demandeOuProjet.getEstimationRevisee().toString());

		return task;
	}

	private ListTacheBean tacheOT(TypeActivite typeActivite) {
		ListTacheBean task = new ListTacheBean();
                
                task.setIdType(typeActivite.getTypeAct());
		task.setLibelleTypeOT(typeActivite.getLibelle());

		return task;
	}

	private ListTacheBean allTaches(OrdreDeTravail ordreDeTravail) {
		ListTacheBean task = new ListTacheBean();
                
                if (ordreDeTravail.getChargePrevue() != null && ordreDeTravail.getChargeRestante() != null && ordreDeTravail.getChargeConsommeeTotale() != null && ordreDeTravail.getIdDemande() != null){
                    
                
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
                   task.setIdOt(ordreDeTravail.getIdOt());
                   task.setChargeConso(ordreDeTravail.getChargeConsommeeTotale());
                   task.setIdDemande(ordreDeTravail.getIdDemande().getIdDemande());
                   
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
                   task.setIdOt(ordreDeTravail.getIdOt());
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
                task.setTrigramme(ressourceTma.getIdRessource());
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
        //consoEndTache.setRessource(bean.getUser());
        
        
        consoEndTache.setChargeConsommeeTotale(ConvertUtils.parseDouble(bean.getChargeConsomme()));
        consoEndTache.setIdOt(bean.getIdOt());
        
        DemandeOuProjet dm = new DemandeOuProjet();
        dm.setIdDemande(bean.getIdDemande());
        consoEndTache.setIdDemande(dm);
        
        RessourceTma ress = new RessourceTma();
        ress.setIdRessource(idRessource);
        consoEndTache.setRessource(ress);
        consoEndTache.setTypeActivite(bean.getType());
        
        consoEndTache.setIdForfaitBudget(0);
        consoEndTache.setChargeRestante(0.0);
        consoEndTache.setCoutConsomme(0.0);
        consoEndTache.setCout_restant(0.0);
        ordreDeTravailDao.create(consoEndTache);
        
        return bean;
    }

    @Override
    public TacheCardBean enregistrerConsoJour(String idRessource, TacheCardBean bean) {
        OrdreDeTravail consoEndTache = new OrdreDeTravail();
        //consoEndTache.setRessource(bean.getUser());
        
        
        consoEndTache.setChargeConsommeeTotale(ConvertUtils.parseDouble(bean.getChargeConsomme()));
        consoEndTache.setIdOt(bean.getIdOt());
        
        DemandeOuProjet dm = new DemandeOuProjet();
        dm.setIdDemande(bean.getIdDemande());
        consoEndTache.setIdDemande(dm);
        
        RessourceTma ress = new RessourceTma();
        ress.setIdRessource(idRessource);
        consoEndTache.setRessource(ress);
        consoEndTache.setTypeActivite(bean.getType());
        
        consoEndTache.setIdForfaitBudget(0);
        consoEndTache.setChargeRestante(ConvertUtils.parseDouble(bean.getChargeRestante()));
        consoEndTache.setCoutConsomme(0.0);
        consoEndTache.setCout_restant(0.0);
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

    @Override
    public TacheCardBean enregistrerNewTache(TacheCardBean bean) {
       OrdreDeTravail newTache = new OrdreDeTravail();
       DemandeOuProjet dm = new DemandeOuProjet();
       RessourceTma ress = new RessourceTma();
       
       newTache.setTypeActivite(bean.getType());
       //dm.setLibelle(bean.getDemande());  
       //newTache.setIdDemande(dm);
       dm.setIdDemande(bean.getIdDemande());
       newTache.setIdDemande(dm);
       ress.setIdRessource(bean.getUser());
       newTache.setRessource(ress);
       newTache.setLibelOT(bean.getDesignation());
       newTache.setChargePrevue(ConvertUtils.parseDouble(bean.getChargePrevue()));
       newTache.setChargeRestante(ConvertUtils.parseDouble(bean.getChargePrevue()));
       newTache.setChargeConsommeeTotale(0.0);
       newTache.setCoutConsomme(0.0);
       newTache.setCout_restant(0.0);
       newTache.setIdForfaitBudget(0);
      ordreDeTravailDao.create(newTache);
      
      // modfication 
      
      DemandeOuProjet newTacheUpdate = new DemandeOuProjet();
      
      newTacheUpdate.setIdDemande(bean.getIdDemande());
      newTacheUpdate.setEstimationRevisee(ConvertUtils.parseDouble(bean.getChargePrevue())+ConvertUtils.parseDouble(bean.getEstimationRevisee()));
      demandeOuProjetDao.update(newTacheUpdate);
      
       return bean;
    }

    @Override
    public TacheCardBean enregistrerComs(TacheCardBean bean, String idRessource) {
        
        CufCommentaire newComs = new CufCommentaire();
        
        newComs.setCommentaire(bean.getCommentaire());
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        newComs.setModifieLe(date);
        newComs.setModifierPar(idRessource);
        newComs.setIdOT(bean.getIdOt());
        
        
        cufCommentaireDao.create(newComs);
        return bean;
    }
    
    private ListTacheBean coms (CufCommentaire cufCommentaire) {
		ListTacheBean task = new ListTacheBean();
                
                task.setCommentaire(cufCommentaire.getCommentaire());
		task.setRessource(cufCommentaire.getModifierPar());
                task.setDateComs(cufCommentaire.getModifieLe().toString());

		return task;
	}

    @Override
    public TacheBean afficherComs(Integer idOT) {
        List<CufCommentaire> listComs = cufCommentaireDao.findCommentaire(idOT);
		TacheBean taskRetour = new TacheBean();
		List<ListTacheBean> absResources = new ArrayList<ListTacheBean>();
		for (CufCommentaire cufCommentaire : listComs) {
                   
			absResources.add(coms(cufCommentaire));

		}
		taskRetour.setListTache(absResources);

		return taskRetour;
    }

}
