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

/**
 *
 * @author souchul
 */

@Entity
@Table(name="absence")
public class Absence extends EntiteGamaweb{
    
    private static final long serialVersionUID = -7675469008489694732L;
    
    @Id 
    @GeneratedValue 
    @Column(name="ID_ABSENCE")
    private Integer idAbsence;
        
    @ManyToOne
    @JoinColumn(name="REF_TYPE_ABSENCE")
    private TypeAbsence refTypeAbsence;
    
    @ManyToOne
    @JoinColumn(name="REF_RESSOURCE")
    private RessourceTma refRessource;
    
    @Column(name="PREMIER_JOUR_ABSENCE")
    private Date premierJourAbsence;
    
    @Column(name="DATE_FIN_ABSENCE")
    private Date dateFinAbsence;
    
    @Column(name="NOMBRE_JOURS_ABSENCE")
    private Double nombreJourAbsence;
    
    @Column (name="COMMENTAIRE_ABSENCE")
    private String commentaireAbsence;
    
    public Absence() {
        super();
    }
    
    public int getIdAbsence() {
        return idAbsence;
    }
    
    public void setIdAbsence(int idAbsence) {
        this.idAbsence = idAbsence;
    }
    
    
    public TypeAbsence getRefTypeAbsence() {
        return refTypeAbsence;
    }
    
    public void setRefTypeAbsence(TypeAbsence refTypeAbsence) {
        this.refTypeAbsence = refTypeAbsence;
    }
    
    @ManyToOne
    public RessourceTma getRefRessource() {
        return refRessource;
    }
    
    public void setRefRessource(RessourceTma refRessource) {
        this.refRessource = refRessource;
    }
    
    public Date getPremierJourAbsence() {
        return premierJourAbsence;
    }
    
    public void setPremierJourAbsence(Date premierJourAbsence) {
        this.premierJourAbsence = premierJourAbsence;
    }

    public Date getDateFinAbsence() {
        return dateFinAbsence;
    }
    
    public void setDateFinAbsence(Date dateFinAbsence) {
        this.dateFinAbsence = dateFinAbsence;
    }
    

    public Double getNombreJourAbsence() {
        return nombreJourAbsence;
    }
    
    public void setNombreJourAbsence(double nombreJourAbsence) {
        this.nombreJourAbsence = nombreJourAbsence;
    }

    public String getCommentaireAbsence() {
        return commentaireAbsence;
    }

    public void setCommentaireAbsence(String commentaireAbsence) {
        this.commentaireAbsence = commentaireAbsence;
    }
    
    
}
