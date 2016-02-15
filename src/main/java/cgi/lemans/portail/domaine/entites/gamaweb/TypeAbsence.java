/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

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
public class TypeAbsence extends EntiteGamaweb{
    
    /**
    * 
    */
    private static final long serialVersionUID = -3697243253215083022L;
    
    @Id 
    @GeneratedValue 
    @Column(name="ID_TYPE_ABSENCE")
    private Integer idTypeAbsence;
    
    @Column(name="LIBELLE_TYPE_ABSENCE")
    private String libelleTypeAbsence;
    
    
    
    public Integer getIdTypeAbsence() {
	return idTypeAbsence;
    }

    public void setIdTypeAbsence(Integer idTypeAbsence) {
	this.idTypeAbsence = idTypeAbsence;
    }
    
    public String getLibelleTypeAbsence() {
        return libelleTypeAbsence;
    }

    public void setLibelleTypeAbsence(String libelleTypeAbsence) {
        this.libelleTypeAbsence = libelleTypeAbsence;
    }
    
}
