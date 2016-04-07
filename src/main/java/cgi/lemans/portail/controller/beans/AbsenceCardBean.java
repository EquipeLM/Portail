package cgi.lemans.portail.controller.beans;

import java.util.Date;

/**
 * @author gautierfa
 *
 */
public class AbsenceCardBean{

	private String dateProchainConges;
	private String dateFinProchainConges;
	private String dureeProchainConges;
	private String soldeConges;
	private String soldesQun;
	private String soldesQdeux;
	private String congesConsomme;
	private String rttQunConsomme;
	private String rttQdeuxConsomme;
    private String idTypeAbsence;
    private Date datePremierJour;
    private Date dateFin;
    private String nombreJours;
    private String typeAbsence;
    private String typeJournee;
    private String typeJourneeDebut;
    private String typeJourneeFin;
    private String isPoseSurPeriode;
    private String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    
	public String getDateProchainConges() {
		return dateProchainConges;
	}
	public void setDateProchainConges(String dateProchainConges) {
		this.dateProchainConges = dateProchainConges;
	}
	public String getDureeProchainConges() {
		return dureeProchainConges;
	}
	public void setDureeProchainConges(String dureeProchainConges) {
		this.dureeProchainConges = dureeProchainConges;
	}
	public String getSoldeConges() {
		return soldeConges;
	}
	public void setSoldeConges(String soldeConges) {
		this.soldeConges = soldeConges;
	}
	public String getSoldesQun() {
		return soldesQun;
	}
	public void setSoldesQun(String soldesQun) {
		this.soldesQun = soldesQun;
	}
	public String getSoldesQdeux() {
		return soldesQdeux;
	}
	public void setSoldesQdeux(String soldesQdeux) {
		this.soldesQdeux = soldesQdeux;
	}
	public String getCongesConsomme() {
		return congesConsomme;
	}
	public void setCongesConsomme(String congesConsomme) {
		this.congesConsomme = congesConsomme;
	}
	public String getRttQunConsomme() {
		return rttQunConsomme;
	}
	public void setRttQunConsomme(String rttQunConsomme) {
		this.rttQunConsomme = rttQunConsomme;
	}
	public String getRttQdeuxConsomme() {
		return rttQdeuxConsomme;
	}
	public void setRttQdeuxConsomme(String rttQdeuxConsomme) {
		this.rttQdeuxConsomme = rttQdeuxConsomme;
	}
	public String getIdTypeAbsence() {
            return idTypeAbsence;
    }
    public void setIdTypeAbsence(String idTypeAbsence) {
        this.idTypeAbsence = idTypeAbsence;
    }

    public Date getDatePremierJour() {
        return datePremierJour;
    }

    public void setDatePremierJour(Date datePremierJour) {
        this.datePremierJour = datePremierJour;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(String nombreJours) {
        this.nombreJours = nombreJours;
    }

    public String getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(String typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    public String getTypeJournee() {
        return typeJournee;
    }

    public void setTypeJournee(String typeJournee) {
        this.typeJournee = typeJournee;
    }

	public String getDateFinProchainConges() {
		return dateFinProchainConges;
	}

	public void setDateFinProchainConges(String dateFinProchainConges) {
		this.dateFinProchainConges = dateFinProchainConges;
	}

	public String getTypeJourneeDebut() {
		return typeJourneeDebut;
	}

	public void setTypeJourneeDebut(String typeJourneeDebut) {
		this.typeJourneeDebut = typeJourneeDebut;
	}

	public String getTypeJourneeFin() {
		return typeJourneeFin;
	}

	public void setTypeJourneeFin(String typeJourneeFin) {
		this.typeJourneeFin = typeJourneeFin;
	}

	public String getIsPoseSurPeriode() {
		return isPoseSurPeriode;
	}

	public void setIsPoseSurPeriode(String isPoseSurPeriode) {
		this.isPoseSurPeriode = isPoseSurPeriode;
	}
 }
