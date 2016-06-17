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
@Table(name="type_demande")
public class TypeDemande {
    
    @Id 
    @GeneratedValue 
    @Column(name="TypeDem")
    private String typeDem;
    
    @Column(name="Libelle")
    private String libelle;
    
    @Column(name="TypeDemU")
    private String typeDemU;
    
    @Column(name="TypeFacturation")
    private String typeFacturation;
    
    public TypeDemande(){
        super();
    }

    public String getTypeDem() {
        return typeDem;
    }

    public void setTypeDem(String typeDem) {
        this.typeDem = typeDem;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTypeDemU() {
        return typeDemU;
    }

    public void setTypeDemU(String typeDemU) {
        this.typeDemU = typeDemU;
    }

    public String getTypeFacturation() {
        return typeFacturation;
    }

    public void setTypeFacturation(String typeFacturation) {
        this.typeFacturation = typeFacturation;
    }
    
    
    
}
