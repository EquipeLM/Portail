package cgi.lemans.portail.controller.beans;

/**
 * @author gautierfa
 *
 */
public class IconesCardBean {
	
	private Long idIcone;
	private String classStyle;
	private String hrefLien;
	private String titre;
	
	public String getClassStyle() {
		return classStyle;
	}
	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}
	public String getHrefLien() {
		return hrefLien;
	}
	public void setHrefLien(String hrefLien) {
		this.hrefLien = hrefLien;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Long getIdIcone() {
		return idIcone;
	}
	public void setIdIcone(Long idIcone) {
		this.idIcone = idIcone;
	}
}
