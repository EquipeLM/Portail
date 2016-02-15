package cgi.lemans.portail.domaine.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cgi.lemans.portail.domaine.IGenericDao;

public abstract class AbstractGenericDao<T> implements IGenericDao<Serializable, T>{
    
    protected final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractGenericDao(){
    	Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
    }
     
 
    protected abstract Session getSession();
 

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
