/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

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
@Table(name="cuf_ressource_absence")
public class CufRessourceAbsence {
 
    private int idRessourceAbsence;
    private String idRessource;
    private int annee;
    private int typeAbsence;
    private double solde;
    
    public CufRessourceAbsence() {
        super();
    }

    @Id @GeneratedValue 
    @Column(name="idRessourceAbsence")
    public int getIdRessourceAbsence() {
        return idRessourceAbsence;
    }

    public void setIdRessourceAbsence(int idRessourceAbsence) {
        this.idRessourceAbsence = idRessourceAbsence;
    }

    @Column(name="IdRessource")
    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    @Column(name="annee")
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Column(name="typeAbsence")
    public int getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(int typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    @Column(name="solde")
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
    
}
