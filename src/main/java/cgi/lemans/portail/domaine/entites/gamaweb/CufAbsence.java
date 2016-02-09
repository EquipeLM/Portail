package cgi.lemans.portail.domaine.entites.gamaweb;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @author gautierfa
 *
 */
@Entity(name = "cuf_absence")
public class CufAbsence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414273484714404204L;
	
	private Integer idCufAbsence;
	private Absence abscence;
	private RessourceTma ressource;
	private TypeAbsence typeAbsence;
	private Integer jour;
	private Integer annee;
	private Integer semaine;
	private Date dateAbsence;
	private Integer nombreDeJour;
	private String commentaire;
	public Integer getIdCufAbsence() {
		return idCufAbsence;
	}
	public void setIdCufAbsence(Integer idCufAbsence) {
		this.idCufAbsence = idCufAbsence;
	}
	public Absence getAbscence() {
		return abscence;
	}
	public void setAbscence(Absence abscence) {
		this.abscence = abscence;
	}
	public RessourceTma getRessource() {
		return ressource;
	}
	public void setRessource(RessourceTma ressource) {
		this.ressource = ressource;
	}
	public TypeAbsence getTypeAbsence() {
		return typeAbsence;
	}
	public void setTypeAbsence(TypeAbsence typeAbsence) {
		this.typeAbsence = typeAbsence;
	}
	public Integer getJour() {
		return jour;
	}
	public void setJour(Integer jour) {
		this.jour = jour;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	public Integer getSemaine() {
		return semaine;
	}
	public void setSemaine(Integer semaine) {
		this.semaine = semaine;
	}
	public Date getDateAbsence() {
		return dateAbsence;
	}
	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}
	public Integer getNombreDeJour() {
		return nombreDeJour;
	}
	public void setNombreDeJour(Integer nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
}
