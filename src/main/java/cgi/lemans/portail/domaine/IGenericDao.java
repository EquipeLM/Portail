package cgi.lemans.portail.domaine;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface IGenericDao<Serializable, T> {
	
	T create(T t);

	void delete(T entity);

	T find(Long id);

	T update(T t);

}
