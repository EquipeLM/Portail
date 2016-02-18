package cgi.lemans.portail.domaine.entites.newportal;

import java.io.Serializable;

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
@Table(name="icones_by_user")
public class IconesByUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3822984429482480310L;
	
	@Id
	@GeneratedValue
	@Column(name="id_icones_by_user")
	private Long idIconesByUser;
	@Column
	private String user;
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="id_icone")
	private Icones icone;
	@Column
	private Integer cpt;
	@Column(name="is_dernier")
	private Boolean isDernier;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Icones getIcone() {
		return icone;
	}
	public void setIcone(Icones icone) {
		this.icone = icone;
	}
	public Integer getCpt() {
		return cpt;
	}
	public void setCpt(Integer cpt) {
		this.cpt = cpt;
	}
	public Boolean getIsDernier() {
		return isDernier;
	}
	public void setIsDernier(Boolean isDernier) {
		this.isDernier = isDernier;
	}
	public Long getIdIconesByUser() {
		return idIconesByUser;
	}
	public void setIdIconesByUser(Long idIconesByUser) {
		this.idIconesByUser = idIconesByUser;
	}
	
	
}
