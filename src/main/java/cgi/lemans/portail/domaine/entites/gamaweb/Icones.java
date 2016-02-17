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
@Table(name="icones")
public class Icones extends EntiteGamaweb{
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3595768204443605968L;
	private int idIcone;
    private String texte;
    private String icone;
    private String lien;
     
    //@OneToMany(mappedBy="icones",cascade=CascadeType.PERSIST)
    
    public Icones() {
        super();
    }
    
    
    @Id @GeneratedValue
    @Column(name="id_icone")
    public int getIdIcone() {
        return idIcone;
    }
    
    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }
    
    @Column(name="texte")
    public String getTexte() {
        return texte;
    }
    
    public void setTexte(String texte) {
        this.texte = texte;
    }
    
    @Column(name="icone")
    public String getIcone() {
        return icone;
    }
    
    public void setIcone(String icone) {
        this.icone = icone;
    }
    
    @Column(name="lien")
    public String getLien() {
        return lien;
    }
    
    public void setLien(String lien) {
        this.lien = lien;
    }
     
  
     
      
    
}
