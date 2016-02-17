package cgi.lemans.portail.domaine;

/**
 * @author gautierfa
 *
 * @param <Serializable>
 * @param <T>
 */
public interface IGenericDao<Serializable, T> {
	
	T create(T t);

	void delete(T entity);

	T find(Long id);

	T update(T t);

}
