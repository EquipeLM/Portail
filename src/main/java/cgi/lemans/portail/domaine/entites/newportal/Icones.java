package cgi.lemans.portail.domaine.entites.newportal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gautierfa
 *
 */
@Entity
@Table(name="icones")
public class Icones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888814964449553543L;
	
	@Id
	@GeneratedValue
	@Column(name="id_icone")
	private Long idIcone;
	@Column
	private String text;
	@Column
	private String icone;
	@Column
	private String lien;
	public Long getIdIcone() {
		return idIcone;
	}
	public void setIdIcone(Long idIcone) {
		this.idIcone = idIcone;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	
}
