package cgi.lemans.portail.domaine.gamaweb.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cgi.lemans.portail.domaine.impl.AbstractGenericDao;

/**
 * @author gautierfa
 *
 * @param <T>
 */
@Component
public abstract class AbstractGenericDaoGamaweb<T> extends AbstractGenericDao<T> {
    
	@Autowired
	@Qualifier("sessionFactoryGamaweb")
	private SessionFactory sessionFactory;

	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
	
}
