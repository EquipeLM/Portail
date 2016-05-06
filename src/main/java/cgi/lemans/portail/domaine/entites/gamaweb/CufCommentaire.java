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
@Table(name="cuf_commentaire")
public class CufCommentaire extends EntiteGamaweb{
    
    @Id 
    @GeneratedValue 
    @Column(name="idCommentaire")
    private Integer idCommentaire;
    
    @Column(name="idOT")
    private Integer idOT;
    
    @Column(name="commentaire")
    private String commentaire;
    
    @Column(name="modifiePar")
    private String modifierPar;
    
    @Column(name="modifieLe")
    private Date modifieLe;
    
    public CufCommentaire(){
        super();
    }

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Integer idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public Integer getIdOT() {
        return idOT;
    }

    public void setIdOT(Integer idOT) {
        this.idOT = idOT;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public Date getModifieLe() {
        return modifieLe;
    }

    public void setModifieLe(Date modifieLe) {
        this.modifieLe = modifieLe;
    }
    
    
    
   
    
    
    
}
