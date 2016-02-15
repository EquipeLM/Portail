/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.entites.gamaweb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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

    @OneToMany(mappedBy="refRessource")
    @OrderBy("idAbsence")
    private List<Absence> absences = new ArrayList<Absence>();

    
    public RessourceTma() {
        super();
    }
    
    
    @Column(name="IdRessource")
    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    @Column(name="Nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Column(name="Prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name="Fonction")
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    @Column(name="Equipe")
    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Column(name="Date_Arrivee")
    public Date getDateArrivee() {
        return DateArrivee;
    }

    public void setDateArrivee(Date DateArrivee) {
        this.DateArrivee = DateArrivee;
    }

    @Column(name="Date_Depart")
    public Date getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(Date DateDepart) {
        this.DateDepart = DateDepart;
    }

    @Column(name="Login")
    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    @Column(name="IdGroupe")
    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    @Column(name="derniereConnexion")
    public Date getDerniereConnexion() {
        return DerniereConnexion;
    }

    public void setDerniereConnexion(Date DerniereConnexion) {
        this.DerniereConnexion = DerniereConnexion;
    }

    @Column(name="eMail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="alerteMail")
    public String getAlertMail() {
        return alertMail;
    }

    public void setAlertMail(String alertMail) {
        this.alertMail = alertMail;
    }

    @Column(name="alertOT")
    public String getAlertOT() {
        return alertOT;
    }

    public void setAlertOT(String alertOT) {
        this.alertOT = alertOT;
    }

    @Column(name="login_Login")
    public String getLoginLogin() {
        return loginLogin;
    }

    public void setLoginLogin(String loginLogin) {
        this.loginLogin = loginLogin;
    }

    @Column(name="groupinfra")
    public String getGroupinfra() {
        return groupinfra;
    }

    public void setGroupinfra(String groupinfra) {
        this.groupinfra = groupinfra;
    }

    @Column(name="matricule")
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Column(name="langue")
    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Column(name="calendrier")
    public String getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(String calendrier) {
        this.calendrier = calendrier;
    }

    @Column(name="tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

	public List<Absence> getAbsences() {
		return absences;
	}


	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

    
    
    
  
    
}
