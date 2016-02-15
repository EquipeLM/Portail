/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author souchul
 */

@Entity
@Table(name="cuf_ressource_absence")
public class CufRessourceAbsence extends EntiteGamaweb{
 
    /**
     * 
     */
    private static final long serialVersionUID = -8154197893511044838L;
    @Id 
    @GeneratedValue 
    @Column(name="idRessourceAbsence")
    private Integer idRessourceAbsence;
    
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="IdRessource")
    private RessourceTma ressourceTma;
    
    @Column(name="annee")
    private Integer annee;
    
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="typeAbsence")
    private TypeAbsence typeAbsence;
    
    @Column(name="solde")
    private Double solde;
    
    
    public int getIdRessourceAbsence() {
        return idRessourceAbsence;
    }

    public void setIdRessourceAbsence(int idRessourceAbsence) {
        this.idRessourceAbsence = idRessourceAbsence;
    }
    
    @Column(name="annee")
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="ID_TYPE_ABSENCE")
    public TypeAbsence getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(TypeAbsence typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    @Column(name="solde")
    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

	public RessourceTma getRessourceTma() {
		return ressourceTma;
	}

	public void setRessourceTma(RessourceTma ressourceTma) {
		this.ressourceTma = ressourceTma;
	}
    
    
    
}
