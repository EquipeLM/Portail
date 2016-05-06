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
import javax.persistence.Table;

/**
 *
 * @author souchul
 */

@Entity
@Table(name="forfait_budget")
public class ForfaitBudget {
    
    @Id 
    @GeneratedValue 
    @Column(name="ID_FORFAIT_BUDGET")
    private Integer idForfaitBudget;
    
    @Column(name="CODE_FORFAIT_BUDGET")
    private String codeForfaitBudget;
    
    @Column(name="REF_SOUS_SYSTEME")
    private String refSousSysteme;
    
    @Column(name="LIBELLE_FORFAIT_BUDGET")
    private String libelleForfaitBudget;
    
    @Column(name="MONTANT_FORFAIT_BUDGET")
    private Double montantForfaitBudget;
    
    @Column(name="NOMBRE_JOUR_FORFAIT_BUDGET")
    private Double nbJourForfaitBudget;
    
    @Column(name="DATE_DEBUT_FORFAIT_BUDGET")
    private Date dateDebutForfaitBudget;
    
    @Column(name="DATE_FIN_FORFAIT_BUDGET")
    private Date dateFinForfaitBudget;
    
    @Column(name="TYPE_FORFAIT_BUDGET")
    private String typeForfaitBudget;
    
    public ForfaitBudget(){
        super();
    }

    public Integer getIdForfaitBudget() {
        return idForfaitBudget;
    }

    public void setIdForfaitBudget(Integer idForfaitBudget) {
        this.idForfaitBudget = idForfaitBudget;
    }

    public String getCodeForfaitBudget() {
        return codeForfaitBudget;
    }

    public void setCodeForfaitBudget(String codeForfaitBudget) {
        this.codeForfaitBudget = codeForfaitBudget;
    }

    public String getRefSousSysteme() {
        return refSousSysteme;
    }

    public void setRefSousSysteme(String refSousSysteme) {
        this.refSousSysteme = refSousSysteme;
    }

    public String getLibelleForfaitBudget() {
        return libelleForfaitBudget;
    }

    public void setLibelleForfaitBudget(String libelleForfaitBudget) {
        this.libelleForfaitBudget = libelleForfaitBudget;
    }

    public Double getMontantForfaitBudget() {
        return montantForfaitBudget;
    }

    public void setMontantForfaitBudget(Double montantForfaitBudget) {
        this.montantForfaitBudget = montantForfaitBudget;
    }

    public Double getNbJourForfaitBudget() {
        return nbJourForfaitBudget;
    }

    public void setNbJourForfaitBudget(Double nbJourForfaitBudget) {
        this.nbJourForfaitBudget = nbJourForfaitBudget;
    }

    public Date getDateDebutForfaitBudget() {
        return dateDebutForfaitBudget;
    }

    public void setDateDebutForfaitBudget(Date dateDebutForfaitBudget) {
        this.dateDebutForfaitBudget = dateDebutForfaitBudget;
    }

    public Date getDateFinForfaitBudget() {
        return dateFinForfaitBudget;
    }

    public void setDateFinForfaitBudget(Date dateFinForfaitBudget) {
        this.dateFinForfaitBudget = dateFinForfaitBudget;
    }

    public String getTypeForfaitBudget() {
        return typeForfaitBudget;
    }

    public void setTypeForfaitBudget(String typeForfaitBudget) {
        this.typeForfaitBudget = typeForfaitBudget;
    }
    
    
    
}
