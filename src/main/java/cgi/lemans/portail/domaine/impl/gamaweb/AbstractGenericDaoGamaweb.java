package cgi.lemans.portail.domaine.impl.gamaweb;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	private SessionFactory sessionFactoryGamaweb;
 
    protected Session getSession(){
        return sessionFactoryGamaweb.getCurrentSession();
    }
 
}
