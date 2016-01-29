/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

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
@Table(name="icones_by_user")
public class IconesByUser {
    
    private String user;
    private int idIcone;
    private int cpt;
    private boolean isDernier;
    
    public IconesByUser() {
        super();
    }
    
    @Column(name="user")
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    @Id @GeneratedValue
    @Column(name="id_icone")
    public int getIdIcone() {
        return idIcone;
    }
    
    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }
    
    @Column(name="cpt")
    public int getCpt() {
        return cpt;
    }
    
    public void setCpt(int cpt) {
        this.cpt = cpt;
    }
    
    @Column(name="is_dernier")
    public boolean isIsDernier() {
        return isDernier;
    }
    
    public void setIsDernier(boolean isDernier) {
        this.isDernier = isDernier;
    }
    
    
}
