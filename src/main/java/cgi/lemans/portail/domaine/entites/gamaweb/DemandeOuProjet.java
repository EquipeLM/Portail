/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author souchul
 */

@Entity
@Table(name="demande_ou_projet")
public class DemandeOuProjet extends EntiteGamaweb{
    
     
    @Id
    @Column(name="IdDemande")
    private String idDemande;
    
    @ManyToOne
    @JoinColumn(name="REF_Ressource")
    private RessourceTma refRessource;
    
    @Column(name="Demande_Projet")
    private String demandeProjet;
    
    @Column(name="IdClientDemande")
    private String idClientDemande;
    
    @Column(name="NomInterlocuteur")
    private String nomInterlocuteur;
    
    @Column(name="Libelle")
    private String libelle;
    
    @Column(name="REF_FORFAIT_BUDGET")
    private Integer refForfaitBudget;
    
    @Column(name="Date_emission")
    private Date dateEmission;
    
    @Column(name="Date_derniere_MAJ")
    private Date dateDerniereMAJ;
    
    @Column(name="niveau_de_severite")
    private String niveauDeSeverite;
    
    @Column(name="Date_livraison_souhaitee")
    private Date dateLivraisonSouhaitee;
    
    @Column(name="estimation_initiale")
    private Double estimationInitiale;
    
    @Column(name="estimation_revisee")
    private Double estimationRevisee;
    
    @Column(name="Date_livraison_prevue")
    private Date dateLivraisonPrevue;
    
    @Column(name="Reponse")
    private String reponse;
    
    @Column(name="Emetteur_reponse")
    private String emetteur_reponse;
    
    @Column(name="Date_livraison")
    private Date dateLivraison;
    
    @Column(name="Mot_Cle")
    private String motCle;
    
    @Column(name="Description_technique")
    private String descriptionTechnique;
    
    @Column(name="Reponse_technique")
    private String reponseTechnique;
    
    @Column(name="Type_demande")
    private String typeDemande;
    
    @Column(name="lot")
    private String lot;
    
    @Column(name="Date_reception")
    private Date dateReception;
    
    @Column(name="Dernier_etat")
    private String dernierEtat;
    
    @Column(name="Date_validation")
    private Date date_validation;
    
    @Column(name="charge_consommee_totale")
    private Double chargeConsommeTotale;
    
    @Column(name="charge_restante_totale")
    private Double chargeRestanteTotale;
    
    @Column(name="Piece_jointe")
    private String pieceJointe;
    
    @Column(name="Demande_rattachee")
    private String demandeRattachee;
    
    @Column(name="Priorite")
    private Integer priorite;
    
    @Column(name="cuf_alpha1")
    private String cufAlapha1;
    
    @Column(name="cuf_alpha2")
    private String cufAlapha2;
    
    @Column(name="cuf_alpha3")
    private String cufAlapha3;
    
    @Column(name="cuf_alpha4")
    private String cufAlapha4;
    
    @Column(name="cuf_alpha5")
    private String cufAlapha5;
    
    @Column(name="cuf_alpha6")
    private String cufAlapha6;
    
    @Column(name="cuf_alpha7")
    private String cufAlapha7;
    
    @Column(name="cuf_alpha8")
    private String cufAlapha8;
    
    @Column(name="cuf_alpha9")
    private String cufAlapha9;
    
    @Column(name="cuf_alpha10")
    private String cufAlapha10;
    
    @Column(name="niveau_severite_initial")
    private String niveauSeveriteInitial;
    
    @Column(name="niveau_priorite_initial")
    private String niveauPrioriteInitial;
    
    @Column(name="charge_vendue")
    private Double chargeVendue;
    
    @Column(name="commentaire")
    private String commentaire;
    
    @Column(name="IdAvenant")
    private String idAvenant;
    
    @Column(name="checkbox1")
    private Integer checkbox1;
    
    @Column(name="checkbox2")
    private Integer checkbox2;
    
    @Column(name="checkbox3")
    private Integer checkbox3;
    
    @Column(name="checkbox4")
    private Integer checkbox4;
    
    @Column(name="checkbox5")
    private Integer checkbox5;
    
    @Column(name="cuf_alpha11")
    private String cufAlapha11;
    
    @Column(name="cuf_alpha12")
    private String cufAlapha12;
    
    @Column(name="cuf_alpha13")
    private String cufAlapha13;
    
    @Column(name="type_retour")
    private String typeRetour;
    
    @Column(name="env_retour")
    private String EnvRetour;
    
