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
@Table(name="history_update")
public class HistoryUpdate {
    
    @Id 
    @GeneratedValue 
    @Column(name="IdHU")
    private Integer idHU;
    
    @Column(name="Date_modif")
    private Date dateModif;
    
    @Column(name="Nom")
    private String nom;
    
    @Column(name="Prenom")
    private String prenom;
    
    @Column(name="IdDemande")
    private String idDemande;
    
    @Column(name="update_content")
    private String updateContent;
    
    @Column(name="Type")
    private String type;
    
    public HistoryUpdate(){
        super();
    }

    public Integer getIdHU() {
        return idHU;
    }

    public void setIdHU(Integer idHU) {
        this.idHU = idHU;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
