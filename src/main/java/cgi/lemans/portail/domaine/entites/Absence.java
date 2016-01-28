/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

import java.util.Date;

/**
 *
 * @author souchul
 */
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
    
    public int getIdAbsence() {
        return idAbsence;
    }
    
    public void setIdAbsence(int idAbsence) {
        this.idAbsence = idAbsence;
    }
    
    public int getRefTypeAbsence() {
        return RefTypeAbsence;
    }
    
    public void setRefTypeAbsence(int refTypeAbsence) {
        this.RefTypeAbsence = refTypeAbsence;
    }
    
    public String getRefRessource() {
        return RefRessource;
    }
    
    public void setRefRessource(String refRessource) {
        this.RefRessource = refRessource;
    }
    
    public Date getPremierJourAbsence() {
        return PremierJourAbsence;
    }
    
    public void setPremierJourAbsence(Date premierJourAbsence) {
        this.PremierJourAbsence = premierJourAbsence;
    }
    
    public Date getDateFinAbsence() {
        return DateFinAbsence;
    }
    
    public void setDateFinAbsence(Date dateFinAbsence) {
        this.DateFinAbsence = dateFinAbsence;
    }
    
    public double getNombreJoursAbsence() {
        return NombreJourAbsence;
    }
    
    public void setNombreJourAbsence(double nombreJourAbsence) {
        this.NombreJourAbsence = nombreJourAbsence;
    }
}
