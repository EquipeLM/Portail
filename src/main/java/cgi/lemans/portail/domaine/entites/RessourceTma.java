/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites;

import java.util.Date;

/**
 *
 * @author souchul
 */
public class RessourceTma {
 
    private String idRessource;
    private String nom;
    private String prenom; 
    private String fonction;
    private String equipe;
    private Date DateArrivee;
    private Date DateDepart;
    private String Login;
    private int idGroupe;
    private Date DerniereConnexion;
    private String email;
    private String alertMail;
    private String alertOT;
    private String loginLogin;
    private String groupinfra;
    private String matricule;
    private String langue;
    private String calendrier;
    private String tags;

    
    public RessourceTma() {
        super();
    }
    
    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public Date getDateArrivee() {
        return DateArrivee;
    }

    public void setDateArrivee(Date DateArrivee) {
        this.DateArrivee = DateArrivee;
    }

    public Date getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(Date DateDepart) {
        this.DateDepart = DateDepart;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Date getDerniereConnexion() {
        return DerniereConnexion;
    }

    public void setDerniereConnexion(Date DerniereConnexion) {
        this.DerniereConnexion = DerniereConnexion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlertMail() {
        return alertMail;
    }

    public void setAlertMail(String alertMail) {
        this.alertMail = alertMail;
    }

    public String getAlertOT() {
        return alertOT;
    }

    public void setAlertOT(String alertOT) {
        this.alertOT = alertOT;
    }

    public String getLoginLogin() {
        return loginLogin;
    }

    public void setLoginLogin(String loginLogin) {
        this.loginLogin = loginLogin;
    }

    public String getGroupinfra() {
        return groupinfra;
    }

    public void setGroupinfra(String groupinfra) {
        this.groupinfra = groupinfra;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(String calendrier) {
        this.calendrier = calendrier;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    
    
    
  
    
}
