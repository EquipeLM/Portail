package cgi.lemans.portail.domaine.newportal;

import java.io.Serializable;
import java.util.List;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.entites.newportal.IconesByUser;

/**
 * @author gautierfa
 *
 */
public interface IIconesByUserDao extends IGenericDao<Serializable, IconesByUser> {
	
	/**
	 * @param user
	 * @return
	 */
	public IconesByUser getLastIconeByUser(String user);
	
	/**
	 * @param user
	 * @return
	 */
	public List<IconesByUser> getIconesPlusUtilises(String user);
	
	/**
	 * @param idIcone
	 * @param IdIcone
	 * @return
	 */
	public IconesByUser getIconeByUser(String idIcone, String idUser);
}
