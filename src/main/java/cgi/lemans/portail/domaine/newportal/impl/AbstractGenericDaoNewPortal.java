package cgi.lemans.portail.domaine.newportal.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cgi.lemans.portail.domaine.impl.AbstractGenericDao;

@Component
public abstract class AbstractGenericDaoNewPortal<T> extends AbstractGenericDao<T>{
    
	@Autowired
	@Qualifier("sessionFactoryNewPortal")
	private SessionFactory sessionFactory;

	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
}
