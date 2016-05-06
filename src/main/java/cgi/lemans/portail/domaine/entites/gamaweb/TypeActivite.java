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
@Table(name="type_activite")
public class TypeActivite extends EntiteGamaweb{
    
    @Id 
    @GeneratedValue 
    @Column(name="TypeAct")
    private String typeAct;
    
    @Column(name="Libelle")
    private String libelle;
    
    @Column(name="TypeActU")
    private String typeActU;
    
    public TypeActivite(){
        super();
    }

    public String getTypeAct() {
        return typeAct;
    }

    public void setTypeAct(String typeAct) {
        this.typeAct = typeAct;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTypeActU() {
        return typeActU;
    }

    public void setTypeActU(String typeActU) {
        this.typeActU = typeActU;
    }
    
    
    
}
