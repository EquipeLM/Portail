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
public class TypeAbsence {
    
    private int idTypeAbsence;
    private String libelleTypeAbsence;
    
    
    public TypeAbsence() {
        super();
    }

    public int getIdTypeAbsence() {
        return idTypeAbsence;
    }

    public void setIdTypeAbsence(int idTypeAbsence) {
        this.idTypeAbsence = idTypeAbsence;
    }

    public String getLibelleTypeAbsence() {
        return libelleTypeAbsence;
    }

    public void setLibelleTypeAbsence(String libelleTypeAbsence) {
        this.libelleTypeAbsence = libelleTypeAbsence;
    }
    
    
}