    @Column(name="phase_retour")
    private String phaseRetour;
    
    @Column(name="valideur_fo")
    private String valideurFo;
    
    @Column(name="valideur_bo")
    private String valideurBo;
    
    @Column(name="preconisation")
    private String preconisation;
    
    @Column(name="Date_reception_GWS")
    private Date dateReceptionGWS;
    
    @Column(name="idAdresse")
    private Integer idAdresse;
    
    @Column(name="statut_Modif")
    private String statutModif;
    
    @Column(name="charge_analyse")
    private Double chargeAnalyse;
    
    @Column(name="charge_realisation")
    private Double chargeRealisation;
    
    @Column(name="IdDemandeimport")
    private String idDemandeImport;
    
    @Column(name="Reponse_enrichi")
    private String reponseEnrichi;
    
    @Column(name="Reponse_technique_enrichi")
    private String reponseTechniqueEnrichi;
    
    @Column(name="commentaire_enrichi")
    private String commentaireEnrichi;
    
    @Column(name="charge_consommee_transverse_globale")
    private Double chargeConsommeTransverseGlobale;
    
    @Column(name="cout_consommee_transverse_globale")
    private Double coutConsommeTransverseGlobale;
    
    @Column(name="charge_consommee_transverse_appli")
    private Double chargeConsommeTransverseAppli;
    
    @Column(name="cout_consommee_transverse_appli")
    private Double coutConsommeTransverseAppli;
    
    @Column(name="cout_consomme")
    private Double coutConsomme;
    
    @Column(name="cout_restant")
    private Double coutRestant;
    
    
    public DemandeOuProjet(){
        super();
    }
    

    public String getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public RessourceTma getRefRessource() {
        return refRessource;
    }

    public void setRefRessource(RessourceTma refRessource) {
        this.refRessource = refRessource;
    }

    public String getDemandeProjet() {
        return demandeProjet;
    }

    public void setDemandeProjet(String demandeProjet) {
        this.demandeProjet = demandeProjet;
    }

    public String getIdClientDemande() {
        return idClientDemande;
    }

    public void setIdClientDemande(String idClientDemande) {
        this.idClientDemande = idClientDemande;
    }

    public String getNomInterlocuteur() {
        return nomInterlocuteur;
    }

