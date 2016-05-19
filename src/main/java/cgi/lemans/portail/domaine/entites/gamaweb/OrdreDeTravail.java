/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author souchul
 */

@Entity
@Table(name="ordre_de_travail")
public class OrdreDeTravail extends EntiteGamaweb{
    
    @Id 
    @GeneratedValue 
    @Column(name="IdOT")
    private Integer idOt;
    
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="IdDemande")
    private DemandeOuProjet idDemande;
    
    
    @Column(name="TypeActivite")
    private String typeActivite;
    
    
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="Ressource")
    private RessourceTma ressource;
    
    @Column(name="Date_debut")
    private Date dateDebut;
    
    @Column(name="Date_fin_prevue")
    private Date dateFinPrevue;
    
    @Column(name="Date_fin_revisee")
    private Date dateFinRevise;
    
    @Column(name="charge_prevue")
    private Double chargePrevue;
    
    @Column(name="charge_consommee_totale")
    private Double chargeConsommeeTotale;
    
    @Column(name="charge_restante")
    private Double chargeRestante;
    
    @Column(name="libel_ot")
    private String libelOT;
    
    @Column(name="ID_FORFAIT_BUDGET")
    private Integer idForfaitBudget;
    
    @Column(name="charge_vendue_ot")
    private Double chargeVenduOT;
    
    @Column(name="charge_ajustee")
    private Double chargeAjustee;
    
    @Column(name="cout_consomme")
    private Double coutConsomme;
    
    @Column(name="cout_restant")
    private Double cout_restant;
    
    
    public OrdreDeTravail() {
        super();
    }

    public Integer getIdOt() {
        return idOt;
    }

    public void setIdOt(Integer idOt) {
        this.idOt = idOt;
    }

    public DemandeOuProjet getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(DemandeOuProjet idDemande) {
        this.idDemande = idDemande;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public RessourceTma getRessource() {
        return ressource;
    }

    public void setRessource(RessourceTma ressource) {
        this.ressource = ressource;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFinPrevue() {
        return dateFinPrevue;
    }

    public void setDateFinPrevue(Date dateFinPrevue) {
        this.dateFinPrevue = dateFinPrevue;
    }

    public Date getDateFinRevise() {
        return dateFinRevise;
    }

    public void setDateFinRevise(Date dateFinRevise) {
        this.dateFinRevise = dateFinRevise;
    }

    public Double getChargePrevue() {
        return chargePrevue;
    }

    public void setChargePrevue(Double chargePrevue) {
        this.chargePrevue = chargePrevue;
    }

    public Double getChargeConsommeeTotale() {
        return chargeConsommeeTotale;
    }

    public void setChargeConsommeeTotale(Double chargeConsommeeTotale) {
        this.chargeConsommeeTotale = chargeConsommeeTotale;
    }

    public Double getChargeRestante() {
        return chargeRestante;
    }

    public void setChargeRestante(Double chargeRestante) {
        this.chargeRestante = chargeRestante;
    }

    public String getLibelOT() {
        return libelOT;
    }

    public void setLibelOT(String libelOT) {
        this.libelOT = libelOT;
    }

    public Integer getIdForfaitBudget() {
        return idForfaitBudget;
    }

    public void setIdForfaitBudget(Integer idForfaitBudget) {
        this.idForfaitBudget = idForfaitBudget;
    }

    public Double getChargeVenduOT() {
        return chargeVenduOT;
    }

    public void setChargeVenduOT(Double chargeVenduOT) {
        this.chargeVenduOT = chargeVenduOT;
    }

    public Double getChargeAjustee() {
        return chargeAjustee;
    }

    public void setChargeAjustee(Double chargeAjustee) {
        this.chargeAjustee = chargeAjustee;
    }

    public Double getCoutConsomme() {
        return coutConsomme;
    }

    public void setCoutConsomme(Double coutConsomme) {
        this.coutConsomme = coutConsomme;
    }

    public Double getCout_restant() {
        return cout_restant;
    }

    public void setCout_restant(Double cout_restant) {
        this.cout_restant = cout_restant;
    }
    
    
}



        
    
