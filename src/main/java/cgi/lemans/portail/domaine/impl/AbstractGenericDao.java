package cgi.lemans.portail.domaine.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cgi.lemans.portail.domaine.IGenericDao;

public abstract class AbstractGenericDao<T> implements IGenericDao<Serializable, T>{
    
	@Autowired
	private SessionFactory sessionFactory;
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractGenericDao(){
    	Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistentClass = (Class<T>) pt.getActualTypeArguments()[1];
    }
     
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 

	@Override
    public T create(final T t) {
        getSession().persist(t);
        return t;
    }

    @Override
    public void delete(T entity) {
    	getSession().delete(entity);
    }

	@SuppressWarnings("unchecked")
	@Override
    public T find(Long id) {
        return  (T) getSession().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T update(T t) {
        return (T) getSession().merge(t);    
    }
}
