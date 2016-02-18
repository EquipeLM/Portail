package cgi.lemans.portail.domaine.newportal.impl;

import java.util.List;

import org.hibernate.Query;

import cgi.lemans.portail.domaine.entites.newportal.IconesByUser;
import cgi.lemans.portail.domaine.newportal.IIconesByUserDao;

/**
 * @author gautierfa
 *
 */
public class IconesByUserDao extends AbstractGenericDaoNewPortal<IconesByUser> implements IIconesByUserDao {

	@Override
	public IconesByUser getLastIconeByUser(String user) {
		String hql = "from IconesByUser iu where iu.user = :user and iu.icones.isDernier = 1 ";
        Query query = getSession().createQuery(hql);
        query.setString("user", user);
        query.setMaxResults(1);
        IconesByUser dernierIcone = (IconesByUser) query.uniqueResult();
		return dernierIcone;
	}

	@Override
	public List<IconesByUser> getIconesPlusUtilises(String user) {
		String hql = "from IconesByUser iu where iu.user = :user and iu.icones.isDernier = 1 order by iu.cpt desc ";
        Query query = getSession().createQuery(hql);
        query.setString("user", user);
        query.setMaxResults(3);
        List<IconesByUser> icones = (List<IconesByUser>) query.list();
		return icones;
	}

	@Override
	public IconesByUser getIconeByUser(String idIcone, String idUser) {
		String hql = "from IconesByUser iu where iu.user = :idUser and iu.icones.idIcone = :idIcone ";
        Query query = getSession().createQuery(hql);
        query.setString("idIcone", idIcone);
        query.setString("idUser", idUser);
        query.setMaxResults(1);
		return (IconesByUser) query.uniqueResult();
	}

}
