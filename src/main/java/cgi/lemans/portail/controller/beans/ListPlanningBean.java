/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller.beans;

/**
 *
 * @author souchul
 */
public class ListPlanningBean {
 
    private int id;
    private int semaine;
    private int idOt;
    private String trigramme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public int getIdOt() {
        return idOt;
    }

    public void setIdOt(int idOt) {
        this.idOt = idOt;
    }

    public String getTrigramme() {
        return trigramme;
    }

    public void setTrigramme(String trigramme) {
        this.trigramme = trigramme;
    }
    
    
    
}
