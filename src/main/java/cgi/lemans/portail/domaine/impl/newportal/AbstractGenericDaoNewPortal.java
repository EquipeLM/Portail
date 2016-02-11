package cgi.lemans.portail.domaine.impl.newportal;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.impl.AbstractGenericDao;

@Component
public abstract class AbstractGenericDaoNewPortal<T> extends AbstractGenericDao<T> implements IGenericDao<Serializable, T>{
    
	@Autowired
	@Qualifier("sessionFactoryNewPortal")
	private SessionFactory sessionFactory;
}
