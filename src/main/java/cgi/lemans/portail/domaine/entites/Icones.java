/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;



/**
 *
 * @author souchul
 */
public class Icones {
    
    private int idIcone;
    private String texte;
    private String icone;
    private String lien;
     
    //@OneToMany(mappedBy="icones",cascade=CascadeType.PERSIST)
    
    public Icones() {
        super();
    }
    
    public int getIdIcone() {
        return idIcone;
    }
    
    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }
    
    public String getTexte() {
        return texte;
    }
    
    public void setTexte(String texte) {
        this.texte = texte;
    }
    
    public String getIcone() {
        return icone;
    }
    
    public void setIcone(String icone) {
        this.icone = icone;
    }
    
    public String getLien() {
        return lien;
    }
    
    public void setLien(String lien) {
        this.lien = lien;
    }
     
  
     
      
    
}
