/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller.beans;

import java.util.List;

/**
 *
 * @author souchul
 */
public class AbsenceEquipeBean {
    
    private String trigramme;
    private String nom;
    private String prenom;
    private List<EventAbsenceEquipeBean> listEvent;

    public String getTrigramme() {
        return trigramme;
    }

    public void setTrigramme(String trigramme) {
        this.trigramme = trigramme;
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

    public List<EventAbsenceEquipeBean> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<EventAbsenceEquipeBean> listEvent) {
        this.listEvent = listEvent;
    }
    
    
    
    
	
}
