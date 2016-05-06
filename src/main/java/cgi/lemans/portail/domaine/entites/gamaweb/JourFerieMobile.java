/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

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
@Table(name="jour_ferie_mobile")
public class JourFerieMobile {
    
    @Id 
    @GeneratedValue 
    @Column(name="ID_JOUR_FERIE_MOBILE")
    private Integer idJourFerieMobile;
    
    @Column(name="REF_CALENDRIER")
    private Integer refCalendrier;
    
    @Column(name="LIBELLE_JOUR_FERIE_MOBILE")
    private String libelleJourFerieMobile;
    
    @Column(name="DATE_JOUR_FERIE_MOBILE")
    private Date dateJourFerieMobile;
    
    @Column(name="NOMBRE_JOUR_FERIE_MOBILE")
    private Integer nbJourFerieMobile;
    
    @Column(name="ANNEE_JOUR_FERIE_MOBILE")
    private Date anneJourFerieMobile;
    
    public JourFerieMobile(){
        super();
    }

    public Integer getIdJourFerieMobile() {
        return idJourFerieMobile;
    }

    public void setIdJourFerieMobile(Integer idJourFerieMobile) {
        this.idJourFerieMobile = idJourFerieMobile;
    }

    public Integer getRefCalendrier() {
        return refCalendrier;
    }

    public void setRefCalendrier(Integer refCalendrier) {
        this.refCalendrier = refCalendrier;
    }

    public String getLibelleJourFerieMobile() {
        return libelleJourFerieMobile;
    }

    public void setLibelleJourFerieMobile(String libelleJourFerieMobile) {
        this.libelleJourFerieMobile = libelleJourFerieMobile;
    }

    public Date getDateJourFerieMobile() {
        return dateJourFerieMobile;
    }

    public void setDateJourFerieMobile(Date dateJourFerieMobile) {
        this.dateJourFerieMobile = dateJourFerieMobile;
    }

    public Integer getNbJourFerieMobile() {
        return nbJourFerieMobile;
    }

    public void setNbJourFerieMobile(Integer nbJourFerieMobile) {
        this.nbJourFerieMobile = nbJourFerieMobile;
    }

    public Date getAnneJourFerieMobile() {
        return anneJourFerieMobile;
    }

    public void setAnneJourFerieMobile(Date anneJourFerieMobile) {
        this.anneJourFerieMobile = anneJourFerieMobile;
    }
    
    
    
}
