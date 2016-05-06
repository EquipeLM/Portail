package cgi.lemans.portail.domaine.entites.gamaweb;


import cgi.lemans.portail.domaine.entites.gamaweb.EntiteGamaweb;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author souchul
 */

@Entity
@Table(name="cuf_planning")
public class CufPlanning extends EntiteGamaweb{
   
    @Id 
    @GeneratedValue 
    @Column(name="idPlanning")
    private Integer idPlanning;
    
    @Column(name="idOT")
    private Integer idOT;
    
    @Column(name="idRessource")
    private String idResource;
    
    @Column(name="noSem")
    private Integer noSem;
    
    @Column(name="chargePlanning")
    private Double chargePlanning;
    
    @Column(name="equipePlanning")
    private String equipePlanning;
    
    @Column(name="dateModif")
    private Date dateModif;
    
    @Column(name="userModif")
    private String userModif;
    
    public CufPlanning(){
        super();
    }

    public Integer getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Integer getIdOT() {
        return idOT;
    }

    public void setIdOT(Integer idOT) {
        this.idOT = idOT;
    }

    public String getIdResource() {
        return idResource;
    }

    public void setIdResource(String idResource) {
        this.idResource = idResource;
    }

    public Integer getNoSem() {
        return noSem;
    }

    public void setNoSem(Integer noSem) {
        this.noSem = noSem;
    }

    public Double getChargePlanning() {
        return chargePlanning;
    }

    public void setChargePlanning(Double chargePlanning) {
        this.chargePlanning = chargePlanning;
    }

    public String getEquipePlanning() {
        return equipePlanning;
    }

    public void setEquipePlanning(String equipePlanning) {
        this.equipePlanning = equipePlanning;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
    }
    
    
    
    
    
    
    
    
}
