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
@Table(name="jalon_demande")
public class JalonDemande {
    
    @Id 
    @GeneratedValue 
    @Column(name="id_jalon_demande")
    private Integer idJalonDemande;
    
    @Column(name="id_jalon")
    private Integer idJalon;
    
    @Column(name="id_demande")
    private String idDemande;
    
    @Column(name="date_jalon")
    private Date dateJalon;
    
    public JalonDemande(){
        super();
    }

    public Integer getIdJalonDemande() {
        return idJalonDemande;
    }

    public void setIdJalonDemande(Integer idJalonDemande) {
        this.idJalonDemande = idJalonDemande;
    }

    public Integer getIdJalon() {
        return idJalon;
    }

    public void setIdJalon(Integer idJalon) {
        this.idJalon = idJalon;
    }

    public String getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public Date getDateJalon() {
        return dateJalon;
    }

    public void setDateJalon(Date dateJalon) {
        this.dateJalon = dateJalon;
    }
    
        
   
    
}
