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
@Table(name="cuf_controle_incoherence")
public class CufControleIncoherence {
    
    @Id 
    @GeneratedValue 
    @Column(name="id")
    private Integer id;
    
    @Column(name="idControle")
    private Integer idControle;
    
    @Column(name="idResponsable")
    private String idResponsable;
    
    @Column(name="idRessource")
    private String idRessource;
    
    @Column(name="idDemande")
    private String idDemande;
    
    @Column(name="idCommande")
    private Integer idCommande;
    
    @Column(name="datePremiereDetection")
    private Date datePremiereDetection;
    
    @Column(name="dateDerniereDetection")
    private Date dateDerniereDetection;
    
    @Column(name="informationsObjet")
    private String informationsObjet;
    
    @Column(name="statut")
    private String statut;
    
    @Column(name="commentaireExclusion")
    private String commentaireExclusion;
    
    public CufControleIncoherence(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdControle() {
        return idControle;
    }

    public void setIdControle(Integer idControle) {
        this.idControle = idControle;
    }

    public String getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    public String getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDatePremiereDetection() {
        return datePremiereDetection;
    }

    public void setDatePremiereDetection(Date datePremiereDetection) {
        this.datePremiereDetection = datePremiereDetection;
    }

    public Date getDateDerniereDetection() {
        return dateDerniereDetection;
    }

    public void setDateDerniereDetection(Date dateDerniereDetection) {
        this.dateDerniereDetection = dateDerniereDetection;
    }

    public String getInformationsObjet() {
        return informationsObjet;
    }

    public void setInformationsObjet(String informationsObjet) {
        this.informationsObjet = informationsObjet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCommentaireExclusion() {
        return commentaireExclusion;
    }

    public void setCommentaireExclusion(String commentaireExclusion) {
        this.commentaireExclusion = commentaireExclusion;
    }
    
    
    
    
    
    
    
}
