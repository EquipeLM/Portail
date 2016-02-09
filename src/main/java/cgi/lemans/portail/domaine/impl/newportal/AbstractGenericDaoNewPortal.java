package cgi.lemans.portail.domaine.impl.newportal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cgi.lemans.portail.domaine.IGenericDao;
import cgi.lemans.portail.domaine.impl.AbstractGenericDao;

@Component
public abstract class AbstractGenericDaoNewPortal<T> extends AbstractGenericDao<T> implements IGenericDao<Serializable, T>{
    
	@Autowired
	private SessionFactory sessionFactoryNewPortal;
     
    protected Session getSession(){
        return sessionFactoryNewPortal.getCurrentSession();
    }
}
