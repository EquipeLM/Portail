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
public class EventAbsenceEquipeBean {
    
    private int id;
    private String text;
    private String dateDebut;
    private String dateFin;
    private String numMoisDebut;
    private String numMoisFin;
    private String annee;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

	public String getNumMoisDebut() {
		return numMoisDebut;
	}

	public void setNumMoisDebut(String numMoisDebut) {
		this.numMoisDebut = numMoisDebut;
	}

	public String getNumMoisFin() {
		return numMoisFin;
	}

	public void setNumMoisFin(String numMoisFin) {
		this.numMoisFin = numMoisFin;
	}

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
        
    
            
}
