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
@Table(name="cuf_est_traite_pendant")
public class CufEstTraitePendant extends EntiteGamaweb {
    
    @Id 
    @GeneratedValue 
    @Column(name="IdOT")
    private Integer idOT;
    
    @Column(name="Date_imputation")
    private Date dateImputation;
    
    @Column(name="charge_consommee")
    private Double chargeConsomme;
    
    @Column(name="charge_restante")
    private Double chargeRestante;
    
    @Column(name="IdImputation")
    private Integer idImputation;
    
    @Column(name="comentaire_RAF")
    private String commentaireRAF;
    
    @Column(name="cout")
    private Double cout;
    
    @Column(name="cout_restant")
    private Double coutRestant;
    
    public CufEstTraitePendant(){
        super();
    }

    public Integer getIdOT() {
        return idOT;
    }

    public void setIdOT(Integer idOT) {
        this.idOT = idOT;
    }

    public Date getDateImputation() {
        return dateImputation;
    }

    public void setDateImputation(Date dateImputation) {
        this.dateImputation = dateImputation;
    }

    public Double getChargeConsomme() {
        return chargeConsomme;
    }

    public void setChargeConsomme(Double chargeConsomme) {
        this.chargeConsomme = chargeConsomme;
    }

    public Double getChargeRestante() {
        return chargeRestante;
    }

    public void setChargeRestante(Double chargeRestante) {
        this.chargeRestante = chargeRestante;
    }

    public Integer getIdImputation() {
        return idImputation;
    }

    public void setIdImputation(Integer idImputation) {
        this.idImputation = idImputation;
    }

    public String getCommentaireRAF() {
        return commentaireRAF;
    }

    public void setCommentaireRAF(String commentaireRAF) {
        this.commentaireRAF = commentaireRAF;
    }

    public Double getCout() {
        return cout;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    public Double getCoutRestant() {
        return coutRestant;
    }

    public void setCoutRestant(Double coutRestant) {
        this.coutRestant = coutRestant;
    }
    
    
    
}
