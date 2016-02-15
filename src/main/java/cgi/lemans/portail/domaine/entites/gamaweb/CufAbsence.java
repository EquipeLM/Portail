package cgi.lemans.portail.domaine.entites.gamaweb;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author gautierfa
 *
 */
@Entity
@Table(name = "cuf_absence")
public class CufAbsence extends EntiteGamaweb {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414273484714404204L;
	
	@Id
	@GeneratedValue
	@Column(name="ID_CUF_ABSENCE")
	private Integer idCufAbsence;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Absence abscence;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="RESSOURCE")
	private RessourceTma ressource;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="REF_TYPE_ABSENCE")
	private TypeAbsence typeAbsence;
	
	@Column(name="JOUR")
	private Integer jour;
	
	@Column(name="MOIS")
	private Integer mois;
	
	@Column(name="SEMAINE")
	private Integer semaine;
	
	@Column(name="ANNEE")
	private Integer annee;
	
	@Column(name="DATE_ABSENCE")
	private Date dateAbsence;
	
	@Column(name="NOMBRE_JOUR")
	private Integer nombreDeJour;
	
	@Column(name="COMMENTAIRE")
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
	public Integer getMois() {
		return mois;
	}
	public void setMois(Integer mois) {
		this.mois = mois;
	}
	
	
}
