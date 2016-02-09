/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

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
@Table(name="absence")
public class Absence {
    
    private int idAbsence;
    private int refTypeAbsence;
    private String refRessource;
    private Date premierJourAbsence;
    private Date dateFinAbsence;
    private double nombreJourAbsence;
    //private String CommentaireAbsence;
    
    public Absence() {
        super();
    }
    
    @Id @GeneratedValue 
    @Column(name="ID_ABSENCE")
    public int getIdAbsence() {
        return idAbsence;
    }
    
    public void setIdAbsence(int idAbsence) {
        this.idAbsence = idAbsence;
    }
    
    @Column(name="REF_TYPE_ABSENCE")
    public int getRefTypeAbsence() {
        return refTypeAbsence;
    }
    
    public void setRefTypeAbsence(int refTypeAbsence) {
        this.refTypeAbsence = refTypeAbsence;
    }
    
    @Column(name="REF_RESSOURCE")
    public String getRefRessource() {
        return refRessource;
    }
    
    public void setRefRessource(String refRessource) {
        this.refRessource = refRessource;
    }
    
    @Column(name="PERMIER_JOUR_ABSENCE")
    public Date getPremierJourAbsence() {
        return premierJourAbsence;
    }
    
    public void setPremierJourAbsence(Date premierJourAbsence) {
        this.premierJourAbsence = premierJourAbsence;
    }
    
    @Column(name="DATE_FIN_ABSENCE")
    public Date getDateFinAbsence() {
        return dateFinAbsence;
    }
    
    public void setDateFinAbsence(Date dateFinAbsence) {
        this.dateFinAbsence = dateFinAbsence;
    }
    
    @Column(name="NOMBRE_JOUR_ABSENCE")
    public double getNombreJoursAbsence() {
        return nombreJourAbsence;
    }
    
    public void setNombreJourAbsence(double nombreJourAbsence) {
        this.nombreJourAbsence = nombreJourAbsence;
    }
}
