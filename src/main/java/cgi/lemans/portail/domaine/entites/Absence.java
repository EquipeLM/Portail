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
    private int RefTypeAbsence;
    private String RefRessource;
    private Date PremierJourAbsence;
    private Date DateFinAbsence;
    private double NombreJourAbsence;
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
        return RefTypeAbsence;
    }
    
    public void setRefTypeAbsence(int refTypeAbsence) {
        this.RefTypeAbsence = refTypeAbsence;
    }
    
    @Column(name="REF_RESSOURCE")
    public String getRefRessource() {
        return RefRessource;
    }
    
    public void setRefRessource(String refRessource) {
        this.RefRessource = refRessource;
    }
    
    @Column(name="PERMIER_JOUR_ABSENCE")
    public Date getPremierJourAbsence() {
        return PremierJourAbsence;
    }
    
    public void setPremierJourAbsence(Date premierJourAbsence) {
        this.PremierJourAbsence = premierJourAbsence;
    }
    
    @Column(name="DATE_FIN_ABSENCE")
    public Date getDateFinAbsence() {
        return DateFinAbsence;
    }
    
    public void setDateFinAbsence(Date dateFinAbsence) {
        this.DateFinAbsence = dateFinAbsence;
    }
    
    @Column(name="NOMBRE_JOUR_ABSENCE")
    public double getNombreJoursAbsence() {
        return NombreJourAbsence;
    }
    
    public void setNombreJourAbsence(double nombreJourAbsence) {
        this.NombreJourAbsence = nombreJourAbsence;
    }
}
