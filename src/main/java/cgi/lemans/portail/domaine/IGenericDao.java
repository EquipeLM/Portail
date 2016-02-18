package cgi.lemans.portail.domaine;

import java.io.Serializable;

/**
 * @author gautierfa
 *
 * @param <Serializable>
 * @param <T>
 */
public interface IGenericDao<PK extends Serializable, T> {
	
	T create(T t);

	void delete(T entity);

	T find(Long id);

	T update(T t);

}
