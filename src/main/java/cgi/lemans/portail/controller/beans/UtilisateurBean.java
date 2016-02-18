package cgi.lemans.portail.controller.beans;

/**
 * @author gautierfa
 *
 */
public class UtilisateurBean {

	
	private String trigramme;
	private String password;
	
	public String getTrigramme() {
		return "BJA";
	}
//	public String getTrigramme() {
//		return trigramme;
//	}
	public void setTrigramme(String trigramme) {
		this.trigramme = trigramme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
