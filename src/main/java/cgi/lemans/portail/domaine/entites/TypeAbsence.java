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
@Table(name="type_absence")
public class TypeAbsence {
    
    private int idTypeAbsence;
    private String libelleTypeAbsence;
    
    
    public TypeAbsence() {
        super();
    }

    @Id @GeneratedValue
    @Column(name="ID_TYPE_ABSENCE")
    public int getIdTypeAbsence() {
        return idTypeAbsence;
    }

    public void setIdTypeAbsence(int idTypeAbsence) {
        this.idTypeAbsence = idTypeAbsence;
    }

    @Column(name="LIBELLE_TYPE_ABSENCE")
    public String getLibelleTypeAbsence() {
        return libelleTypeAbsence;
    }

    public void setLibelleTypeAbsence(String libelleTypeAbsence) {
        this.libelleTypeAbsence = libelleTypeAbsence;
    }
    
    
}