    public void setNomInterlocuteur(String nomInterlocuteur) {
        this.nomInterlocuteur = nomInterlocuteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getRefForfaitBudget() {
        return refForfaitBudget;
    }

    public void setRefForfaitBudget(Integer refForfaitBudget) {
        this.refForfaitBudget = refForfaitBudget;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Date getDateDerniereMAJ() {
        return dateDerniereMAJ;
    }

    public void setDateDerniereMAJ(Date dateDerniereMAJ) {
        this.dateDerniereMAJ = dateDerniereMAJ;
    }

    public String getNiveauDeSeverite() {
        return niveauDeSeverite;
    }

    public void setNiveauDeSeverite(String niveauDeSeverite) {
        this.niveauDeSeverite = niveauDeSeverite;
    }

    public Date getDateLivraisonSouhaitee() {
        return dateLivraisonSouhaitee;
    }

    public void setDateLivraisonSouhaitee(Date dateLivraisonSouhaitee) {
        this.dateLivraisonSouhaitee = dateLivraisonSouhaitee;
    }

    public Double getEstimationInitiale() {
        return estimationInitiale;
    }

    public void setEstimationInitiale(Double estimationInitiale) {
        this.estimationInitiale = estimationInitiale;
    }

    public Double getEstimationRevisee() {
        return estimationRevisee;
    }

    public void setEstimationRevisee(Double estimationRevisee) {
        this.estimationRevisee = estimationRevisee;
    }

    public Date getDateLivraisonPrevue() {
        return dateLivraisonPrevue;
    }

    public void setDateLivraisonPrevue(Date dateLivraisonPrevue) {
        this.dateLivraisonPrevue = dateLivraisonPrevue;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getEmetteur_reponse() {
        return emetteur_reponse;
    }

    public void setEmetteur_reponse(String emetteur_reponse) {
        this.emetteur_reponse = emetteur_reponse;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public String getDescriptionTechnique() {
        return descriptionTechnique;
    }

    public void setDescriptionTechnique(String descriptionTechnique) {
        this.descriptionTechnique = descriptionTechnique;
    }

    public String getReponseTechnique() {
        return reponseTechnique;
    }

    public void setReponseTechnique(String reponseTechnique) {
        this.reponseTechnique = reponseTechnique;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public String getDernierEtat() {
        return dernierEtat;
    }

    public void setDernierEtat(String dernierEtat) {
        this.dernierEtat = dernierEtat;
    }

    public Date getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Date date_validation) {
        this.date_validation = date_validation;
    }

    public Double getChargeConsommeTotale() {
        return chargeConsommeTotale;
    }

    public void setChargeConsommeTotale(Double chargeConsommeTotale) {
        this.chargeConsommeTotale = chargeConsommeTotale;
    }

    public Double getChargeRestanteTotale() {
        return chargeRestanteTotale;
    }

    public void setChargeRestanteTotale(Double chargeRestanteTotale) {
        this.chargeRestanteTotale = chargeRestanteTotale;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public String getDemandeRattachee() {
        return demandeRattachee;
    }

    public void setDemandeRattachee(String demandeRattachee) {
        this.demandeRattachee = demandeRattachee;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public String getCufAlapha1() {
        return cufAlapha1;
    }

    public void setCufAlapha1(String cufAlapha1) {
        this.cufAlapha1 = cufAlapha1;
    }

    public String getCufAlapha2() {
        return cufAlapha2;
    }

    public void setCufAlapha2(String cufAlapha2) {
        this.cufAlapha2 = cufAlapha2;
    }

    public String getCufAlapha3() {
        return cufAlapha3;
    }

    public void setCufAlapha3(String cufAlapha3) {
        this.cufAlapha3 = cufAlapha3;
    }

    public String getCufAlapha4() {
        return cufAlapha4;
    }

    public void setCufAlapha4(String cufAlapha4) {
        this.cufAlapha4 = cufAlapha4;
    }

    public String getCufAlapha5() {
        return cufAlapha5;
    }

    public void setCufAlapha5(String cufAlapha5) {
        this.cufAlapha5 = cufAlapha5;
    }

    public String getCufAlapha6() {
        return cufAlapha6;
    }

    public void setCufAlapha6(String cufAlapha6) {
        this.cufAlapha6 = cufAlapha6;
    }

    public String getCufAlapha7() {
        return cufAlapha7;
    }

    public void setCufAlapha7(String cufAlapha7) {
        this.cufAlapha7 = cufAlapha7;
    }

    public String getCufAlapha8() {
        return cufAlapha8;
    }

    public void setCufAlapha8(String cufAlapha8) {
        this.cufAlapha8 = cufAlapha8;
    }

    public String getCufAlapha9() {
        return cufAlapha9;
    }

    public void setCufAlapha9(String cufAlapha9) {
        this.cufAlapha9 = cufAlapha9;
    }

    public String getCufAlapha10() {
        return cufAlapha10;
    }

    public void setCufAlapha10(String cufAlapha10) {
        this.cufAlapha10 = cufAlapha10;
    }

    public String getNiveauSeveriteInitial() {
        return niveauSeveriteInitial;
    }

    public void setNiveauSeveriteInitial(String niveauSeveriteInitial) {
        this.niveauSeveriteInitial = niveauSeveriteInitial;
    }

    public String getNiveauPrioriteInitial() {
        return niveauPrioriteInitial;
    }

    public void setNiveauPrioriteInitial(String niveauPrioriteInitial) {
        this.niveauPrioriteInitial = niveauPrioriteInitial;
    }

    public Double getChargeVendue() {
        return chargeVendue;
    }

    public void setChargeVendue(Double chargeVendue) {
        this.chargeVendue = chargeVendue;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(String idAvenant) {
        this.idAvenant = idAvenant;
    }

    public Integer getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(Integer checkbox1) {
        this.checkbox1 = checkbox1;
    }

    public Integer getCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(Integer checkbox2) {
        this.checkbox2 = checkbox2;
    }

    public Integer getCheckbox3() {
        return checkbox3;
    }

    public void setCheckbox3(Integer checkbox3) {
        this.checkbox3 = checkbox3;
    }

    public Integer getCheckbox4() {
        return checkbox4;
    }

    public void setCheckbox4(Integer checkbox4) {
        this.checkbox4 = checkbox4;
    }

    public Integer getCheckbox5() {
        return checkbox5;
    }

    public void setCheckbox5(Integer checkbox5) {
        this.checkbox5 = checkbox5;
    }

    public String getCufAlapha11() {
        return cufAlapha11;
    }

    public void setCufAlapha11(String cufAlapha11) {
        this.cufAlapha11 = cufAlapha11;
    }

    public String getCufAlapha12() {
        return cufAlapha12;
    }

    public void setCufAlapha12(String cufAlapha12) {
        this.cufAlapha12 = cufAlapha12;
    }

    public String getCufAlapha13() {
        return cufAlapha13;
    }

    public void setCufAlapha13(String cufAlapha13) {
        this.cufAlapha13 = cufAlapha13;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

    public void setTypeRetour(String typeRetour) {
        this.typeRetour = typeRetour;
    }

    public String getEnvRetour() {
        return EnvRetour;
    }

    public void setEnvRetour(String EnvRetour) {
        this.EnvRetour = EnvRetour;
    }

    public String getPhaseRetour() {
        return phaseRetour;
    }

    public void setPhaseRetour(String phaseRetour) {
        this.phaseRetour = phaseRetour;
    }

    public String getValideurFo() {
        return valideurFo;
    }

    public void setValideurFo(String valideurFo) {
        this.valideurFo = valideurFo;
    }

    public String getValideurBo() {
        return valideurBo;
    }

    public void setValideurBo(String valideurBo) {
        this.valideurBo = valideurBo;
    }

    public String getPreconisation() {
        return preconisation;
    }

    public void setPreconisation(String preconisation) {
        this.preconisation = preconisation;
    }

    public Date getDateReceptionGWS() {
        return dateReceptionGWS;
    }

    public void setDateReceptionGWS(Date dateReceptionGWS) {
        this.dateReceptionGWS = dateReceptionGWS;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getStatutModif() {
        return statutModif;
    }

    public void setStatutModif(String statutModif) {
        this.statutModif = statutModif;
    }

    public Double getChargeAnalyse() {
        return chargeAnalyse;
    }

    public void setChargeAnalyse(Double chargeAnalyse) {
        this.chargeAnalyse = chargeAnalyse;
    }

    public Double getChargeRealisation() {
        return chargeRealisation;
    }

    public void setChargeRealisation(Double chargeRealisation) {
        this.chargeRealisation = chargeRealisation;
    }

    public String getIdDemandeImport() {
        return idDemandeImport;
    }

    public void setIdDemandeImport(String idDemandeImport) {
        this.idDemandeImport = idDemandeImport;
    }

    public String getReponseEnrichi() {
        return reponseEnrichi;
    }

    public void setReponseEnrichi(String reponseEnrichi) {
        this.reponseEnrichi = reponseEnrichi;
    }

    public String getReponseTechniqueEnrichi() {
        return reponseTechniqueEnrichi;
    }

    public void setReponseTechniqueEnrichi(String reponseTechniqueEnrichi) {
        this.reponseTechniqueEnrichi = reponseTechniqueEnrichi;
    }

    public String getCommentaireEnrichi() {
        return commentaireEnrichi;
    }

    public void setCommentaireEnrichi(String commentaireEnrichi) {
        this.commentaireEnrichi = commentaireEnrichi;
    }

    public Double getChargeConsommeTransverseGlobale() {
        return chargeConsommeTransverseGlobale;
    }

    public void setChargeConsommeTransverseGlobale(Double chargeConsommeTransverseGlobale) {
        this.chargeConsommeTransverseGlobale = chargeConsommeTransverseGlobale;
    }

    public Double getCoutConsommeTransverseGlobale() {
        return coutConsommeTransverseGlobale;
    }

    public void setCoutConsommeTransverseGlobale(Double coutConsommeTransverseGlobale) {
        this.coutConsommeTransverseGlobale = coutConsommeTransverseGlobale;
    }

    public Double getChargeConsommeTransverseAppli() {
        return chargeConsommeTransverseAppli;
    }

    public void setChargeConsommeTransverseAppli(Double chargeConsommeTransverseAppli) {
        this.chargeConsommeTransverseAppli = chargeConsommeTransverseAppli;
    }

    public Double getCoutConsommeTransverseAppli() {
        return coutConsommeTransverseAppli;
    }

    public void setCoutConsommeTransverseAppli(Double coutConsommeTransverseAppli) {
        this.coutConsommeTransverseAppli = coutConsommeTransverseAppli;
    }

    public Double getCoutConsomme() {
        return coutConsomme;
    }

    public void setCoutConsomme(Double coutConsomme) {
        this.coutConsomme = coutConsomme;
    }

    public Double getCoutRestant() {
        return coutRestant;
    }

    public void setCoutRestant(Double coutRestant) {
        this.coutRestant = coutRestant;
    }
    
    
    
    
    
    
    
    
 
    
    
    
}
