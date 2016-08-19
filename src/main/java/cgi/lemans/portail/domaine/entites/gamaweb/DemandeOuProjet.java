/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

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
    
    @ManyToOne(optional = false)
    @JoinColumn(name="REF_Ressource")
    private RessourceTma refRessource;
    
    @Column(name="Demande_Projet")
    private String demandeProjet;
    
    
    @Column(name="Libelle")
    private String libelle;
    
    @Column(name="REF_FORFAIT_BUDGET")
    private Integer refForfaitBudget;
    
    @Column(name="estimation_initiale")
    private Double estimationInitiale;
    
    @Column(name="estimation_revisee")
    private Double estimationRevisee;
        
    @Column(name="Type_demande")
    private String typeDemande;
    
    @Column(name="Dernier_etat")
    private String dernierEtat;
    
   
    
    @Column(name="charge_consommee_totale")
    private Double chargeConsommeTotale;
    
    @Column(name="charge_restante_totale")
    private Double chargeRestanteTotale;
    
   
    @Column(name="charge_vendue")
    private Double chargeVendue;
    
    @Column(name="commentaire")
    private String commentaire;
    
    
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

    public String getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
    }

    public String getDernierEtat() {
        return dernierEtat;
    }

    public void setDernierEtat(String dernierEtat) {
        this.dernierEtat = dernierEtat;
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
