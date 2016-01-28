/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

/**
 *
 * @author souchul
 */
public class CufRessourceAbsence {
 
    private int idRessourceAbsence;
    private String idRessource;
    private int annee;
    private int typeAbsence;
    private double solde;
    
    public CufRessourceAbsence() {
        super();
    }

    public int getIdRessourceAbsence() {
        return idRessourceAbsence;
    }

    public void setIdRessourceAbsence(int idRessourceAbsence) {
        this.idRessourceAbsence = idRessourceAbsence;
    }

    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(int typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
    
}
