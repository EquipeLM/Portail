/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author souchul
 */

@Entity
@Table(name="ressource_tma") 
public class RessourceTma extends EntiteGamaweb{
 
    /**
	 * 
	 */
    private static final long serialVersionUID = 6313687676033434806L;
    
    @Id
    @Column(name="IdRessource")
    private String idRessource;
    
    @Column(name="Nom")
    private String nom;
    
    @Column(name="Prenom")
    private String prenom;
    
    @Column(name="Fonction")
    private String fonction;
    
    @Column(name="Equipe")
    private String equipe;
    
    @Column(name="Date_Arrivee")
    private Date dateArrivee;
    
    @Column(name="Date_Depart")
    private Date dateDepart;
    
    @Column(name="Login")
    private String login;
    
    @Column(name="IdGroupe")
    private int idGroupe;
    
    @Column(name="derniereConnexion")
    private Date derniereConnexion;
    
    @Column(name="eMail")
    private String email;
    
    @Column(name="alerteMail")
    private String alertMail;
    
    @Column(name="alertOt")
    private String alertOT;
    
    @Column(name="login_Login")
    private String loginLogin;
    
    @Column(name="groupinfra")
    private String groupinfra;
    
    @Column(name="matricule")
    private String matricule;
    
    @Column(name="langue")
    private String langue;
    
    @Column(name="calendrier")
    private String calendrier;
    
    @Column(name="tags")
    private String tags;

    /*@OneToMany(mappedBy="refRessource")
    @OrderBy("idAbsence")
    private List<Absence> absences = new ArrayList<Absence>();*/

    
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
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    
    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Date getDerniereConnexion() {
        return derniereConnexion;
    }

    public void setDerniereConnexion(Date derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
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
        return "français";
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

	/*public List<Absence> getAbsences() {
		return absences;
	}


	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}*/

    
    
    
  
    
}
