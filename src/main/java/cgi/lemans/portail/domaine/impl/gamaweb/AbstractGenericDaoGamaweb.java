package cgi.lemans.portail.domaine.impl.gamaweb;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.impl.AbstractGenericDao;

/**
 * @author gautierfa
 *
 * @param <T>
 */
@Component
public abstract class AbstractGenericDaoGamaweb<T> extends AbstractGenericDao<T> implements IGenericDao<Serializable, T>{
    
	@Autowired
	@Qualifier("sessionFactoryGamaweb")
	private SessionFactory sessionFactory;
}
