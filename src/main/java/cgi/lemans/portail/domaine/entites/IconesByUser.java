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
public class IconesByUser {
    
    private String user;
    private int idIcone;
    private int cpt;
    private boolean isDernier;
    
    public IconesByUser() {
        super();
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public int getIdIcone() {
        return idIcone;
    }
    
    public void setIdIcone(int idIcone) {
        this.idIcone = idIcone;
    }
    
    public int getCpt() {
        return cpt;
    }
    
    public void setCpt(int cpt) {
        this.cpt = cpt;
    }
    
    public boolean isIsDernier() {
        return isDernier;
    }
    
    public void setIsDernier(boolean isDernier) {
        this.isDernier = isDernier;
    }
    
    
}
